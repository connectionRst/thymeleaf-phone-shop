package com.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CartGood {

    private static final long serialVersionUID=1L;

    private String id;

    private String goodId;

    private String userId;

    private Integer num;

    private String goodImg;

    private String goodName;

    private String goodSku;

    private String goodPrice;

    private Integer goodStock;

    private String goodCategory;

    private String totalPrice;
}
