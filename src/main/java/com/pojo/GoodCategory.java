package com.pojo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 帖子分类表
 * </p>
 *
 * @author chen
 * @since 2022-01-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_good_category")
public class GoodCategory implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;

    /**
     * 帖子分类名称
     */
    private String name;

    /**
     * 0=未删除 1=删除
     */
    @TableLogic
    private Integer deleted;


}
