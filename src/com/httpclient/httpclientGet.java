package com.httpclient;
//根据老徐的教程学习httpclient
//Get
import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class httpclientGet {
	//张飞博客，GET请求时，参数一般是写在链接上的，代码如下：
	public void get(String url){
	    CloseableHttpClient httpClient = null;
	    HttpGet httpGet = null;
	    try {
	        httpClient = HttpClients.createDefault();
	        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(20000).setConnectTimeout(20000).build();     
	        httpGet = new HttpGet(url);
	        httpGet.setConfig(requestConfig);
	        CloseableHttpResponse response = httpClient.execute(httpGet);
	        HttpEntity httpEntity = response.getEntity();
	        System.out.println(EntityUtils.toString(httpEntity,"utf-8"));
	    } catch (ClientProtocolException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }finally{
	        try {
	            if(httpGet!=null){
	                httpGet.releaseConnection();
	            }
	            if(httpClient!=null){
	                httpClient.close();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
	//张飞博客，Get请求，如果想把参数不写在链接上，单独的传进去，则可以这样
	public void get(String url, Map<String, String> params){
	    CloseableHttpClient httpClient = null;
	    HttpGet httpGet = null;
	    try {
	        httpClient = HttpClients.createDefault();
	        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(20000).setConnectTimeout(20000).build();
	        String ps = "";
	        for (String pKey : params.keySet()) {
	            if(!"".equals(ps)){
	                ps = ps + "&";
	            }
	            ps = pKey+"="+params.get(pKey);
	        }
	        if(!"".equals(ps)){
	            url = url + "?" + ps;
	        }
	        httpGet = new HttpGet(url);
	        httpGet.setConfig(requestConfig);
	        CloseableHttpResponse response = httpClient.execute(httpGet);
	        HttpEntity httpEntity = response.getEntity();
	        System.out.println(EntityUtils.toString(httpEntity,"utf-8"));
	    } catch (ClientProtocolException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }finally{
	        try {
	            if(httpGet!=null){
	                httpGet.releaseConnection();
	            }
	            if(httpClient!=null){
	                httpClient.close();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	//老徐PPT，httpclient接口测试
	public void getXu(String url){
				//创建HttpClient对象
				CloseableHttpClient httpClient = HttpClients.createDefault();
				//如果发送是GET请求，创建HttpGet对象
				 HttpGet httpget = new HttpGet(url); 
				//执行GET请求
				try {
					CloseableHttpResponse response =  httpClient.execute(httpget);
					//设置请求和传输超时时间
					RequestConfig requestConfig = RequestConfig.custom()
					.setSocketTimeout(20000).setConnectTimeout(20000).build();
					//get请求设置请求和传输超时时间 
					httpget.setConfig(requestConfig);

				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally{
			        try {
			            if(httpget!=null){
			                httpget.releaseConnection();
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
		
		
		

	}

}
