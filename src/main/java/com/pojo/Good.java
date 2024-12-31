package com.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 积分物品表
 * </p>
 *
 * @author chen
 * @since 2022-01-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_good")
public class Good implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;

    /**
     * 商家id
     */
    private String shangjiaId;

    /**
     * 商品分类id
     */
    private String categoryId;

    /**
     * 礼品名称
     */
    private String name;

    /**
     * 价值
     */
    private String price;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 图片
     */
    private String image;

    /**
     * 描述
     */
    private String remark;

    /**
     * 1=上架中，2=下架中
     */
    private Integer status;

    /**
     * 销量
     */
    private Integer sales;

    /**
     * 规格
     */
    private String sku;

    @TableLogic
    private Integer deleted;

    @TableField(exist = false)
    private GoodCategory goodCategory;

    @TableField(exist = false)
    private User shangjia;

    @TableField(exist = false)
    private Integer goodBuyNum;

    @TableField(exist = false)
    private String goodTotalPrice;


}
