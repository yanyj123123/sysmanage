package com.example.managesystem.Util;

import lombok.Data;

import java.util.List;

@Data
public class PageUtil {
    //每页几条数据
    public static final Integer size=3;
    //当前第几页
    private Integer page;
    //总记录数
    private Long total;
    //总页数
    private Long pages;
    //数据
    private List data;
}
