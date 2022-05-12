package com.example.ps_project;

import com.example.ps_project.entity.*;

import java.util.List;

public class UserTest {

    public static User addNormalUserMethod(){
        FactoryUser factoryUser = new FactoryUser();
        User user = factoryUser.create(UserType.NORMALUSER,"Abdulah","Lahman","polarizen@gmail.com", "Observator 75");
        //User user = new NormalUser("Abdulah","Lahman","polarizen@gmail.com", "Observator 75");
        return user;
    }

    public static User addAdminMethod(){
        FactoryUser factoryUser = new FactoryUser();
        User user = factoryUser.create(UserType.ADMIN,"Admin","Boss","admin@boss.com", "B.dul 1 Decembrie 12");
        return user;
    }

    public static List<User> createUserList(){
        FactoryUser factoryUser = new FactoryUser();
        User user1 = factoryUser.create(UserType.ADMIN, "Zoltan", "Darlaczi", "darlaczi.zoltan@gmail.com", "Observator123");
        user1.setId(1L);
        User user2 = factoryUser.create(UserType.NORMALUSER, "Abdulah", "Lahman", "naruto@yahoo.com", "Cluj-Napoca");
        user2.setId(2L);
        User user3 = factoryUser.create(UserType.NORMALUSER, "James", "Hardy", "asus2015@gmail.com", "Bistrita");
        user3.setId(3L);
        return List.of(user1,user2,user3);
    }

    public static User newNormalUser(){
        FactoryUser factoryUser = new FactoryUser();
        User newUser = factoryUser.create(UserType.NORMALUSER,"Pate","Chigozie","p.chigozie@email.com","Sout-Africa");
        newUser.setId(1L);
        return newUser;
    }
}
