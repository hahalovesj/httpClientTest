package com.httpclient.copy;
//根据老徐的教程学习httpclient
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class httpclientGet {

	public static void main(String[] args) {
		
		//创建HttpClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//如果发送是GET请求，创建HttpGet对象
		 HttpGet httpget = new HttpGet("http://www.baidu.com/"); 
		//执行GET请求
		try {
			CloseableHttpResponse response =  httpClient.execute(httpget);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
