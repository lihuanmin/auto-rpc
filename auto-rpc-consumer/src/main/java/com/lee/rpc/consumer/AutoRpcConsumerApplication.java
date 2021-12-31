package com.lee.rpc.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * AutoRpcConsumerApplication
 *
 * @description
 * @author lihuanmin
 * @date 2021/12/7 11:15
 * @version
 */
@SpringBootApplication(scanBasePackages = {"com.lee.rpc"})
public class AutoRpcConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AutoRpcConsumerApplication.class, args);
    }
}
