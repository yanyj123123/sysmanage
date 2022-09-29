package com.example.managesystem.Service.ServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.managesystem.Entity.SysUserEntity;
import com.example.managesystem.Mapper.SysUserMapper;
import com.example.managesystem.Service.SysUserService;
import com.example.managesystem.Util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysUserServiceImpl implements SysUserService {

    //不分页
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

    //分页查询
    public PageUtil pageSelect(String key,Integer page){
        Page<SysUserEntity> UserPage=new Page<>(page,PageUtil.size,true);
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.like(StringUtils.isNotBlank(key),"user_name",key);
        Page<SysUserEntity> resultPage=sysUserMapper.selectPage(UserPage,queryWrapper);
        PageUtil pageUtil=new PageUtil();
        pageUtil.setData(resultPage.getRecords());
        pageUtil.setPage(page);
        pageUtil.setTotal(resultPage.getTotal());

        pageUtil.setPages(resultPage.getPages());


        return pageUtil;
    }
}
