package com.httpclient.copy;
//��������Ľ̳�ѧϰhttpclient
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class httpclientGet {

	public static void main(String[] args) {
		
		//����HttpClient����
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//���������GET���󣬴���HttpGet����
		 HttpGet httpget = new HttpGet("http://www.baidu.com/"); 
		//ִ��GET����
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
