package com.yangluyao.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @InterfaceName: LoadBalancer
 * @description:
 * @author: yly
 * @create: 2020/04/02 12:41
 **/
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
