package com.controller;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.common.utils.DateUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.*;
import com.pojo.result.Result;
import com.pojo.result.ResultPage;
import com.service.*;
//import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chen
 * @since 2022-01-30
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private GoodService goodService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private GoodCategoryService categoryService;

    //确认购买页面
    @RequestMapping(value = "/buy")
    public ModelAndView buy(String cartIds, String totalPrice, HttpSession session) {
        session.setAttribute("cartIds", cartIds); //保留当前购物车id
        User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
        String[] ids = cartIds.split(",");
        List<String> goodIds = new ArrayList<>(); //商品id集合
        List<Integer> nums = new ArrayList<>(); //商品数量id集合
        //购物车车id查出商品id
        List<Cart> cartList = cartService.listByIds(Arrays.asList(ids));
        for (Cart cart : cartList) {
            goodIds.add(cart.getGoodId());
            nums.add(cart.getNum());
        }
        //商品
        List<Good> goodList = goodService.listByIds(goodIds);
        for (int i = 0; i < goodList.size(); i++) {
            Good good = goodList.get(i);
            good.setGoodBuyNum(nums.get(i)); //商品购买数量
            BigDecimal a = new BigDecimal(Double.valueOf(good.getPrice()) * good.getGoodBuyNum());
            good.setGoodTotalPrice(a.toString()); //商品数量*价格
        }
        //用户地址
        List<Address> addressList = addressService.list(new LambdaQueryWrapper<Address>().eq(Address::getUserId, currentUser.getId()));
        LambdaQueryWrapper<Address> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .eq(Address::getUserId, currentUser.getId())
                .eq(Address::getDefaulted, 1);
        Address address = addressService.getOne(queryWrapper);
        ModelAndView mv = new ModelAndView();
        mv.addObject("goodList", goodList); //结算商品列表
        mv.addObject("totalPrice", totalPrice); //总价格
        mv.addObject("addressList", addressList); //地址列表
        mv.addObject("defAddress", address == null ?  (addressList.size() == 0 ? null : addressList.get(0)) : address); //默认地址
        mv.setViewName("index/buy.html");
        return mv;
    }

    //下单接口
    @RequestMapping(value = "/createOrder")
    public Result createOrder(HttpSession session) {
        return orderService.createOrder(
                (String) session.getAttribute("cartIds"),
                (User) SecurityUtils.getSubject().getPrincipal());
    }

    @RequestMapping("/getAll")
    public ModelAndView userGetAll() {
        User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
        //通过用户id查订单
        LambdaQueryWrapper<Order> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .eq(Order::getUserId, currentUser.getId());
        List<Order> orderList = orderService.list(queryWrapper);
        for (Order order : orderList) {
            Good good = goodService.getById(order.getGoodId()); //订单商品信息
            GoodCategory category = categoryService.getById(good.getCategoryId()); //商品分类信息
            order.setGoodCategory(category == null ? "其他品牌" : category.getName());
            order.setGoodName(good.getName());
            order.setGoodSku(good.getSku());
            order.setGoodImage(good.getImage());
            order.setFmtDateTime(DateUtils.dateFmt(order.getCreateTime()));
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("orderList", orderList);
        mv.setViewName("index/orderList.html");
        return mv;
    }

    @RequestMapping("/shangjiaGetAll")
    public ResultPage shangjiaGetAll(@RequestParam(value = "userName", required = false) String userName,
                                  @RequestParam(value = "goodName", required = false) String goodName,
                                  @RequestParam(value = "status", required = false) Integer status,
                                  @RequestParam(value = "page") Integer page,
                                  @RequestParam(value = "limit") Integer limit) {
        //分页条件
        PageHelper.startPage(page, limit);
        User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
        List<Order> orderList = orderService.shangjiaGetAll(userName, goodName, status, currentUser.getId());
        PageInfo<Order> orderPageInfo = new PageInfo<>(orderList, limit);
        return new ResultPage(0, (int) orderPageInfo.getTotal(), orderPageInfo.getList());
    }

    //删除订单
    @PostMapping("/delete")
    public Result delete(@RequestParam(value = "id") String id) {
        Order order = orderService.getById(id);
        if (order.getStatus() != 4) {
            return Result.failure("订单未完成，暂不能删除");
        }
        return Result.decide(orderService.removeById(id));
    }

    //管理员获取全部订单信息
    @RequestMapping("/adminGetAll")
    public ResultPage adminGetAll(@RequestParam(value = "userName", required = false) String userName,
                                  @RequestParam(value = "goodName", required = false) String goodName,
                                  @RequestParam(value = "status", required = false) Integer status,
                                  @RequestParam(value = "page") Integer page,
                                  @RequestParam(value = "limit") Integer limit) {
        //分页条件
        PageHelper.startPage(page, limit);
        List<Order> orderList = orderService.adminGetAll(userName, goodName, status);
        PageInfo<Order> orderPageInfo = new PageInfo<>(orderList, limit);
        return new ResultPage(0, (int) orderPageInfo.getTotal(), orderPageInfo.getList());
    }

    //修改订单状态
    @PostMapping("/updateStatus")
    public Result updateStatus(@RequestParam(value = "orderId") String orderId,
                               @RequestParam(value = "status") Integer status) {
        LambdaUpdateWrapper<Order> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper
                .eq(Order::getId, orderId)
                .set(Order::getStatus, status);
        return Result.decide(orderService.update(updateWrapper));
    }

}

