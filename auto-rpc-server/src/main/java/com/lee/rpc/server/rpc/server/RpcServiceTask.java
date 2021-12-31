package com.lee.rpc.server.rpc.server;

import com.lee.rpc.model.Clothes;
import com.lee.rpc.server.rpc.ServiceConfig;
import lombok.SneakyThrows;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 *
 * RpcServiceTask
 *
 * @description
 * @author lihuanmin
 * @date 2021/12/27 13:41
 * @version
 */
public class RpcServiceTask implements Runnable{
    private Socket socket;

    public RpcServiceTask(Socket socket) {
        this.socket = socket;
    }
    @SneakyThrows
    @Override
    public void run() {
        ObjectInputStream input = null;
        ObjectOutputStream output = null;
        try {
            input = new ObjectInputStream(socket.getInputStream());
            String serviceName = input.readUTF();
            String methodName = input.readUTF();
            Class<?>[] parameterTypes = (Class<?>[])input.readObject();
            Object[] arguments = (Object[])input.readObject();
            Class<?> serviceClass = ServiceConfig.SERVICE_REGISTRY.get(serviceName);
            Method method = serviceClass.getMethod(methodName, parameterTypes);
            Clothes clothes = (Clothes)method.invoke(serviceClass.newInstance(), arguments);
            output = new ObjectOutputStream(socket.getOutputStream());
            output.writeObject(clothes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert output != null;
            output.close();
            input.close();
            socket.close();
        }
    }
}
