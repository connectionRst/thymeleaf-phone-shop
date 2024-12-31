package com.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pojo.User;
import com.pojo.result.Result;
import com.pojo.result.ResultPage;
import com.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.regex.Pattern;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author chen
 * @since 2022-01-30
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //分页条件查询用户信息
    @RequestMapping("/getAll")
    public ResultPage getAll(User user,
                             @RequestParam(value = "page") Integer page,
                             @RequestParam(value = "limit") Integer limit) {
        //查询条件
        LambdaQueryWrapper<User> userWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.hasText(user.getName())) {
            userWrapper.like(User::getName, user.getName());
        }
        if (StringUtils.hasText(user.getPhone())) {
            userWrapper.eq(User::getPhone, user.getPhone());
        }
        //分页条件
        Page<User> userPage = new Page<>(page, limit);
        IPage<User> pageData = userService.page(userPage, userWrapper);
        return new ResultPage(0, (int) pageData.getTotal(), pageData.getRecords());
    }

    //通过id获取用户信息
    @PostMapping("/getOne")
    public Result getOne(@RequestParam(value = "id") String id) {
        return Result.success(userService.getById(id));
    }

    //更新用户信息
    @PostMapping("/update")
    public Result update(User user) {
        User editUser = userService.getById(user.getId());
        if (userService.lambdaQuery().eq(User::getPhone, user.getPhone()).list().size() > 0
                && !user.getPhone().equals(editUser.getPhone())) {
            return Result.failure("手机号码已被注册");
        } else if (userService.lambdaQuery().eq(User::getName, user.getName()).list().size() > 0
                && !user.getName().equals(editUser.getName())) {
            return Result.failure("用户名已被注册");
        } else {
            return Result.decide(userService.updateById(user));
        }
    }

    //添加用户信息
    @PostMapping("/add")
    public Result add(User user) {
        final String phone = user.getPhone();
        final String name = user.getName();
        if (!Pattern.matches("^1[3-9]\\d{9}$", phone)) {
            return Result.failure("手机号格式错误，目前只支持13位大陆手机号");
        }
        if (userService.lambdaQuery().eq(User::getPhone, phone).list().size() > 0) {
            return Result.failure("手机号码已被注册");
        }  else if (userService.lambdaQuery().eq(User::getName, name).list().size() > 0) {
            return Result.failure("用户名已被注册");
        } else {
            return Result.decide(userService.save(user));
        }
    }

    //删除用户信息
    @PostMapping("/delete")
    public Result delete(@RequestParam(value = "id") String id) {
        User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
        if (currentUser.getId().equals(id)) {
            return Result.failure("不能删除您自己");
        }
        return Result.decide(userService.removeById(id));
    }

    //用户登录
    @PostMapping("/login")
    public Result login(User user) {
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(user.getPhone(), user.getPassword());
            subject.login(token);
        } catch (Exception e) {
            if (e instanceof IncorrectCredentialsException) {
                return Result.failure("密码错误，请重新登录");
            } else if (e instanceof LockedAccountException) {
                return Result.failure("该用户已被禁用，请联系管理员");
            } else if (e instanceof AuthenticationException) {
                return Result.failure("该用户不存在");
            } else {
                return Result.failure("服务器出错");
            }
        }
        return Result.success("登录成功", SecurityUtils.getSubject().getPrincipal());
    }

    //退出登录
    @GetMapping("/logout")
    public Result logout(){
        try {
            SecurityUtils.getSubject().logout();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
        return Result.success();
    }

    //修改密码
    @PostMapping("/updatePwd")
    public Result updatePwd(@RequestParam(value = "oldPassword") String oldPassword,
                            @RequestParam(value = "newPassword") String newPassword) {
        User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
        LambdaQueryWrapper<User> userWrapper = new LambdaQueryWrapper<>();
        //查询旧密码条件
        userWrapper
                .eq(User::getPassword, oldPassword)
                .eq(User::getId, currentUser.getId());
        if (userService.getOne(userWrapper) != null) {
            LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
            //更新新密码条件
            updateWrapper
                    .eq(User::getId, currentUser.getId())
                    .set(User::getPassword, newPassword);
            if (userService.update(updateWrapper)) {
                SecurityUtils.getSubject().logout();
                return Result.success("修改密码成功，请重新登录");
            } else {
                return Result.failure("修改密码失败");
            }
        } else {
            return Result.failure("原密码不对，请重新填写");
        }
    }

    //前台用户修改个人信息
    @RequestMapping("/getUserById/{userId}")
    public ModelAndView getById(@PathVariable String userId) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", userService.getById(userId));
        mv.setViewName("index/user_update.html");
        return mv;
    }
}

