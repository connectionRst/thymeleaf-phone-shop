package com.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.pojo.*;
import com.pojo.result.Result;
import com.service.CartService;
import com.service.GoodCategoryService;
import com.service.GoodService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.ArrayList;
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
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private GoodService goodService;

    @Autowired
    private GoodCategoryService goodCategoryService;

    //添加购物车
    @PostMapping("/add")
    public Result add(Cart cart) {
        User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
        LambdaQueryWrapper<Cart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .eq(Cart::getUserId, currentUser.getId())
                .eq(Cart::getGoodId, cart.getGoodId());
        Cart currentCart = cartService.getOne(queryWrapper);
        if (currentCart == null) {
            cart.setNum(1);
            cart.setUserId(currentUser.getId());
            return Result.decide(cartService.save(cart));
        } else {
            LambdaUpdateWrapper<Cart> updateWrapper = new LambdaUpdateWrapper<>();
            updateWrapper
                    .eq(Cart::getUserId, currentUser.getId())
                    .eq(Cart::getGoodId, cart.getGoodId())
                    .set(Cart::getNum, currentCart.getNum() + 1);
            return Result.decide(cartService.update(updateWrapper));
        }
    }

    //购物数量减少
    @PostMapping("/delete")
    public Result delete(Cart cart) {
        User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
        LambdaQueryWrapper<Cart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .eq(Cart::getUserId, currentUser.getId())
                .eq(Cart::getGoodId, cart.getGoodId());
        Cart currentCart = cartService.getOne(queryWrapper);
        if (currentCart.getNum() <= 1) {
            return Result.failure("不能再减了..");
        } else {
            LambdaUpdateWrapper<Cart> updateWrapper = new LambdaUpdateWrapper<>();
            updateWrapper
                    .eq(Cart::getUserId, currentUser.getId())
                    .eq(Cart::getGoodId, cart.getGoodId())
                    .set(Cart::getNum, currentCart.getNum() - 1);
            return Result.decide(cartService.update(updateWrapper));
        }
    }

    //购物数量减少
    @PostMapping("/cartDelete")
    public Result cartDelete(Cart cart) {
        return Result.decide(cartService.removeById(cart.getId()));
    }

    //获取用户购物车信息
    @RequestMapping("/getAll")
    public ModelAndView getAll() {
        User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
        LambdaQueryWrapper<Cart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .eq(Cart::getUserId, currentUser.getId());
        List<Cart> ls = cartService.list(queryWrapper);
        List<CartGood> cartList = new ArrayList<>();
        for (Cart cart : ls) {
            String goodId = cart.getGoodId();
            Good good = goodService.getById(goodId);
            if (good.getStatus() == 2) {
                continue;
            }
            GoodCategory category = goodCategoryService.getById(good.getCategoryId());
            CartGood cartGood = new CartGood();
            cartGood.setId(cart.getId());
            cartGood.setGoodId(goodId);
            cartGood.setGoodImg(good.getImage());
            cartGood.setGoodName(good.getName());
            cartGood.setUserId(cart.getUserId());
            cartGood.setGoodPrice(good.getPrice());
            cartGood.setGoodSku(good.getSku());
            cartGood.setGoodStock(good.getStock());
            cartGood.setGoodCategory(category.getName());
            cartGood.setNum(cart.getNum());
            BigDecimal a = new BigDecimal(Double.valueOf(good.getPrice()) * cart.getNum());
            cartGood.setTotalPrice(a.toString());
            cartList.add(cartGood);
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("cartList", cartList);
        mv.setViewName("index/cart.html");
        return mv;
    }

}

