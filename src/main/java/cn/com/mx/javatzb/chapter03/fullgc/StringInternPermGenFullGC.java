package cn.com.mx.javatzb.chapter03.fullgc;



public class StringInternPermGenFullGC {

	/**
	 * ���������������У�ע������JDK 1.6�����У���JDK 1.7�����еĽ����ȫ��ͬ
	 * ���з�ʽΪjava -XX:+PrintGCDetials -XX:PermSize10m -XX:MaxPermSize=10m chapter3.fullgc.StringInternPermGenFullGC
	 * @param args
	 */
	public static void main(String []args) {
		int i = 0;
		while(true) {
			("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF" + i++).intern();
		}

	}
}
