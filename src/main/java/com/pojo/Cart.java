package com.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("t_cart")
public class Cart implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 购物车Id
     */
    private String id;

    /**
     * 商品Id
     */
    private String goodId;

    /**
     * 用户Id
     */
    private String userId;

    /**
     * 商家Id
     * TODO
     */
//    private String shangjiaId;

    /**
     * 数量
     */
    private Integer num;

}
