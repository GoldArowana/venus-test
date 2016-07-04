package cn.com.mx.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
	
	public static void main(String[] args) {
		//(?:X)是非捕获组，也就是X不单独作为一个分组提取出来，不能用match.group(num) 这样的语法提取出来
		String regex="(\\d+)?(?:x(\\d+))?(c([TB]?[LR]?))?(z)?(?:q(\\d+))?";
		String params = "320x160cTzq75";   //x160  q后面的75可以不传,所以不捕获
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(params);
		if(matcher.matches()){
			System.out.println(matcher.group(1));//1-6分别是:320 160 cT T z 75
			System.out.println(matcher.group(2));
			System.out.println(matcher.group(3));
			System.out.println(matcher.group(4));
			System.out.println(matcher.group(5));
			System.out.println(matcher.group(6));
		}
		//代码中快速调用
		boolean b = Pattern.matches(regex, params);
		System.out.println(b);
		
		//matches全量匹配,find() or find(start)查找下一个符合序列
		boolean find = Pattern.compile(regex).matcher(params).matches();
		System.out.println(find);
		
		String a="123345";
		boolean c = a.matches("\\d+");
		System.out.println(c);
	}
}
