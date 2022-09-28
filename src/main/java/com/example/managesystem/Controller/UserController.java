package com.example.managesystem.Controller;

import com.example.managesystem.Entity.SysUserEntity;
import com.example.managesystem.Service.ServiceImpl.SysUserServiceImpl;
import com.example.managesystem.Service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
   private SysUserServiceImpl sysUserService;

    @GetMapping("/list")
    public ModelAndView list(
            @RequestParam(value = "key",required = false) String key
    )
    {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("list",this.sysUserService.search(key));

        ModelAndView currentUser=new ModelAndView();
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        User user= (User) authentication.getPrincipal();
        currentUser.addObject("currentUser",user);

       // System.out.println(currentUser.);

        modelAndView.setViewName("user_list");


        return modelAndView;
    }



}
