package cn.com.mx.LinteCode;

/**
 * Created by wangchangye on 2017/3/29.
 */
public class Q3_addBinary {

	public static String addBinary(String a, String b) {
		if (a == null || b == null || a.length() == 0 || b.length() == 0) {
			return null;
		}
		int decimalA = Integer.parseInt(a, 2);
		int decimalB = Integer.parseInt(b, 2);

		int sum = decimalA + decimalB;

		return Integer.toBinaryString(sum);
	}

	public static void main(String[] args) {
		String result = addBinary("11", "1");
		System.out.println(result);
	}
}
