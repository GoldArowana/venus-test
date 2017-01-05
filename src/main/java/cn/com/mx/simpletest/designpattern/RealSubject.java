package cn.com.mx.simpletest.designpattern;

/**
 * Created by wangchangye on 2017/1/5.
 *
 * @Author wangchangye
 */
public class RealSubject implements Subject {
    @Override
    public String SayHello(String name) {
        return "Hello! " + name;
    }

    @Override
    public String SayGoodBye() {
        return "GoodBye!";
    }
}
