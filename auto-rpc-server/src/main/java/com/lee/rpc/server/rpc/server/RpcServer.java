package com.lee.rpc.server.rpc.server;

import com.lee.rpc.model.Clothes;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 *
 * RpcServer
 *
 * @description
 * @author lihuanmin
 * @date 2021/12/8 11:24
 * @version v1.0
 */
@Component
public class RpcServer {

    @Autowired
    private ServerSocket serverSocket;

    public void run () throws Exception{
        ThreadPoolExecutor threadPool =new ThreadPoolExecutor(5, 10,
                200, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));

        while (true) {
            Socket socket = serverSocket.accept();
            threadPool.execute(new RpcServiceTask(socket));
        }
    }
}

