package cn.com.mx.webapi.servlet.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test {
   
	public static void main(String[] args) throws Exception {
		Document document  =  Jsoup.connect("http://10.125.31.218:8088/governance/services").ignoreContentType(true).userAgent("Mozilla").header("Authorization", "Basic Z3Vlc3Q6Z3Vlc3Q=").get();
		Elements els = document.select("#table_o a");
		System.out.println("线上");
		for (Element element : els) {
			System.out.println(element.text() + " -->" + element.parent().nextElementSibling().text());
		}
		System.out.println("本地venus-social-1.9.1");
		readFileByLines("C:\\Users\\yuanchangjun.MEIXIN\\Desktop\\1\\venus-social-dubbo-provider.xml");
		/*document  =  Jsoup.connect("http://10.125.201.33:8181/venus-social").ignoreContentType(true).userAgent("Mozilla").get();
		Elements els = document.select("a");
		for (Element element : els) {
			if(element.absUrl("href").indexOf("venus-social-1.9.1.tar.gz")>=0){
				System.out.println(element.absUrl("href"));
				//zip("C:\\Users\\yuanchangjun.MEIXIN\\Desktop\\1\\venus-social-1.9.1.tar.gz","C:\\Users\\yuanchangjun.MEIXIN\\Desktop\\1\\");
				readFileByLines("C:\\Users\\yuanchangjun.MEIXIN\\Desktop\\1\\venus-social-dubbo-provider.xml");
			}
		}*/
		
	}
	
    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                read(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
    public static void read(String ajax){
    	String interfaces = "",version = "";
		Pattern p = Pattern.compile("interface=\"(.+?)\"");
		Matcher m = p.matcher(ajax);
		while (m.find()){  
			interfaces = m.group(1);
		}  
		
		p = Pattern.compile("version=\"(.+?)\"");
		m = p.matcher(ajax);
		while (m.find()){  
			version = m.group(1);
		} 
		if(!StringUtils.isBlank(interfaces)){
			System.out.println(interfaces +" - >" + version);
		}
    }
}