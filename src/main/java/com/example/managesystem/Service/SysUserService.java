package com.example.managesystem.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.managesystem.Entity.SysUserEntity;
import com.example.managesystem.Mapper.SysUserMapper;
import com.example.managesystem.Util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
public interface SysUserService {
    public List<SysUserEntity> getUser();

    public List<SysUserEntity> search(String key);

    public void save(SysUserEntity sysUserEntity);
    //分页
    public PageUtil pageSelect(String key, Integer page);
}
