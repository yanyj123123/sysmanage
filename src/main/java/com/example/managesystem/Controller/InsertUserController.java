package com.example.managesystem.Controller;

import com.example.managesystem.Entity.SysUserEntity;
import com.example.managesystem.Service.ServiceImpl.SysUserServiceImpl;
import com.example.managesystem.Service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.SecurityContextProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class InsertUserController {
    @Autowired
    private SysUserService sysUserService;
    @PostMapping("/insert")
    public String insertUser(SysUserEntity sysUserEntity)
    {

       Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
       User currentUser=(User)authentication.getPrincipal();
       sysUserEntity.setCreateUser(currentUser.getUsername());
       sysUserService.save(sysUserEntity);
       return "redirect:/user/list";
    }

}
