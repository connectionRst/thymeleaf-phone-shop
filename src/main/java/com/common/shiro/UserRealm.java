package com.common.shiro;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pojo.User;
import com.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    protected static Logger logger = LoggerFactory.getLogger(UserRealm.class);

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("*=====执行授权=====*");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        logger.info("*=====执行认证=====*");
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        User currentUser ;
        //通过手机号查询用户
        currentUser = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getPhone, userToken.getUsername()));
        if (currentUser == null){
            //判断有无此用户信息
            throw new AuthenticationException();
        } else if (currentUser.getStatus() == 2) {
            //判断用户是否被禁用
            throw new LockedAccountException();
        }
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("user",currentUser);
        return new SimpleAuthenticationInfo(currentUser,currentUser.getPassword(),"");
    }
}
