package com.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pojo.Banner;
import com.pojo.Good;
import com.service.BannerService;
import com.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * TODO 后端 API 路径前缀（需要同时修改 init.json）
 * @author
 * @since 2022-01-30
 */
@Controller
public class ViewController {

    @Autowired
    private BannerService bannerService;

    @Autowired
    private GoodService goodService;

    /*
    * ==================================================后台管理页面========================================================================
    * */
    //后台登录界面
    @GetMapping("/adminLogin")
    public ModelAndView loginPage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login.html");
        return mv;
    }

    //管理员界面
    @GetMapping("/adminIndex")
    public ModelAndView adminIndex() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/admin.html");
        return mv;
    }

    //用户列表界面
    @GetMapping("/userList")
    public ModelAndView userList() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/user/userList.html");
        return mv;
    }

    //添加用户界面
    @GetMapping("/userAdd")
    public ModelAndView userAdd() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/user/userAdd.html");
        return mv;
    }

    //修改用户界面
    @GetMapping("/userEdit")
    public ModelAndView userEdit() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/user/userEdit.html");
        return mv;
    }

    //商品分类列表页面
    @GetMapping("/categoryList")
    public ModelAndView categoryList() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/category/categoryList.html");
        return mv;
    }

    //添加商品分类列表页面
    @GetMapping("/categoryAdd")
    public ModelAndView categoryAdd() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/category/categoryAdd.html");
        return mv;
    }

    //修改商品分类列表页面
    @GetMapping("/categoryEdit")
    public ModelAndView categoryEdit() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/category/categoryEdit.html");
        return mv;
    }

    //商品列表页面
    @GetMapping("/goodList")
    public ModelAndView goodList() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/good/goodList.html");
        return mv;
    }

    //添加商品列表页面
    @GetMapping("/goodAdd")
    public ModelAndView goodAdd() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/good/goodAdd.html");
        return mv;
    }

    //修改商品列表页面
    @GetMapping("/goodEdit")
    public ModelAndView goodEdit() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/good/goodEdit.html");
        return mv;
    }

    //管理员订单页面
    @GetMapping("/adminOrderList")
    public ModelAndView adminOrderList() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/order/orderList.html");
        return mv;
    }

    //轮播图列表页面
    @GetMapping("/bannerList")
    public ModelAndView bannerList() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/banner/bannerList.html");
        return mv;
    }

    //添加商品列表页面
    @GetMapping("/bannerAdd")
    public ModelAndView bannerAdd() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/banner/bannerAdd.html");
        return mv;
    }

    //修改商品列表页面
    @GetMapping("/bannerEdit")
    public ModelAndView bannerEdit() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/banner/bannerEdit.html");
        return mv;
    }

    //评论页面
    @GetMapping("/commentList")
    public ModelAndView commentList() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/comment/commentList.html");
        return mv;
    }

    /*
     * ==================================================商家界面========================================================================
     * */

    //商家界面
    @GetMapping("/shangjiaIndex")
    public ModelAndView shangjiaIndex() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin_shangjia/admin.html");
        return mv;
    }

    //商品列表页面
    @GetMapping("/shangjiaGoodList")
    public ModelAndView shangjiaGoodList() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin_shangjia/good/goodList.html");
        return mv;
    }

    //添加商品列表页面
    @GetMapping("/shangjiaGoodAdd")
    public ModelAndView shangjiaGoodAdd() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin_shangjia/good/goodAdd.html");
        return mv;
    }

    //修改商品列表页面
    @GetMapping("/shangjiaGoodEdit")
    public ModelAndView shangjiaGoodEdit() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin_shangjia/good/goodEdit.html");
        return mv;
    }

    //管理员订单页面
    @GetMapping("/shangjiaOrderList")
    public ModelAndView shangjiaOrderList() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin_shangjia/order/orderList.html");
        return mv;
    }

    //商城主页面
    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        //获取轮播图
        LambdaQueryWrapper<Banner> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .eq(Banner::getSelected, 1);

        //热门商品
        LambdaQueryWrapper<Good> goodWrapper = new LambdaQueryWrapper<>();
        goodWrapper
                .eq(Good::getStatus, 1)
                .orderByDesc(Good::getSales)
                .last("limit 4");

        mv.addObject("goodList", goodService.list(goodWrapper));
        mv.addObject("bannerList", bannerService.list(queryWrapper));
        mv.setViewName("index/index.html");
        return mv;
    }

    //前台登录界面
    @GetMapping("/userLogin")
    public ModelAndView UserloginPage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index/login.html");
        return mv;
    }

    //用户注册界面
    @GetMapping("/register")
    public ModelAndView register() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("register.html");
        return mv;
    }

    //用户修改密码界面
    @GetMapping("/updatePwd")
    public ModelAndView updatePwd() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index/user_pwd.html");
        return mv;
    }

    //用户收货地址管理界面
    @GetMapping("/userAddress")
    public ModelAndView userAddress() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index/user_address.html");
        return mv;
    }

    //用户修收货地址界面
    @GetMapping("/addressEdit")
    public ModelAndView addressEdit() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index/user_addressEdit.html");
        return mv;
    }

    //商品评价页面
    @GetMapping("/order/userComment")
    public ModelAndView comment() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index/comment.html");
        return mv;
    }

}
