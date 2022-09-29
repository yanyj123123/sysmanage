package com.example.managesystem.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.managesystem.Entity.SysUserEntity;
import com.example.managesystem.Mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/user")
public class UpdateUserController {
    @Autowired
    private SysUserMapper sysUserMapper;
    @GetMapping("/update/{id}")
    public ModelAndView updateUser(@PathVariable("id")Integer id){

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("updateUser",sysUserMapper.selectById(id));
        modelAndView.setViewName("UpdateUser");
        return modelAndView;
    }
    @PostMapping("/updateUser")
    public String update(SysUserEntity sysUserEntity){

        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        User user=(User) authentication.getPrincipal();
        sysUserEntity.setUpdateUser(user.getUsername());
        LocalDateTime NowTime=LocalDateTime.now();
        sysUserEntity.setUpdateTime(NowTime);
        this.sysUserMapper.updateById(sysUserEntity);

            System.out.println(sysUserEntity);
            return "redirect:/user/list";
    }
}
