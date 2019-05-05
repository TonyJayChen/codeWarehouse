package com.myprojectlist.springboot.utils.Multithreading;

import java.util.Map;

public class Thread extends java.lang.Thread {

   private Map<String,String> map;

    public Thread (Map<String,String> map){
        this.map=map;
    }

    @Override
    public void run() {
        System.out.println("姓名："+map.get("name")+",年龄："+map.get(""));
    }



}
