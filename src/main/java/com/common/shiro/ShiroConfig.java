package com.common.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    public static final String ANON = "anon";

    public static final String AUTHC = "authc";

    @Bean
    public ShiroFilterFactoryBean getshiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全过滤器
        bean.setSecurityManager(securityManager);
        Map<String, String> filterMap = new LinkedHashMap<>();
        /*
        * anon: 无需验证就可以访问
        * authc: 必须认证才能访问
        * user: 必须拥有 记住我功能才能使用
        * perms：拥有对某个资源的权限才能访问
        * role：拥有某个角色权限才能访问
        * */
        //静态资源
        filterMap.put("/css/**", ANON);
        filterMap.put("/images/**", ANON);
        filterMap.put("/js/**", ANON);
        filterMap.put("/lib/**", ANON);
        filterMap.put("/api/**", ANON);
        filterMap.put("/old/**", ANON);

        //后台登录界面
        filterMap.put("/adminLogin", ANON); //前台登录页面接口
        filterMap.put("/userLogin", ANON); //前台登录页面
        filterMap.put("/register", ANON); //用户注册页面

        filterMap.put("/user/login", ANON); //后台登录接口
        filterMap.put("/user/add", ANON); //用户注册接口
        filterMap.put("/image/upload", ANON); //图片上传接口
        filterMap.put("/good/getAllGood", ANON); //前台用户查看全部商品接口
        filterMap.put("/good/getGoodDetail", ANON); //前台用户查看商品详情接口
        filterMap.put("/category/getAllCategory", ANON);
        filterMap.put("/", ANON); //商城主页

        filterMap.put("/**", AUTHC);

        Map<String, Filter> beanFilters = bean.getFilters();
        beanFilters.put(AUTHC ,new ShiroLoginFilter());

        bean.setLoginUrl("/userLogin");
        bean.setFilterChainDefinitionMap(filterMap);

        return bean;
    }
    // 安全管理器，里面主要定义了登录，创建subject，登出等操作
    @Bean
    public DefaultWebSecurityManager getSecurityManager(UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    // 连接用户数据
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

}
