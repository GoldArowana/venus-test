package cn.com.mx.javatzb.chapter02;

public class JavaSampleAppend {

	/**
	 * �˴���ֻ�Ǽ򵥵ļӷ������������У������
	 * ʹ�� javap -verbose chapter2.JavaSampleAppend
	 * ���ɵõ�������ָ��������빤��Ҳ������ĵ���
	 * @param args
	 */
	public static void main(String []args) {
		int a = 2;//[-1~5]��iconst_m1��iconst_[0-5]��������bipushָ��
		int b = 2;
		int c = a + b;
	}
	
	/**
	 * ͬ��Ĵ���Ա�һ���ֽ��룬Ҫ��һ�����ر���this
	 */
	public void test() {
		int a = 2;
		int b = 2;
		int c = 100;
		int d = 100;
		int e = 100;
		int f = 100;
		int g = 100;
		int m = 100;
		int t = 100;
		int ff = 100;
		int aaa = 100;
		int bb = 100;
		int x = 100;
		int y = 100;
		//int c = a + b;
	}
	
	/**
	 * ͬ��Ĵ���Ա�һ���ֽ���
	 */
	public static void testStatic() {
		int a = 2;//[-1~5]��iconst_m1��iconst_[0-5]��������bipushָ��
		int b = 2;
		int c = a + b;
	}
}
