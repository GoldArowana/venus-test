package cn.com.mx.java8;

interface Test1 {
    default int val1() { return 1; }
}

class T2 {
    static <T extends Test1> int ret1(T t) {
        return t.val1();
    }
}

public class GenericBoundSample {
    public static void main(String[] args) {
        class A implements Test1 {}
        T2.ret1(new A());
    }
}
