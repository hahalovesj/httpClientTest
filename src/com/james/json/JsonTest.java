//使用httpClient进行接口测试
package com.james.json;
/* http://lijingshou.iteye.com/blog/1998209 
 * 
 * 处理Json对象的基本API
 * JSON包中最常用的两个类就是JSONObject和JSONArray,具体可以参考JSON for java入门总结
 * 如下是自己模仿的简单例子: 
 */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class JsonTest {
	
	
		public static void main(String[] args) {
			
			
			try {
				// Test JSONObject.
				String username = null;
				int userage = 0;
				JSONObject jsonobj = null;
				jsonobj = new JSONObject("{'name':'jingshou','age':30}");			 	        
				username = jsonobj.getString("name");
				userage = jsonobj.getInt("age");
			
		        System.out.println(jsonobj.toString());
		        System.out.println(username+":"+userage); 
		        System.out.println("**********");
		        
		        // Test JSONArray.
		        JSONArray jsonarray = null;
				
				jsonarray = new JSONArray("[{'name':'jingshou','age':30},{'name':'xiaohong','age':29}]");
				 for(int i=0;i<jsonarray.length();i++){
			        	JSONObject jo = null;
						jo = jsonarray.getJSONObject(i);
						
			        	System.out.println(jo);
	       	            String name1 = null;
	       	            name1 = jo.getString("name");
			            int age1 = 0;
						age1 = jo.getInt("age");
				
			            System.out.println("name1= "+name1);
			            System.out.println("age1= "+age1);
				 }
			}catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        }
		}
		

	

