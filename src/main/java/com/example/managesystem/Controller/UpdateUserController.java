package com.example.managesystem.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.managesystem.Entity.SysUserEntity;
import com.example.managesystem.Mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UpdateUserController {
    @Autowired
    private SysUserMapper sysUserMapper;
    @GetMapping("/update")
    public String updateUser(@RequestParam("updateInform")SysUserEntity updateinform){
        QueryWrapper queryWrapper=new QueryWrapper();
        sysUserMapper.update(updateinform,queryWrapper);
        return "redirect:/user/list";


    }
}
