package com.atguigu.springboot.component;


import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

//给容器加入我们的MyErrorAttributes
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company","xt");

        // 我们得异常处理器携带的数据
        Map<String, Object> ext = (Map<String, Object>)webRequest.getAttribute("ext", 0);
        map.put("ext", ext);
        return map;

    }
}
