package cn.com.mx.designpattern.singleton;

/**
 * Created by wangchangye on 2016/12/2.
 * 饿汉式单例
 */
public class Singleton_starve {
    private static final Singleton_starve INSTANCE = new Singleton_starve();
    private Singleton_starve(){};
    public static Singleton_starve getInstance(){
        return INSTANCE;
    }}
