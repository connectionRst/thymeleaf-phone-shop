package com.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pojo.GoodCategory;
import com.pojo.User;
import com.pojo.result.Result;
import com.pojo.result.ResultPage;
import com.service.GoodCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Locale;

/**
 * <p>
 * 帖子分类表 前端控制器
 * </p>
 *
 * @author chen
 * @since 2022-01-30
 */
@RestController
@RequestMapping("/category")
public class GoodCategoryController {

    @Autowired
    private GoodCategoryService categoryService;

    //添加分类
    @PostMapping("/add")
    public Result add(GoodCategory category) {
        //验证表单信息
        if (categoryService.getOne(new LambdaQueryWrapper<GoodCategory>().eq(GoodCategory::getName,category.getName())) != null) {
            return Result.failure("已有相同名称的类别，请重新命名");
        } else {
            return Result.decide(categoryService.save(category));
        }
    }

    //通过id获取分类
    @RequestMapping("/getOne")
    public GoodCategory getOne(@RequestParam(value = "id") String id) {
        return categoryService.getById(id);
    }

    //删除分类
    @PostMapping("/delete")
    public Result delete(@RequestParam(value = "id") String id) {
        return Result.decide(categoryService.removeById(id));
    }

    //修改分类
    @PostMapping("update")
    public Result update(GoodCategory category) {
        GoodCategory categoryEdit = categoryService.getById(category.getId());
        //验证表单信息
        if (categoryService.getOne(new LambdaQueryWrapper<GoodCategory>().eq(GoodCategory::getName,category.getName())) != null
                && !categoryEdit.getName().equals(category.getName())) {
            return Result.failure("已有相同名称的类别，请重新命名");
        } else {
            return Result.decide(categoryService.updateById(category));
        }
    }

    //分页条件查询分类信息
    @RequestMapping("/getAll")
    public ResultPage getAll(GoodCategory category,
                             @RequestParam(value = "page") Integer page,
                             @RequestParam(value = "limit") Integer limit) {
        //查询条件
        LambdaQueryWrapper<GoodCategory> userWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.hasText(category.getName())) {
            userWrapper.like(GoodCategory::getName, category.getName());
        }
        //分页条件
        Page<GoodCategory> categoryPage = new Page<>(page, limit);
        IPage<GoodCategory> pageData = categoryService.page(categoryPage, userWrapper);
        return new ResultPage(0, (int) pageData.getTotal(), pageData.getRecords());
    }

    //获取全部分类，用于下拉框选择
    @GetMapping("/getAllCategory")
    public Result getAllCategory() {
        return Result.success(categoryService.query().list());
    }
}

