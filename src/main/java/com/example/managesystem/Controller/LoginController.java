package com.example.managesystem.Controller;

import com.example.managesystem.Mapper.SysUserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @GetMapping("/{url}")
    public String URL(@PathVariable("url") String url)
    {
        return url;
    }

    @GetMapping("favicon.ico")
    @ResponseBody
    public void returnNoFav()
    {

    }


}
