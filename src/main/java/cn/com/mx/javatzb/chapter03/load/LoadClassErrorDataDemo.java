package cn.com.mx.javatzb.chapter03.load;

import java.util.ArrayList;
import java.util.List;

public class LoadClassErrorDataDemo {
	
	private final static LoadClassErrorDataDemo INIT_OBJECT = new LoadClassErrorDataDemo();
   	
	//ֱ�Ӹ�LIST��ֵ��һ�Կ��������ʲô��
	//private static List<String> LIST = new ArrayList<String>();
	private static List<String> LIST;
	
   	static {
   		LIST = new ArrayList<String>();
   		LIST.add("1");
   	}
   	
   	private LoadClassErrorDataDemo() {
   	  	if(LIST == null) {
   	  		LIST = new ArrayList<String>();	
   	  	}
   	  	LIST.add("2");
   	  	LIST.add("3");
   	}
   	
   	public void displayCacheSize() {
			for(String str : LIST) {
			   System.out.println(str);	
			}
		}
   	
   	public static LoadClassErrorDataDemo getInstance() {
   	   return INIT_OBJECT;
   	}

   	/**
   	 * ����������ϣ���ArrayList�ĸ�ֵ�������ڹ��췽���У����Ӧ�ð�2��3����ֵ
   	 * ����ʵ�ʽ��ȷʵ1
   	 * @param args
   	 */
    public static void main(String []args) {
    	LoadClassErrorDataDemo forInit = LoadClassErrorDataDemo.getInstance();
       	forInit.displayCacheSize();
    }
}
