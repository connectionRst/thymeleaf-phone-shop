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
@TableName("t_order")
public class Order implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 订单Id
     */
    private String id;

    /**
     * 用户Id
     */
    private String userId;

    /**
     * 商家Id
     */
    private String shangjiaId;


    /**
     * 商品Id
     */
    private String goodId;

    private String totalPrice;

    private Integer num;

    /**
     * 订单价格
     */
    private String price;

    /**
     * -1删除 1 待付款 2待发货 3 待收货 4待评价 5完成
     */
    private Integer status;

    /**
     * 订单收货人
     */
    private String name;

    /**
     * 订单手机
     */
    private String phone;

    /**
     * 订单地址
     */
    private String address;

    /**
     * 时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @TableField(exist = false)
    private String goodCategory;

    @TableField(exist = false)
    private String goodImage;

    @TableField(exist = false)
    private String goodName;

    @TableField(exist = false)
    private String goodSku;

    @TableField(exist = false)
    private String fmtDateTime;

    @TableField(exist = false)
    private User user;

    @TableField(exist = false)
    private Good good;

    @TableField(exist = false)
    private GoodCategory category;

    @TableField(exist = false)
    private User shangjia;

}
