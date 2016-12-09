package cn.com.mx.designpattern.factory;

public class ProductB2 implements AbstractProductB {
    @Override
    public String doSomething() {
        String clsName = this.getClass().getName();
        System.out.println(clsName + " doSomething");
        return clsName;
    }
}

