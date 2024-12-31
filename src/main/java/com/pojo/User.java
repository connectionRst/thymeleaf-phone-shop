package com.pojo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author chen
 * @since 2022-01-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 手机
     */
    private String phone;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 1=正常，2=禁用
     */
    private Integer status;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 0=未删除 1=已删除
     */
    @TableLogic
    private Integer deleted;

    /**
     * 1=普通用户 2=管理员
     */
    private Integer roleId;


}
