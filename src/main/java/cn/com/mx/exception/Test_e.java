package cn.com.mx.exception;

public class Test_e {
	public static void main(String[] args) {
		div(10,0);
	}
	
	 public static int div(int a, int b) 
	    { 
	        try 
	        { 
	            return a/b; 
	        } catch (Exception e) 
	        { 
	           //e.printStackTrace(); 
	        	//System.out.println(e.getMessage());
	        	System.out.println(e.toString());
	           //System.out.println(e.getLocalizedMessage());
	           //System.out.println(e.getCause());
	        } 
	        return 0; 
	    } 
	
	
	
	
}
