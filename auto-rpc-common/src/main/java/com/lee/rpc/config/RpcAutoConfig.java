package com.lee.rpc.config;

import com.lee.rpc.config.RpcConfigure;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

/**
 *
 * RpcAutoConfig
 *
 * @description
 * @author lihuanmin
 * @date 2021/12/20 14:46
 * @version v1.0
 */
@Configuration
@ComponentScan({"com.lee"})
public class RpcAutoConfig {

    @Bean
    public InetSocketAddress inetSocketAddress(RpcConfigure rpcConfigure){
        return new InetSocketAddress(rpcConfigure.getIp(), rpcConfigure.getPort());
    }

    @Bean
    public ServerSocket serverSocket (RpcConfigure rpcConfigure) throws IOException {
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(rpcConfigure.getServerSocketPort()));
        return server;
    }
}
