package com.design.pattern.singleton;

/**
 * Created by wangchangye on 2017/3/21.
 * 优点：线程安全；延迟加载；效率较高。
 * @Author wangchangye
 */
public class Singleton_dubbocheck {
    private static volatile Singleton_dubbocheck singleton_dubbocheck;

    private Singleton_dubbocheck(){};
    public static Singleton_dubbocheck getInstance(){
        if(singleton_dubbocheck==null){
            synchronized (Singleton_dubbocheck.class){
                if(singleton_dubbocheck==null){
                    singleton_dubbocheck=new Singleton_dubbocheck();
                }
            }
        }
        return singleton_dubbocheck;
    }
}