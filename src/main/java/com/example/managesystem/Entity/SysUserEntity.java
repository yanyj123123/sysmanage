package com.example.managesystem.Entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("sys_user")
public class SysUserEntity {
    private int id;
    private String userName;
    private String password;
    private String nickName;
    private String mobile;
    private int isDeleted;
    private int accountType;
    private int accountState;
    private Date createTime;
    private Date updateTime;
    private String userRole;
    private String updateUser;
    private String createUser;

}
