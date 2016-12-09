package cn.com.mx.designpattern.singleton;

/**
 * Created by wangchangye on 2016/12/2.
 * 懒汉式，线程不安全
 */
public class Singleton_lazy {
    private static Singleton_lazy singleton_lazy;
    private Singleton_lazy(){};
    public static Singleton_lazy getInstance(){
        if(singleton_lazy==null){
            singleton_lazy = new Singleton_lazy();
        }
        return singleton_lazy;
    }
}
