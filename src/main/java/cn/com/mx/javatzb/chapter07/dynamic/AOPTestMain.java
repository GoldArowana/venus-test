package cn.com.mx.javatzb.chapter07.dynamic;

public class AOPTestMain {

	public static void main(String []args) {
		try {
			HelloInterface hello = BeanFactory.getBean("cn.com.mx.javatzb.chapter07.dynamic.HelloImpl" , HelloInterface.class);
			hello.setInfo("xieyuooo", "xiaopang");
			//hello.getInfos1();//这里报空指针了。
			//hello.getInfos2();
//			hello.display();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
