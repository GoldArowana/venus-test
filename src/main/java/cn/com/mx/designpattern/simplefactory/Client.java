package cn.com.mx.designpattern.simplefactory;

/**
 * Created by frank on 2015/12/21.
 */
public class Client {
    public static void main(String[] args){
        Api api = Factory.createApi(2);
        api.operation("正在使用简单工厂");
    }
}
