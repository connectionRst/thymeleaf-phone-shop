package com.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Banner;
import com.pojo.Good;
import com.pojo.result.Result;
import com.pojo.result.ResultPage;
import com.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

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
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @PostMapping("/add")
    public Result add(Banner banner) {
        return Result.decide(bannerService.save(banner));
    }

    @PostMapping("/update")
    public Result update(Banner banner) {
        return Result.decide(bannerService.updateById(banner));
    }

    @PostMapping("/getOne")
    public Result getOne(@RequestParam(value = "id") String id) {
        return Result.success(bannerService.getById(id));
    }

    @RequestMapping("/getAll")
    public ResultPage getAll(@RequestParam(value = "name", required = false) String name,
                             @RequestParam(value = "page") Integer page,
                             @RequestParam(value = "limit") Integer limit) {
        //分页条件
        PageHelper.startPage(page, limit);
        LambdaQueryWrapper<Banner> queryWrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(name)) {
            queryWrapper.like(Banner::getName, name);
        }
        List<Banner> bannerList = bannerService.list(queryWrapper);
        PageInfo<Banner> bannerPageInfo = new PageInfo<>(bannerList, limit);
        return new ResultPage(0, (int) bannerPageInfo.getTotal(), bannerPageInfo.getList());
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam(value = "id") String id) {
        return Result.decide(bannerService.removeById(id));
    }


}

