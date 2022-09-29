package com.example.managesystem.Controller;

import com.example.managesystem.Entity.SysUserEntity;
import com.example.managesystem.Service.ServiceImpl.SysUserServiceImpl;
import com.example.managesystem.Service.SysUserService;
import com.example.managesystem.Util.PageUtil;
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

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
   private SysUserServiceImpl sysUserService;

    @GetMapping("/list")
    public ModelAndView list(
            @RequestParam(value = "key",required = false) String key,
            @RequestParam(value="page",required = false) Integer page
    )
    {
        if(page==null) page=1;
        ModelAndView modelAndView=new ModelAndView();
        PageUtil pageUtil=this.sysUserService.pageSelect(key,page);
        modelAndView.addObject("list",pageUtil.getData());
        modelAndView.addObject("page",pageUtil.getPage());
        modelAndView.addObject("pageCount",pageUtil.getPages());
        modelAndView.addObject("total",pageUtil.getTotal());
        int start=(page-1)*PageUtil.size+1;
        int end=page*3;
        if(page>pageUtil.getTotal()){
            modelAndView.addObject("end",pageUtil.getTotal());
        }
        else
        {
            modelAndView.addObject("end",end);
        }
        modelAndView.addObject("start",start);
        List<Integer>pages=new ArrayList<>();
        for(int i=1;i<=pageUtil.getPages();i++)
        {
            pages.add(i);
        }
        modelAndView.addObject("pages",pages);
        System.out.println(pages);


        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        User user=(User) authentication.getPrincipal();
        modelAndView.addObject("current",user);

       // System.out.println(currentUser.);
        System.out.println(pageUtil.getPages());

        modelAndView.addObject("key",key);

        modelAndView.setViewName("user_list");
        //modelAndView.setViewName("index");
        //Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        //System.out.println(authentication.getName());
        return modelAndView;
    }





}
