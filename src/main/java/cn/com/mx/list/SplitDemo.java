package test;


import java.io.IOException;

/*
*/
public class SplitDemo {

	
	public static void main(String[] args) throws IOException {
		
		String url = "Appid/From";
		String[] array = url.split("/");
		System.out.println(array[0]);
		
	}
}
