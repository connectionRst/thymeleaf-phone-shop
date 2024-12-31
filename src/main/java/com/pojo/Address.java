package com.pojo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@TableName("t_address")
public class Address implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 地址ID
     */
    private String id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 收货人联系方式
     */
    private String phone;

    /**
     * 收货人名称
     */
    private String name;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 县
     */
    private String area;

    /**
     * 详细地址
     */
    private String detail;

    /**
     * 1=默认地址 2=非默认地址
     */
    private Integer defaulted;

    /**
     * 0正常 1删除
     */
    @TableLogic
    private Integer deleted;


}
