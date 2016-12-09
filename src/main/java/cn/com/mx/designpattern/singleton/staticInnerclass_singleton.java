package cn.com.mx.designpattern.singleton;

/**
 * Created by wangchangye on 2016/12/2.
 * @Author wangchangye
 */
public class staticInnerclass_singleton {
    private staticInnerclass_singleton singleton;
    private static class getInstance{
        private static final staticInnerclass_singleton INSTANCE = new staticInnerclass_singleton();
    }
    public static staticInnerclass_singleton getInstance(){
        return staticInnerclass_singleton.getInstance();
    }
}
