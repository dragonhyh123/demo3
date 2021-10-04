package com.example.demo.handler;

import com.example.demo.entity.User;
import com.example.demo.service.UserServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HandleRequest {
    @RequestMapping("/index")
    @ResponseBody
    public String handleQuest1(){
        return "Hello";
    }

    @Autowired
    UserServicesImpl userServicesImpl;

    @RequestMapping("/request")
    @ResponseBody
    public User handleQuest2(int id){
        User user = userServicesImpl.queryByID(id);
        return user;
    }
}
