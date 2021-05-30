package com.ggg.cloudeureka.listen;

import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @Author: ggg
 * @create: 2021/5/27 23:12
 */
@Component
public class TestEvent {
    public void listen(EurekaInstanceCanceledEvent event){
        //发邮件 短信，监控服务下线。
        System.out.println("下线" + event.getServerId());
    }
}
