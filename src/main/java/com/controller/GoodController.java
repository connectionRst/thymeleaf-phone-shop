package com.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.common.utils.DateUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Comment;
import com.pojo.Good;
import com.pojo.User;
import com.pojo.result.Result;
import com.pojo.result.ResultPage;
import com.service.CommentService;
import com.service.GoodService;
import com.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 * 积分物品表 前端控制器
 * </p>
 *
 * @author chen
 * @since 2022-01-30
 */
@RestController
@RequestMapping("/good")
public class GoodController {

    @Autowired
    private GoodService goodService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    //添加商品
    @PostMapping("/add")
    public Result add(Good good) {
        //验证表单信息
        // TODO 验证用户合法性
        // FIXME 待测试
        User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
        if (currentUser == null || currentUser.getId().equals(good.getShangjiaId())) {
            return Result.failure("商家不合法");
        }
        if (goodService.getOne(new LambdaQueryWrapper<Good>().eq(Good::getName, good.getName())) != null) {
            return Result.failure("已有相同名称的商品，请重新命名");
        } else {
            return Result.decide(goodService.save(good));
        }
    }

    //删除商品
    @PostMapping("/delete")
    public Result delete(@RequestParam(value = "id") String id) {
        return Result.decide(goodService.removeById(id));
    }

    //修改商品
    @PostMapping("/update")
    public Result update(Good good) {
        Good currentGood = goodService.getById(good.getId());
        //验证表单信息
        if (goodService.getOne(new LambdaQueryWrapper<Good>().eq(Good::getName, good.getName())) != null
                && !good.getName().equals(currentGood.getName())) {
            return Result.failure("已有相同名称的商品，请重新命名");
        } else {
            return Result.decide(goodService.updateById(good));
        }
    }

    //根据id获取商品
    @PostMapping("/getOne")
    public Result getOne(@RequestParam(value = "id") String id) {
        return Result.success(goodService.getById(id));
    }

    //条件分页获取分类
    @RequestMapping("/getAll")
    public ResultPage getAll(@RequestParam(value = "name", required = false) String name,
                             @RequestParam(value = "categoryId", required = false) String categoryId,
                             @RequestParam(value = "page") Integer page,
                             @RequestParam(value = "limit") Integer limit) {
        //分页条件
        PageHelper.startPage(page, limit);
        List<Good> bookList = goodService.getAll(name, categoryId);
        PageInfo<Good> goodPageInfo = new PageInfo<>(bookList, limit);
        return new ResultPage(0, (int) goodPageInfo.getTotal(), goodPageInfo.getList());
    }

    @RequestMapping("/shangjiaGetAll")
    public ResultPage shangjiaGetAll (@RequestParam(value = "name", required = false) String name,
                             @RequestParam(value = "categoryId", required = false) String categoryId,
                             @RequestParam(value = "page") Integer page,
                             @RequestParam(value = "limit") Integer limit) {
        //分页条件
        PageHelper.startPage(page, limit);
        User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
        System.out.println("---------->>>>> 商家：" + currentUser.getName());
        List<Good> bookList = goodService.shangjiaGetAll(name, categoryId, currentUser.getId());
        PageInfo<Good> goodPageInfo = new PageInfo<>(bookList, limit);
        return new ResultPage(0, (int) goodPageInfo.getTotal(), goodPageInfo.getList());
    }

    //前台获取全部商品
    @RequestMapping("/getAllGood")
    public ModelAndView getAllGood(String goodName, String categoryId) {
        ModelAndView mv = new ModelAndView();
        LambdaQueryWrapper<Good> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Good::getStatus, 1);
        if (!StringUtils.isEmpty(goodName)) {
            queryWrapper.like(Good::getName, goodName);
        }
        if (!StringUtils.isEmpty(categoryId)) {
            queryWrapper.like(Good::getCategoryId, categoryId);
        }
        mv.addObject("goodList", goodService.list(queryWrapper));
        mv.setViewName("index/goodList.html");
        return mv;
    }

    //前台获取商品详情信息
    @RequestMapping("/getGoodDetail")
    public ModelAndView getGoodDetail(String goodId) {
        ModelAndView mv = new ModelAndView();
        //商品信息
        mv.addObject("good", goodService.getById(goodId));
        //评论信息
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Comment::getGoodId, goodId);
        List<Comment> ls = commentService.list(queryWrapper);
        for (Comment comment : ls) {
            User user = userService.getById(comment.getUserId());
            comment.setUserAvatar(user.getAvatar());
            comment.setUserName(user.getName());
            comment.setFmtDateTime(DateUtils.dateFmt(comment.getCreateTime()));
        }
        mv.addObject("commentList", ls);
        mv.setViewName("index/goodDetail.html");
        return mv;
    }
}

