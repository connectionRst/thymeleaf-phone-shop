package com.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 
 * </p>
 *
 * @author chen
 * @since 2022-01-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_comment")
@Component
public class Comment implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;

    /**
     * 评价的用户
     */
    private String userId;

    /**
     * 商品id
     */
    private String goodId;

    /**
     * 评价的内容
     */
    private String content;

    /**
     * 等级
     */
    private String level;

    /**
     * 时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @TableField(exist = false)
    private String userName;

    @TableField(exist = false)
    private String userAvatar;

    @TableField(exist = false)
    private String fmtDateTime;

    @TableField(exist = false)
    private User user;

    @TableField(exist = false)
    private Good good;

}
