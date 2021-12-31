package com.lee.rpc.server.service;

import com.lee.rpc.model.Clothes;
import com.lee.rpc.service.StockService;

/**
 *
 * HelloServiceImpl
 *
 * @description
 * @author lihuanmin
 * @date 2021/12/16 11:12
 * @version v1.0
 */
public class StockServiceServiceImpl implements StockService {

    @Override
    public Clothes updateCommodityCount(String type) {
        return Clothes
                .builder()
                .bh("123")
                .type("羽绒服")
                .build();
    }
}
