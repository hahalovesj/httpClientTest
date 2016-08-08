package com.httpclient;
//根据老徐的教程学习httpclient 
//Post

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class httpclientPost {
	//张飞博客，POST请求的表单提交方式,代码如下:http://www.cnblogs.com/zhangfei/p/5099036.html
	
	public void post(String url, Map<String, String> params){
	    CloseableHttpClient httpClient = null;
	    HttpPost httpPost = null;
	    try {
	        httpClient = HttpClients.createDefault();
	        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(20000).setConnectTimeout(20000).build();
	        httpPost = new HttpPost(url);
	        httpPost.setConfig(requestConfig);
	        List<NameValuePair> ps = new ArrayList<NameValuePair>();
	        for (String pKey : params.keySet()) {
	            ps.add(new BasicNameValuePair(pKey, params.get(pKey)));
	        }
	        httpPost.setEntity(new UrlEncodedFormEntity(ps));
	        CloseableHttpResponse response = httpClient.execute(httpPost);
	        HttpEntity httpEntity = response.getEntity();
	        System.out.println(EntityUtils.toString(httpEntity,"utf-8"));
	    } catch (ClientProtocolException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }finally{
	        try {
	            if(httpPost!=null){
	                httpPost.releaseConnection();
	            }
	            if(httpClient!=null){
	                httpClient.close();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

	//张飞博客，POST请求的RAW参数传递:
	public void post(String url, String body){
	    CloseableHttpClient httpClient = null;
	    HttpPost httpPost = null;
	    try {
	        httpClient = HttpClients.createDefault();
	        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(20000).setConnectTimeout(20000).build();
	        httpPost = new HttpPost(url);
	        httpPost.setConfig(requestConfig);
	        httpPost.setEntity(new StringEntity(body));
	        CloseableHttpResponse response = httpClient.execute(httpPost);
	        HttpEntity httpEntity = response.getEntity();
	        System.out.println(EntityUtils.toString(httpEntity,"utf-8"));
	    } catch (ClientProtocolException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }finally{
	        try {
	            if(httpPost!=null){
	                httpPost.releaseConnection();
	            }
	            if(httpClient!=null){
	                httpClient.close();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	public static void main(String[] args) {
		
		//创建HttpClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//如果发送是Post请求，创建HttpPost对象
		 HttpPost httppost = new HttpPost("http://www.baidu.com/"); 
		//执行POST请求
		try {
			//post请求参数配置
			List<NameValuePair> formparams = new ArrayList<NameValuePair>(); 
			formparams.add(new BasicNameValuePair("name", "xxx"));
			formparams.add(new BasicNameValuePair("pwd", "123456")); 
			
			//使用httpclient的execute方法发送接口请求
			CloseableHttpResponse response =  httpClient.execute(httppost);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		

	}

}
