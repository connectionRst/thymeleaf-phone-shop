package com;

import com.pojo.Comment;
import com.pojo.User;
import com.service.CommentService;
import com.service.UserService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@MapperScan(basePackages = "com.mapper")
@SpringBootTest
class PhoneShopApplicationTests {

    @Autowired
    CommentService commentService;

    @Test
    void contextLoads() {
        Comment comment1 = new Comment();
        comment1.setLevel("1");
        comment1.setUserId("d193b6e8fa765440c16f8ffa01acbd00");
        comment1.setGoodId("059ea96c6f168ef439c0b95e61b9ce00");
        comment1.setContent("123");
        comment1.setCreateTime(new Date());
        commentService.save(comment1);
        for (Comment comment : commentService.list()) {
            System.out.println(comment);
        }
    }

}
