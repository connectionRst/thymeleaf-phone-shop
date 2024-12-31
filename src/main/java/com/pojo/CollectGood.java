package com.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CollectGood {

    private static final long serialVersionUID=1L;

    private String id;

    private String userId;

    private String goodId;

    private String goodName;

    private Integer goodStock;

    private String goodImg;

    private String goodPrice;

    private Integer goodStatus;

    private String goodSku;

    private String goodRemark;

}
