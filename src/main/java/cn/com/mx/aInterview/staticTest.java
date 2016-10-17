package cn.com.mx.aInterview;

public class staticTest {
	static String content = "【国美+】亲爱的用户，您正在使用该手机号领取优惠券，验证码为[******]。";
	public static void main(String[] args) {
		String verificationCode = GenerateRandomCode.generateValidationCode(6);
		System.out.println(verificationCode);
		content = content.replace("******", verificationCode);
		System.out.println(content);
	}
}
