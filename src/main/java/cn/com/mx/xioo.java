package cn.com.mx;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/*
功能:		web.cr6868.com HTTP接口 发送短信

说明:		http://web.cr6868.com/asmx/smsservice.aspx?name=登录名&pwd=接口密码&mobile=手机号码&content=内容&sign=签名&stime=发送时间&type=pt&extno=自定义扩展码
*/
public class xioo {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		//发送内容
		// 创建StringBuffer对象用来操作字符串
		StringBuffer sb = new StringBuffer("http://web.cr6868.com/asmx/smsservice.aspx?");
		//String content = "亲爱的会员，您正在绑定社交账号，验证码为1234567,10分钟内有效！";
		//String content = "感谢加入国美＋。在我们招商人员联系您之前您还可以通过登录商家管理后台http://xpop.gomeplus.com/login 进行自助操作。祝您在国美＋平台开店顺利，生意兴隆。回T退订。";
		String content = "亲爱的会员，您正在快速注册国美+账号并绑定社交账号，验证码为123456,10分钟内有效！";
		String sign = "国美+";
		//String baseurl = configCenter.get("sms.url");
		//StringBuffer sb = new StringBuffer(baseurl);
		sb.append("name=15313729295");
		sb.append("&pwd=3040D5ACE3A9C2EE25C46F42FB9C");//C正确   D错误
		sb.append("&mobile=18611405099");//13161097875  13811664749
		sb.append("&content=" + URLEncoder.encode(content, "UTF-8"));
		sb.append("&stime=");
		sb.append("&sign=" + URLEncoder.encode(sign, "UTF-8"));
		sb.append("&type=pt&extno=");
		//log.info("请求的url为" + new String(sb.toString().getBytes("GBK"),"UTF-8"));
		URL url = new URL(sb.toString());
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		InputStream is = url.openStream();
		String returnStr = convertStreamToString(is);
		System.out.println(returnStr);
		//log.info("创瑞短信的返回值为" + returnStr);
		if(!returnStr.startsWith("0")){
			//启动备用短信
			String newsign = "【国美+】";
			//log.info("启动备用网关！");
			String qixinUrl = "http://221.179.180.158:9007/QxtSms/QxtFirewall?";
			StringBuffer sb2 = new StringBuffer(qixinUrl);
			sb2.append("OperID=meixin")//国都账号
			  .append("&OperPass=meixin")//国都密码
			  .append("&DesMobile=18911261622")
			  .append("&Content=" + URLEncoder.encode(newsign + content, "GBK"))
			  .append("&ContentType=15")
			  .append("&SendTime=")
			  .append("&ValidTime=")
			  .append("&AppendID=");
			System.out.println(sb2.toString());
			/*CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(sb2.toString());
			CloseableHttpResponse response = httpclient.execute(httpPost);
			return convertStreamToString(response.getEntity().getContent());*/
			URL url2 = new URL(sb2.toString());
			HttpURLConnection connection2 = (HttpURLConnection) url2.openConnection();
			connection2.setRequestMethod("POST");
			InputStream is2 = url2.openStream();
			String returnStr2 = convertStreamToString(is2);
			//return returnStr2;
			System.out.println(returnStr2);
		}
		//return returnStr;
	}

	/**
	 * 
	 * @Description 转换返回值类型为UTF-8格式
	 * @author wangchangye
	 * @date 2016年2月16日 下午4:55:19
	 * @param is
	 * @return
	 */
	public static  String convertStreamToString(InputStream is) {
		StringBuilder sb1 = new StringBuilder();
		byte[] bytes = new byte[4096];
		int size = 0;

		try {
			while ((size = is.read(bytes)) > 0) {
				String str = new String(bytes, 0, size, "UTF-8");
				sb1.append(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb1.toString();
	}

}
