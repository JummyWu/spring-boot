package com.atguigu.springboot.Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {

    //初始化
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized ...web应用启动");
    }

    // 销毁
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed ...当前web项目销毁");
    }
}
