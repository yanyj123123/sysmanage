package com.example.managesystem.Controller;

import com.example.managesystem.Mapper.SysUserMapper;
import com.example.managesystem.Service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class DeleteUserController {
    @Autowired
    private SysUserMapper sysUserMapper;
    @GetMapping("/delete/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable("id") String id){
      int remove= sysUserMapper.deleteById(id);
      if(remove==1) {
          return "success";
      }
      else
          return "error";
    }
}
