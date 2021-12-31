package com.lee.rpc.consumer.rpc;

import com.lee.rpc.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;

/**
 *
 * RpcProxy
 *
 * @description
 * @author lihuanmin
 * @date 2021/12/20 16:25
 * @version v1.0
 */
@Component
public class RpcProxy {

    @Autowired
    private InetSocketAddress inetSocketAddress;

    public Object getInstance(Class clazz) {
        RpcClientProxyHandler<StockService> rpcClientProxyHandler = new RpcClientProxyHandler<>(clazz, inetSocketAddress);
        return Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[]{StockService.class}, rpcClientProxyHandler);
    }
}
