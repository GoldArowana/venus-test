package cn.com.mx.simpletest.stringandmap;

public class StringTest {
	public static void main(String[] args) {
		String str = "abc";
		String string = String.valueOf(str);
		String string2 = new StringBuffer(str).append("d").toString();
		System.err.println(string2);
		
		
		String str2 = "1";
		Integer integer = Integer.getInteger(str2, 5);
		int int1 = Integer.parseInt(str2);
		System.err.println(int1);
		System.err.println(integer);
		
		print("a","b");
		
		String string3 = String.format("here is what u see %d, %20s", 1, "aaa");
		System.err.println("==="+string3);
	}//end of main
		
	public static void print(String ... s){
	    for(String a: s)
	        System.out.println(a);
	}
	
	
}//end of class
