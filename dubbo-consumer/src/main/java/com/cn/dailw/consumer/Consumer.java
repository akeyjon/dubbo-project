package com.cn.dailw.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.dailw.service.DemoService;

public class Consumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-demo-consumer.xml");
        context.start();
        DemoService demoService = (DemoService) context.getBean("demoService"); // get remote service proxy
        while (true) {
            try {
                Thread.sleep(1000);
                String hello = demoService.sayHello("world"); // call remote method
                System.out.println(hello); // get result
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }
}
