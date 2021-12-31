package com.lee.rpc.service;

import com.lee.rpc.model.Clothes;

/**
 *
 * Stock
 *
 * @description
 * @author lihuanmin
 * @date 2021/12/16 14:10
 * @version v1.0
 */
public interface StockService {

    /**
     *
     * Stock
     *
     * @description 更新商品数量
     * @param type 商品类别
     * @return java.lang.String
     * @author lihuanmin
     * @date 2021/12/16 14:11
     * @version v1.0
     */
    Clothes updateCommodityCount(String type);
}
