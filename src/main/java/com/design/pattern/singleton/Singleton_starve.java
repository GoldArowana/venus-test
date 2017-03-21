package com.design.pattern.singleton;

/**
 * Created by wangchangye on 2017/3/21.
 *
 * @Author wangchangye
 */
public class Singleton_starve {
    private static final Singleton_starve INSTANCE = new Singleton_starve();
    private Singleton_starve(){};
    public static Singleton_starve getInstance(){
        return INSTANCE;
    }}
