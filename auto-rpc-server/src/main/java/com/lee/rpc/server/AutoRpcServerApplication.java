package com.lee.rpc.server;

import com.lee.rpc.server.rpc.server.RpcServer;
import com.lee.rpc.server.rpc.ServiceConfig;
import com.lee.rpc.server.service.StockServiceServiceImpl;
import com.lee.rpc.service.StockService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 * com.lee.rpc.server.AutoRpcServerApplication
 *
 * @description
 * @author lihuanmin
 * @date 2021/12/7 11:11
 * @version v1.0
 */
@SpringBootApplication(scanBasePackages = {"com.lee.rpc"})
public class AutoRpcServerApplication {
    public static void main(String[] args) throws Exception {
        ServiceConfig.register(StockService.class, StockServiceServiceImpl.class);
        ConfigurableApplicationContext applicationContext = SpringApplication.run(AutoRpcServerApplication.class, args);
        applicationContext.getBean(RpcServer.class).run();
    }
}
