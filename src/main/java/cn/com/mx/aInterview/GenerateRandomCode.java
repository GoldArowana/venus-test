package cn.com.mx.aInterview;

import java.util.Random;

/**
 * @Description 生成指定长度的随机码
 */
public class GenerateRandomCode {
	
	/**
	 * @Description 生成指定长度的随机数字验证码
	 * @param length
	 * @return
	 */
	public static String generateValidationCode(int length){
		return getRandomNum(length);
	}
	
	/**
	 * @Description 生成指定长度的、数字字母组合的随机token
	 * @param length
	 * @return
	 */
	public static String generateToken(int length){
		return getRandomNumAndChar(length);
	}
	
	
	/**
	 * @Description 生成随机数字组合 
	 * @param length
	 * @return
	 */
	private static String getRandomNum(int length) {
		String val = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			// 数字
			int tmp = random.nextInt(10);
			//优化，出现不吉利的4时，替换成吉利的8
			if(tmp == 4){
				tmp = 8;
			}
			val += String.valueOf(tmp);
		}
		return val;
	}
	
	/**
	 * @Description: 生成随机数字和字母组合 
	 * @param length
	 * @return
	 */
	private static String getRandomNumAndChar(int length) {
		String val = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			// 输出字母还是数字
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			// 字符串
			if ("char".equalsIgnoreCase(charOrNum)) {
				// 取得大写字母还是小写字母
				int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val += (char) (choice + random.nextInt(26));
			} else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			System.out.println("生成验证码为：" + getRandomNum(6));
			System.out.println("生成token为：" + getRandomNumAndChar(16));
		}
	}

}
