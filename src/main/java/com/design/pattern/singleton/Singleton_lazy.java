package com.design.pattern.singleton;

/**
 * Created by wangchangye on 2017/3/21.
 *  线程不安全  加了synchronized 安全 效率低
 * @Author wangchangye
 */
public class Singleton_lazy {
    private static Singleton_lazy singleton_lazy;
    private Singleton_lazy(){};
    public static synchronized Singleton_lazy getInstance(){
        if(singleton_lazy==null){
            singleton_lazy = new Singleton_lazy();
        }
        return singleton_lazy;
    }
}
