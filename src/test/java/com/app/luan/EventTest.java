package com.app.luan;

import com.alibaba.fastjson.JSONObject;
import com.app.luan.event.myPublisher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = LuanApplication.class)
public class EventTest {

    @Autowired
    myPublisher publisher;


    @Test
    public void test() throws InterruptedException {
        publisher.publisher("这是测试", new Date());
        Thread.sleep(3000);
        publisher.publisher("休眠之后发布的", new Date());

    }

    public List<String> test1(){
        List<String> test = new ArrayList<>();
        test.add("test1");
        test.add("test1");
        return test;
    }

    public List<String> test2(){
        List<String> test = new ArrayList<>();
        test.add("test2");
        test.add("test2");
        return test;
    }


    @Test
    public void testList()  {
        List<String> list;
        list = test1();
        System.out.println(list);
        list = test2();
        System.out.println(list);
    }

    @Test
    public void testSwitch(){
        String luan = "[[{\\\"left\\\":\\\"power_1\\\",\\\"opt\\\":\\\"==\\\",\\\"right\\\":\\\"0\\\"}]]";
        String jsonString = JSONObject.toJSONString(luan);
        System.out.println(jsonString);
//        Integer test = 2;
//        switch (1) {
//            case 1:
//                System.out.println("走到了1"+new Date());
//                break;
//            case 2:
//                System.out.println("走到了2");
//                break;
//            default:
//                System.out.println("走到了默认");
//        }
//        System.out.println(test.compareTo(2));
    }

    @Test
    public void TestList(){
        List<Integer> autoSceneIds = new ArrayList<>();
        autoSceneIds.add(32342);
        autoSceneIds.add(123413);
        List<Integer> copySceneId = new ArrayList<>();
        autoSceneIds.forEach(item->copySceneId.add(item));
        autoSceneIds.clear();
        Collections.copy(copySceneId, autoSceneIds);
        System.out.println(autoSceneIds);
        System.out.println(copySceneId);
    }

    @Test
    public  void TestLists(){
        Integer actionId = 17209;
        System.out.println(Arrays.asList(actionId));
    }
}
