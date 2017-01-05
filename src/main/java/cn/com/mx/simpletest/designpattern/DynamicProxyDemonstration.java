package cn.com.mx.simpletest.designpattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by wangchangye on 2017/1/5.
 *
 * @Author wangchangye
 */
public class DynamicProxyDemonstration {

    public static void main(String[] args) {
        Subject realSubject = new RealSubject();

        InvocationHandler handler = new InvocationHandlerImpl(realSubject);

        ClassLoader loader = handler.getClass().getClassLoader();
        Class[] interfaces = realSubject.getClass().getInterfaces();
        /**
         * 该方法用于为指定类装载器、一组接口及调用处理器生成动态代理类实例
         */
        Subject subject = (Subject) Proxy.newProxyInstance(loader, interfaces, handler);

        System.out.println("动态代理对象的类型："+subject.getClass().getName());

        String hello = subject.SayHello("wchy");
        System.out.println(hello);
//        String goodbye = subject.SayGoodBye();
//        System.out.println(goodbye);

}
}
