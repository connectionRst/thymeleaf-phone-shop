package com.pojo;

import com.baomidou.mybatisplus.annotation.TableLogic;
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
@TableName("t_banner")
public class Banner implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 轮播图Id
     */
    private String id;

    /**
     * 轮播图商品Id
     */
    private String goodId;

    /**
     * 轮播多名字
     */
    private String name;

    /**
     * 轮播图片
     */
    private String img;

    /**
     * 是否选用 1=选用 2=不选
     */
    private Integer selected;

    /**
     * 0正常 1删除
     */
    @TableLogic
    private Integer deleted;


}
