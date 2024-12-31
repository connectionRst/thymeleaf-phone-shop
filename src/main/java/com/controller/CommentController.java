package com.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Comment;
import com.pojo.Good;
import com.pojo.Order;
import com.pojo.User;
import com.pojo.result.Result;
import com.pojo.result.ResultPage;
import com.service.CommentService;
import com.service.GoodService;
import com.service.OrderService;
import com.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

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
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private OrderService orderService;

    //用户评论
    @PostMapping("/add")
    public Result add(Comment comment, String orderId) {
        User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
        //获取订单商品
        Order order = orderService.getById(orderId);
        comment.setGoodId(order.getGoodId());
        comment.setUserId(currentUser.getId());
        comment.setCreateTime(new Date());
        if (commentService.save(comment)) {
            LambdaUpdateWrapper<Order> updateWrapper = new LambdaUpdateWrapper<>();
            updateWrapper
                    .eq(Order::getId, orderId)
                    .set(Order::getStatus, 4);
            orderService.update(updateWrapper);
        }
        return Result.success();
    }

    //删除
    @PostMapping("/delete")
    public Result delete(@RequestParam(value = "id") String id) {
        return Result.decide(commentService.removeById(id));
    }

    //查询所有评论
    @RequestMapping("/adminGetAll")
    public ResultPage adminGetAll(@RequestParam(value = "userName", required = false) String userName,
                                  @RequestParam(value = "goodName", required = false) String goodName,
                                  @RequestParam(value = "content", required = false) String content,
                                  @RequestParam(value = "page") Integer page,
                                  @RequestParam(value = "limit") Integer limit) {
        //分页条件
        PageHelper.startPage(page, limit);
        List<Comment> ls = commentService.getAll(userName, goodName, content);
        PageInfo<Comment> pageInfo = new PageInfo<>(ls, limit);
        return new ResultPage(0, (int) pageInfo.getTotal(), pageInfo.getList());
    }

}

