package com.lee.rpc.model;


import lombok.*;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;

/**
 *
 * Clothes
 *
 * @description
 * @author lihuanmin
 * @date 2021/12/16 14:24
 * @version v1.0
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Clothes implements Serializable {

    /**
     * 编号
     */
    private String bh;

    /**
     * 颜色
     */
    private String color;

    /**
     * 材料
     */
    private String material;

    /**
     * 大小
     */
    private String size;

    /**
     * 价格
     */
    private String price;

    /**
     * 种类
     */
    private String type;

    /**
     * 库存数量
     */
    private Integer inventoryQuantity;
}
