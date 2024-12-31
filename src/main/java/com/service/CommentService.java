package com.service;

import com.pojo.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chen
 * @since 2022-01-30
 */
public interface CommentService extends IService<Comment> {

    List<Comment> getAll(String userName,
                         String goodName,
                         String content);

}
