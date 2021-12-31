package com.lee.rpc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * RpcConfigure
 *
 * @description
 * @author lihuanmin
 * @date 2021/12/20 14:38
 * @version v1.0
 */
@Component
public class RpcConfigure {

    @Value("${rpc.socket.port:8080}")
    private Integer port;

    @Value("${rpc.socket.ip:127.0.0.1}")
    private String ip;

    @Value("${rpc.serverSocket.port:8081}")
    private Integer serverSocketPort;


    public Integer getPort() {
        return this.port;
    }

    public String getIp() {
        return this.ip;
    }

    public Integer getServerSocketPort() {
        return this.serverSocketPort;
    }
}
