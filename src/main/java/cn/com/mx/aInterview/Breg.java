package cn.com.mx.aInterview;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Breg {
	public static void main(String[] args) {
        //String str = "1a$_#2a@_@3a*_*4a";
		String str = "1sdfa"
				+ "d士大夫撒旦法http:\n"
				+ "//242.com$_#a\r\n"
				+ "d士大夫撒旦法http://2\r\n"
				+ "@_@旦法h\r\n"
				+ "ttp:*_*400-234-32jdc\n"
				+ "ds1"
				+ "1\n"
				+ "1\n";
        //String reg = "(\\d+)\\$_#(\\d+)@_@(\\d+)\\*_\\*(\\d+)"; 
        //String reg = "(.*)\\$_#(.*)@_@(.*)\\*_\\*(.*)";//不能匹配除换行符的一切
		String reg = "([\\s\\S]*)\\$_#([\\s\\S]*)@_@([\\s\\S]*)\\*_\\*([\\s\\S]*)"; //匹配一切包括换行符\n \r\n
        //这些符号需要转义	* . ? + $ ^ [ ] ( ) { } | \ /
		Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            for (int i = 0; i <= matcher.groupCount(); i++) {
                System.out.println("group " + i + ":" + matcher.group(i));
            }
        }
    }//end
	
	
}//
