package cn.com.mx;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/*
����:		web.cr6868.com HTTP�ӿ� ���Ͷ���

˵��:		http://web.cr6868.com/asmx/smsservice.aspx?name=��¼��&pwd=�ӿ�����&mobile=�ֻ�����&content=����&sign=ǩ��&stime=����ʱ��&type=pt&extno=�Զ�����չ��
*/
public class xioo {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		//��������
		// ����StringBuffer�������������ַ���
		StringBuffer sb = new StringBuffer("http://web.cr6868.com/asmx/smsservice.aspx?");
		//String content = "�װ��Ļ�Ա�������ڰ��罻�˺ţ���֤��Ϊ1234567,10��������Ч��";
		//String content = "��л�����������������������Ա��ϵ��֮ǰ��������ͨ����¼�̼ҹ����̨http://xpop.gomeplus.com/login ��������������ף���ڹ�����ƽ̨����˳����������¡����T�˶���";
		String content = "�װ��Ļ�Ա�������ڿ���ע�����+�˺Ų����罻�˺ţ���֤��Ϊ123456,10��������Ч��";
		String sign = "����+";
		//String baseurl = configCenter.get("sms.url");
		//StringBuffer sb = new StringBuffer(baseurl);
		sb.append("name=15313729295");
		sb.append("&pwd=3040D5ACE3A9C2EE25C46F42FB9C");//C��ȷ   D����
		sb.append("&mobile=15122090587");//13161097875  13811664749
		sb.append("&content=" + URLEncoder.encode(content, "UTF-8"));
		sb.append("&stime=");
		sb.append("&sign=" + URLEncoder.encode(sign, "UTF-8"));
		sb.append("&type=pt&extno=");
		//log.info("�����urlΪ" + new String(sb.toString().getBytes("GBK"),"UTF-8"));
		URL url = new URL(sb.toString());
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		InputStream is = url.openStream();
		String returnStr = convertStreamToString(is);
		System.out.println(returnStr);
		//log.info("������ŵķ���ֵΪ" + returnStr);
		if(!returnStr.startsWith("0")){
			//�������ö���
			String newsign = "������+��";
			//log.info("�����������أ�");
			String qixinUrl = "http://221.179.180.158:9007/QxtSms/QxtFirewall?";
			StringBuffer sb2 = new StringBuffer(qixinUrl);
			sb2.append("OperID=meixin")//�����˺�
			  .append("&OperPass=meixin")//��������
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
	 * @Description ת������ֵ����ΪUTF-8��ʽ
	 * @author wangchangye
	 * @date 2016��2��16�� ����4:55:19
	 * @param is
	 * @return8888888h88888888888888888888888888888888888888888888888888888888888888
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
