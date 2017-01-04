package cn.com.mx.highconcurrency.ch5;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
public static void main(String[] args) {
    ConcurrentHashMap map=new ConcurrentHashMap();
    map.put("a", "aa");
    System.out.println(map);
}
}
