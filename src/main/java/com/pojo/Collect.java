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
@TableName("t_collect")
public class Collect implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 收藏Id
     */
    private String id;

    /**
     * 用户Id
     */
    private String userId;

    /**
     * 商品Id
     */
    private String goodId;


}
