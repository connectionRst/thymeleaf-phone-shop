package com.mapper;

import com.pojo.Good;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 积分物品表 Mapper 接口
 * </p>
 *
 * @author chen
 * @since 2022-01-30
 */
public interface GoodMapper extends BaseMapper<Good> {

    List<Good> getAll(@Param("name") String name, @Param("categoryId") String categoryId);
    List<Good> shangjiaGetAll(@Param("name") String name, @Param("categoryId") String categoryId, @Param("shangjiaId") String shangjiaId);

}
