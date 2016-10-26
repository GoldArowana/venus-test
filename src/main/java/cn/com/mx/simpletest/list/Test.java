package cn.com.mx.simpletest.list;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Charsets;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//long l = System.currentTimeMillis(); //当前时间的毫秒
		long l = 1421377731108L; //当前时间的毫秒
		System.out.println(l);
		Date date= new java.util.Date(l);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));//打印 转换为时间格式
        char a = 'c';
        System.err.println(a);
        System.err.println("--------------");
        
        String str = ".gif";
        byte[] bs = str.getBytes(StandardCharsets.ISO_8859_1);
        for (byte b : bs) {
			System.err.println(Integer.valueOf((int)b).toHexString(b));
		}
        
        System.err.println("------------");
        System.err.println(new String(Arrays.copyOf(bs, 4), StandardCharsets.ISO_8859_1));
        System.err.println(new String(bs,Charsets.ISO_8859_1));
        
        //这个是.gif的16进制
        byte[] b = new byte[]{(byte) 0x2e, (byte) 0x67, (byte) 0x69, (byte) 0x66, (byte)0};
        System.err.println(new String(Arrays.copyOf(bs, 4),StandardCharsets.ISO_8859_1));
        System.err.println("-----");
        Map<String, String> map = new HashMap<>();
        map.put("\u0089\u0050\u004E\u0047", ".png");
        map.put("\u0047\u0049\u0046\u0038", ".gif");
        System.err.println(map.get(new String(Arrays.copyOf(new byte[]{(byte) 0x47, (byte) 0x49, (byte) 0x46, (byte) 0x38, (byte)0}, 4),Charsets.ISO_8859_1)));
        
	}

}
