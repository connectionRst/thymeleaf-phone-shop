package com.service.impl;

import com.pojo.Good;
import com.mapper.GoodMapper;
import com.service.GoodService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author chen
 * @since 2022-01-30
 */
@Service
public class GoodServiceImpl extends ServiceImpl<GoodMapper, Good> implements GoodService {

    @Override
    public List<Good> getAll(String name, String categoryId) {
        return this.baseMapper.getAll(name, categoryId);
    }
}
