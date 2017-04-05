package cn.com.mx.simpletest;

/**
 * Created by wangchangye on 2017/4/1.
 */
public class String2Int {

    public static void main(String[] args) {
        String key = "A0000120236";
        int result = getHashKey(key);
        System.out.println(result);
    }

    public static int getHashKey(String key) {
        int hashCode = 0;
        int i = 0;
        int len = key.length();
        for (; i < len; i++) {
            hashCode = ((hashCode * 33) + key.codePointAt(i)) & 0x7fffffff;
        }
        return hashCode;
    }

}
