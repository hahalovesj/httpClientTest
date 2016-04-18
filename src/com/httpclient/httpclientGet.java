package com.httpclient;
//��������Ľ̳�ѧϰhttpclient
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
	//�ŷɲ��ͣ�GET����ʱ������һ����д�������ϵģ��������£�
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
	//�ŷɲ��ͣ�Get���������Ѳ�����д�������ϣ������Ĵ���ȥ�����������
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
	
	//����PPT��httpclient�ӿڲ���
	public void getXu(String url){
				//����HttpClient����
				CloseableHttpClient httpClient = HttpClients.createDefault();
				//���������GET���󣬴���HttpGet����
				 HttpGet httpget = new HttpGet(url); 
				//ִ��GET����
				try {
					CloseableHttpResponse response =  httpClient.execute(httpget);
					//��������ʹ��䳬ʱʱ��
					RequestConfig requestConfig = RequestConfig.custom()
					.setSocketTimeout(20000).setConnectTimeout(20000).build();
					//get������������ʹ��䳬ʱʱ�� 
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
