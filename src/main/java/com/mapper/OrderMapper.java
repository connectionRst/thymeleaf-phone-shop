package com.mapper;

import com.pojo.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chen
 * @since 2022-01-30
 */
public interface OrderMapper extends BaseMapper<Order> {

    List<Order> adminGetAll(@Param("userName")String userName,
                            @Param("goodName")String goodName,
                            @Param("status")Integer status);

    List<Order> shangjiaGetAll(@Param("userName")String userName,
                            @Param("goodName")String goodName,
                            @Param("status")Integer status,
                            @Param("shangjiaId")String shangjiaId);

}
