/* http://lijingshou.iteye.com/blog/1998209 
 *
 * 处理Json对象的基本API
 * JSON包中最常用的两个类就是JSONObject和JSONArray,具体可以参考JSON for java入门总结
 * 如下是自己模仿的简单例子: 
 */
package com.james.json;


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
				//可以通过字符串直接构造一个JSONObject,JSONObject里的key在显式传入的时候是用单引号包裹起来的,但是打印出来的时候依然是我们期望的双引号
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
		

	

