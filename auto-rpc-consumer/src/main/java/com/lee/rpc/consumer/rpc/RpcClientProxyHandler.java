package com.lee.rpc.consumer.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *
 * RpcProxyUtil
 *
 * @description rpc代理工具类
 * @author lihuanmin
 * @date 2021/12/16 10:34
 * @version v1.0
 */
public class RpcClientProxyHandler<T> implements InvocationHandler {

    private Class<T> serviceInterface;

    private InetSocketAddress inetSocketAddress;

    public RpcClientProxyHandler(Class<T> serviceInterface, InetSocketAddress inetSocketAddress) {
        this.serviceInterface = serviceInterface;
        this.inetSocketAddress = inetSocketAddress;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Socket socket = null;
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStrema = null;
        try{
            socket = new Socket();
            socket.connect(inetSocketAddress);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeUTF(serviceInterface.getName());
            objectOutputStream.writeUTF(method.getName());
            objectOutputStream.writeObject(method.getParameterTypes());
            objectOutputStream.writeObject(args);

            objectInputStrema = new ObjectInputStream(socket.getInputStream());
            return objectInputStrema.readObject();
        } finally {
            assert socket != null;
            socket.close();
            assert objectOutputStream != null;
            objectOutputStream.close();
            assert objectInputStrema != null;
            objectInputStrema.close();
        }
    }
}
