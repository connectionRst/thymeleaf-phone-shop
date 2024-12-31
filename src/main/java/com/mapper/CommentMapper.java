package com.mapper;

import com.pojo.Comment;
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
public interface CommentMapper extends BaseMapper<Comment> {

    List<Comment> getAll(@Param("userName") String userName,
                         @Param("goodName") String goodName,
                         @Param("content") String content);

}
