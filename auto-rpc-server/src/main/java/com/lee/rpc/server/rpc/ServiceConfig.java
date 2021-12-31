package com.lee.rpc.server.rpc;

import java.util.HashMap;

/**
 *
 * ServiceConfig
 *
 * @description
 * @author lihuanmin
 * @date 2021/12/16 11:37
 * @version v1.0
 */
public class ServiceConfig {
    public static final HashMap<String, Class<?>> SERVICE_REGISTRY = new HashMap<>();

    public static void register(Class<?> serviceInterface, Class<?> impl) {
        SERVICE_REGISTRY.put(serviceInterface.getName(), impl);
    }
}
