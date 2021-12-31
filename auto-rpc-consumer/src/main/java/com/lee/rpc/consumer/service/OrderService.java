package com.lee.rpc.consumer.service;

import com.alibaba.fastjson.JSON;
import com.lee.rpc.consumer.rpc.RpcProxy;
import com.lee.rpc.model.Clothes;
import com.lee.rpc.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * OrderSservice
 *
 * @description
 * @author lihuanmin
 * @date 2021/12/16 10:26
 * @version v1.0
 */
@Service
public class OrderService {

    @Autowired
    private RpcProxy rpcProxy;

    public void placeOrder() {
        StockService stockService = (StockService) rpcProxy.getInstance(StockService.class);
        Clothes clothes = stockService.updateCommodityCount("羽绒服");
        System.out.println(JSON.toJSONString(clothes));
    }
}
