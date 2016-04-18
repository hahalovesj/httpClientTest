/* http://lijingshou.iteye.com/blog/1998209 
 * 
 * ʹ��httpclient����API����.
 * ����������ʾ���ʹ��httpClient��ȡAPI���ص�JSON�ַ����Լ�����:
 * 
 * */
package com.james.json;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class SimpleServiceTest {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		//����HttpClient����
		CloseableHttpClient httpclient = HttpClients.createDefault();
		//���������Post���󣬴���HttpPost����
		HttpPost httppost = new HttpPost("http://jingshou.com/admin/searchUser.action?search_loginid=jingshou");
		//ʹ��httpclient��execute�������ͽӿ�����
		CloseableHttpResponse response = httpclient.execute(httppost);
		try {
			HttpEntity myEntity = response.getEntity();
			System.out.println(myEntity.getContentType());
			System.out.println(myEntity.getContentLength());
			
			String resString = EntityUtils.toString(myEntity);
            // ʹ�÷��ص��ַ���ֱ�ӹ���һ��JSONObject		
			JSONObject jsonobj;
			try {
				jsonobj = new JSONObject(resString);
			
			System.out.println(jsonobj.toString());
			// ��ȡ���ض�����"resultSize��ֵ"
			int resutltSize = jsonobj.getInt("resultSize");
			System.out.println("Search Results Size is: "+ resutltSize); 
			// ��ȡ"clients"��ֵ,����һ��JSONArray
			JSONArray jsonarray = jsonobj.getJSONArray("clients");
			System.out.println(jsonarray.toString());
			
	        
		} finally {
		    response.close();
		}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}