package com.itke.web;


import com.github.pagehelper.PageInfo;
import com.itke.domain.UserInfo;
import com.itke.service.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IuserService userService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll2( @RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "4") int size) throws Exception {
        List<UserInfo> us = userService.findAll(page, size);
        ModelAndView mv = new ModelAndView();
        //PageInfo就是一个分页Bean
        PageInfo pageInfo=new PageInfo(us);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/Edit.do")
    public  String Edit(){
        return "user-add" ;
    }

    @RequestMapping("/save.do")
    public String save(UserInfo user) throws Exception {
        userService.save(user);
        return "redirect:findAll.do";
    }

}
