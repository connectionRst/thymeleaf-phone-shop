package com.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.pojo.Address;
import com.pojo.User;
import com.pojo.result.Result;
import com.pojo.result.ResultPage;
import com.service.AddressService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    //添加收货地址
    @PostMapping("/add")
    public Result add(Address address) {
        User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
        //保存当前用户id
        address.setUserId(currentUser.getId());
        return Result.decide(addressService.save(address));
    }

    //删除收货地址
    @PostMapping("/delete")
    public Result delete(@RequestParam(value = "id") String id) {
        return Result.decide(addressService.removeById(id));
    }

    //获得单挑地址明细
    @PostMapping("/getOne")
    public Result getOne(@RequestParam(value = "id") String id) {
        return Result.success(addressService.getById(id));
    }

    //修改收货地址
    @PostMapping("/update")
    public Result update(Address address) {
        User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
        if (addressService.updateById(address)) {
            if (address.getDefaulted() == 1) {
                LambdaUpdateWrapper<Address> updateWrapper = new LambdaUpdateWrapper<>();
                updateWrapper
                        .eq(Address::getUserId, currentUser.getId())
                        .ne(Address::getId, address.getId())
                        .set(Address::getDefaulted, 2);
                addressService.update(updateWrapper);
            }
        }
        return Result.success();
    }

    //查询当前用户所有收货地址
    @GetMapping("/getAll")
    public ResultPage getAll() {
        User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
        //查询当前用户所有收货地址
        List<Address> ls = addressService.list(new LambdaQueryWrapper<Address>().eq(Address::getUserId, currentUser.getId()));
        return new ResultPage(0, ls.size(), ls);
    }

    //设置默认地址
    @PostMapping("setDefault")
    public Result update(@RequestParam(value = "id") String id) {
        User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
        LambdaUpdateWrapper<Address> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper
                .eq(Address::getUserId, currentUser.getId())
                .set(Address::getDefaulted, 2);
        if (addressService.update(updateWrapper)) {
            LambdaUpdateWrapper<Address> update = new LambdaUpdateWrapper<>();
            update
                    .eq(Address::getId, id)
                    .set(Address::getDefaulted, 1);
            return Result.decide(addressService.update(update));
        } else {
            return Result.failure("设置默认地址失败");
        }
    }

}

