package com.example.managesystem.Controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
