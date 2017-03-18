package cn.com.mx.simpletest.designpattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by wangchangye on 2017/1/5.
 *
 * @Author wangchangye
 */
public class InvocationHandlerImpl implements InvocationHandler {

    // 需要代理的类
    private Object subject;
    public InvocationHandlerImpl(Object subject){
        this.subject = subject;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用之前!");
        System.out.println("调用的方法为 " + method);

        Object returnValue = method.invoke(subject, args);

        System.out.println("代理完成!");

        return returnValue;
    }
}
