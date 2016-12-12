package cn.com.mx.java8;

import java.util.*;

public class AnonymousInterfaceSample {
    public static void main(String[] args) {
        Runnable noArg = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        };
        noArg.run();

        // 按长度排序
        List<String> strings = Arrays.asList("aa", "test", "1");
        Collections.sort(strings, (s1, s2) -> ((Integer)s1.length()).compareTo(s2.length()));
        System.out.println(strings);
    }
}
