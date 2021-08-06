package com.app.luan;

import com.alibaba.fastjson.JSON;
import com.app.luan.tools.ListUtils;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i=0; i < 10;i++){
            list.add("数字："+i);
        }
        List<List<String>> lists = ListUtils.splitList(list);
        lists.forEach(e ->{
            System.out.println("第一份："+ JSON.toJSONString(e));
        });

//        System.out.println("2-5截取："+ JSON.toJSONString(list.subList(2,5)));
//        System.out.println("1-50截取："+ JSON.toJSONString(list.subList(0,49)));
    }
}
