package com.fgh.Mybatis.client;


import com.fgh.Mybatis.Tool.TimeReversal;
import com.fgh.Mybatis.model.User;
import com.fgh.Mybatis.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class MainClass {

//    private static ApplicationContext applicationContext;
//    private static UserService userService;
//    static {
//        /* 创建Spring容器 */
//        applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
//        /* 从spring容器中获取UserDao这个bean */
//        userService = (UserService) applicationContext.getBean("userServiceImpl");
//    }


    public static void main(String[] args) {

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserService userService=(UserService)applicationContext.getBean("service");

//        自定义查询数据
        User user = new User();
        user.setType("pm");
        try {
            List<User> users = userService.findUserBy(user);
            System.out.println(users);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

//        User user = new User();
//        user.setUsername("安师傅2");
//        user.setQQ("201805121234");
//        user.setType("QA");
//        user.setDescription("插入数据2");
//        user.setCreate_at(TimeReversal.Datetolong(new Date()));
//        Boolean InsertBool=userService.insertUser(user);
//        System.out.println(InsertBool);
//
//
//      插入数据
        User user1 = new User();
        user1.setUsername("安师傅2");
        user1.setQQ("201805121234");
        user1.setType("QA");
        user1.setDescription("插入数据2");
        user1.setCreate_at(TimeReversal.Datetolong(new Date()));
        try {
            userService.insertUser(user1);
            System.out.println(user1.getId());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

//            查找全部数据
             try {
                 List<User> users=userService.findAll();
                 System.out.println(users);
             }catch (Exception e){
                 System.out.println(e.getMessage());
             }

             //更新数据
            User user2 = new User();
            user2.setId(2);
            user2.setUsername("卡卡");
            user2.setQQ("201805201126");
            user2.setCounsellor("李莉");
            user2.setDescription("电饭锅");
            user2.setUpdate_at(TimeReversal.Datetolong(new Date()));
            try{
                boolean UpdateBool=userService.updateUser(user2);
                System.out.println(UpdateBool);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

//            删除数据
             try{
                 Boolean DelBool=userService.delUser(47);
                 System.out.println(DelBool);
             }catch (Exception e){
                 System.out.println(e.getMessage());
             }




    }
}




