package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.mapper.AddressMapper;
import com.mapper.CartMapper;
import com.mapper.GoodMapper;
import com.pojo.*;
import com.mapper.OrderMapper;
import com.pojo.result.Result;
import com.service.AddressService;
import com.service.CartService;
import com.service.GoodService;
import com.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chen
 * @since 2022-01-30
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private GoodService goodService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @Override
    public Result createOrder(String cartIds, User currentUser) {
        String[] ids = cartIds.split(",");
        List<String> goodIds = new ArrayList<>(); //商品id集合
        List<Integer> nums = new ArrayList<>(); //商品数量id集合
        Address address = null; //订单地址
        //筛选默认地址
        List<Address> addressList = addressService.list((new LambdaQueryWrapper<Address>().eq(Address::getUserId, currentUser.getId())));
        if (addressList.size() == 0) {
            return  Result.failure("请添加收货地址后再下单");
        }
        LambdaQueryWrapper<Address> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .eq(Address::getUserId, currentUser.getId())
                .eq(Address::getDefaulted, 1);
        Address defAddress = addressService.getOne(queryWrapper);
        address = defAddress == null ?  (addressList.size() == 0 ? null : addressList.get(0)) : defAddress;
        //购物车车id查出商品id
        List<Cart> cartList = cartService.listByIds(Arrays.asList(ids));
        for (Cart cart : cartList) {
            goodIds.add(cart.getGoodId());
            nums.add(cart.getNum());
        }
        //查出所有商品集合
        List<Good> goodList = goodService.listByIds(goodIds);
        for (int i = 0; i < goodList.size(); i++) {
            Good good = goodList.get(i);
            //商品库存判断
            if (good.getStock() < nums.get(i)) {
                return Result.failure(String.format("商品[%s]库存不足，支付失败", good.getName()));
            }
            Order order = new Order();
            order.setUserId(currentUser.getId());
            order.setAddress(address.getProvince() + address.getCity() + address.getArea() + address.getDetail());
            order.setName(address.getName());
            order.setPhone(address.getPhone());
            order.setNum(nums.get(i));
            order.setStatus(1);
            order.setGoodId(good.getId());
            order.setTotalPrice(new BigDecimal(String.valueOf(Double.valueOf(good.getPrice()) * nums.get(i))).toString());
            order.setPrice(good.getPrice());
            order.setCreateTime(new Date());
            if (orderService.save(order)) {
                //更改商品库存
                LambdaUpdateWrapper<Good> updateWrapper = new LambdaUpdateWrapper<>();
                updateWrapper
                        .eq(Good::getId, good.getId())
                        .set(Good::getStock, good.getStock() - nums.get(i));
                goodService.update(updateWrapper);
            }
        }
        //删除购物车
        cartService.removeByIds(Arrays.asList(ids));
        return Result.success();
    }

    @Override
    public List<Order> adminGetAll(String userName, String goodName, Integer status) {
        return this.baseMapper.adminGetAll(userName, goodName, status);
    }


}
