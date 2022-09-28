package com.example.managesystem.Service.ServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.managesystem.Entity.SysUserEntity;
import com.example.managesystem.Mapper.SysUserMapper;
import com.example.managesystem.Service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public List<SysUserEntity> getUser() {
        QueryWrapper queryWrapper=new QueryWrapper();
        return sysUserMapper.selectList(queryWrapper);
    }

    @Override
    public List<SysUserEntity> search(String key) {
        QueryWrapper queryWrapper=new QueryWrapper();
        if(key==null)
        {
            return sysUserMapper.selectList(queryWrapper);
        }
        else
        {
            queryWrapper.like(StringUtils.isNotBlank(key),"user_name",key);

            return sysUserMapper.selectList(queryWrapper);
        }

    }

    @Override
    public void save(SysUserEntity sysUserEntity) {
        sysUserMapper.insert(sysUserEntity);
    }
}
