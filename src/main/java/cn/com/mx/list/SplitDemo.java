package cn.com.mx.list;


import java.io.IOException;

/*
*/
public class SplitDemo {

	
	public static void main(String[] args) throws IOException {
		
		String url = "http://i-dev.meixincdn.com/v1/img/T1HyLTBy_v1RCvBVdK.jpg";
		
		String substring = url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf("/") + 19);
		System.err.println(substring);
		
		String[] array = url.split("/");
		System.out.println(array[5].substring(0, array[5].length()-4));
		
	}
}
