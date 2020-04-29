package com.opsbible.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

@ApiIgnore
@Controller
public class IndexController {
    @RequestMapping("/")
    public String hello(HttpServletRequest request,
                        @RequestParam(value = "name", defaultValue = "数据库数据查询测试") String name) {
        request.setAttribute("name", name);
        return "index";
    }
}


