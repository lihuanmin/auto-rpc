package com.lee.rpc.consumer.controller;

import com.lee.rpc.consumer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * OrderController
 *
 * @description 订单类
 * @author lihuanmin
 * @date 2021/12/16 10:16
 * @version 1.0
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/place")
    public void placeOrder() {
        orderService.placeOrder();
    }
}
