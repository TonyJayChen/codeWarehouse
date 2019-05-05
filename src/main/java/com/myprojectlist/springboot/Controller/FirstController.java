package com.myprojectlist.springboot.Controller;

import com.myprojectlist.springboot.config.FirstRad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class FirstController {

    @Autowired
    FirstRad firstRad;

    @RequestMapping("/define")
    @ResponseBody
    String define()
    {
        return "test.name:" + firstRad.getPname() + ", test.password:" + firstRad.getPassword();
    }
}
