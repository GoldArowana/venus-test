package cn.com.mx.javatzb.chapter03.tools.btrace;

import java.util.HashMap;
import java.util.Map;

/**
 * ����һ�α�BTrace���ٵĴ���Ŷ��
 * ����ٵĴ��룬����뵽scriptĿ¼���ҵ��ļ�BTraceTest.java
 * Ȼ�������еĽ��ܽ��в�������
 * @author Administrator
 *
 */
public class TestHello {

	public String name = "testHello";

    public final static int THREE_M_SIZE = 3 * 1024 * 1024;

    public static void main(String []args) throws InterruptedException {
    	System.out.println("====================>");
        TestHello testHello = new TestHello();
        int times = 1;
        String a = "xieyuooo_";
        Map<String , String> map = new HashMap<String , String>();
        map.put("fuck" , "fuckAAA");
        while(true) {
            testHello.test(times++ , a + times , map);
            Thread.sleep(1000);
        }
    }

    public boolean test(int times , String name , Map<String , String>map) throws InterruptedException {
        System.out.println("====================>");
        Thread.sleep(2000);
        return true;
    }
}
