/* http://lijingshou.iteye.com/blog/1998209 
 * 
 * 使用httpclient处理API返回.
 * 如下例子演示如何使用httpClient获取API返回的JSON字符串以及处理:
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
		//创建HttpClient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();
		//如果发送是Post请求，创建HttpPost对象
		HttpPost httppost = new HttpPost("http://jingshou.com/admin/searchUser.action?search_loginid=jingshou");
		//使用httpclient的execute方法发送接口请求
		CloseableHttpResponse response = httpclient.execute(httppost);
		try {
			HttpEntity myEntity = response.getEntity();
			System.out.println(myEntity.getContentType());
			System.out.println(myEntity.getContentLength());
			
			String resString = EntityUtils.toString(myEntity);
            // 使用返回的字符串直接构造一个JSONObject		
			JSONObject jsonobj;
			try {
				jsonobj = new JSONObject(resString);
			
			System.out.println(jsonobj.toString());
			// 获取返回对象中"resultSize的值"
			int resutltSize = jsonobj.getInt("resultSize");
			System.out.println("Search Results Size is: "+ resutltSize); 
			// 获取"clients"的值,它是一个JSONArray
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