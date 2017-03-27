package com.design.pattern.singleton;


/**
 * Created by wangchangye on 2016/12/2.
 *  避免县城同步问题，延迟加载，效率较高。
 * @Author wangchangye
 */
public class staticInnerclass_singleton {
    private staticInnerclass_singleton singleton;

    private staticInnerclass_singleton(){};
    private static class getInstance{
        private static final staticInnerclass_singleton INSTANCE = new staticInnerclass_singleton();
    }
    public static staticInnerclass_singleton getInstance(){
        return staticInnerclass_singleton.getInstance();
    }
}