package com.qianfeng.commons.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeController {

    @RequestMapping("/")
    public String tohome(){
        return "/html/index.html";
    }
}
