package com.service;

import com.pojo.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pojo.User;
import com.pojo.result.Result;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chen
 * @since 2022-01-30
 */
public interface OrderService extends IService<Order> {

    Result createOrder(String cartIds, User currentUser);

    List<Order> adminGetAll(String userName, String goodName, Integer status);

    List<Order> shangjiaGetAll(String userName, String goodName, Integer status, String shangjiaId);

}
