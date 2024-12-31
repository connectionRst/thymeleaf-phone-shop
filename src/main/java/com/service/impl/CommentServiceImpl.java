package com.service.impl;

import com.pojo.Comment;
import com.mapper.CommentMapper;
import com.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chen
 * @since 2022-01-30
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Override
    public List<Comment> getAll(String userName, String goodName, String content) {
        return this.baseMapper.getAll(userName, goodName, content);
    }
}
