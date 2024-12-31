package com.service;

import com.pojo.Good;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author chen
 * @since 2022-01-30
 */
public interface GoodService extends IService<Good> {

    List<Good> getAll(String name, String categoryId);

}
