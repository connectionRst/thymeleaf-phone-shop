package com.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pojo.Collect;
import com.pojo.CollectGood;
import com.pojo.Good;
import com.pojo.User;
import com.pojo.result.Result;
import com.service.CollectService;
import com.service.GoodService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
@RequestMapping("/collect")
public class CollectController {

    @Autowired
    private CollectService collectService;

    @Autowired
    private GoodService goodService;

    //添加收藏
    @PostMapping("/add")
    public Result add(Collect collect) {
        User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
        LambdaQueryWrapper<Collect> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .eq(Collect::getUserId, currentUser.getId())
                .eq(Collect::getGoodId, collect.getGoodId());
        if (collectService.getOne(queryWrapper) != null) {
            return Result.failure("您已收藏过该商品");
        } else {
            collect.setUserId(currentUser.getId());
            return Result.decide(collectService.save(collect));
        }
    }

    //取消收藏
    @PostMapping("/delete")
    public Result delete(Collect collect) {
        User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
        LambdaQueryWrapper<Collect> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .eq(Collect::getUserId, currentUser.getId())
                .eq(Collect::getGoodId, collect.getGoodId());
        return Result.decide(collectService.remove(queryWrapper));
    }

    //获取用户收藏列表
    @RequestMapping("getAll")
    public ModelAndView getAll() {
        User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
        LambdaQueryWrapper<Collect> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .eq(Collect::getUserId, currentUser.getId());
        List<Collect> ls = collectService.list(queryWrapper);
        //遍历ls，并查询相关商品信息组合到新的list中
        List<CollectGood> collectList = new ArrayList<>();
        for (Collect collect : ls) {
            //当前收藏的商品id
            String goodId = collect.getGoodId();
            Good good = goodService.getById(goodId);
            //如果商品是下架的，就跳过，不显示在收藏列表中
            if (good.getStatus() == 2) {
                continue;
            }
            CollectGood collectGood = new CollectGood();
            collectGood.setGoodId(goodId);
            collectGood.setGoodName(good.getName());
            collectGood.setGoodImg(good.getImage());
            collectGood.setGoodStock(good.getStock());
            collectGood.setGoodStatus(good.getStatus());
            collectGood.setGoodPrice(good.getPrice());
            collectGood.setGoodSku(good.getSku());
            collectGood.setGoodRemark(good.getRemark());
            collectList.add(collectGood);
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("collectList", collectList);
        mv.setViewName("index/collectList.html");
        return mv;
    }

}

