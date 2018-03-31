package com.xiaoyun.main.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.xiaoyun.main.model.MyX509TrustManager;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

public class HttpTool {
	private static Logger log = Logger.getLogger(HttpTool.class);
	
	/**
	* 获取当前请求路径
	*
	**/
	public static String getURL(HttpServletRequest request){
		  String   url  = request.getScheme()+"://"; //请求协议 http 或 https  
		  url+=request.getHeader("host");  // 请求服务器  
		  url+=request.getRequestURI();     // 工程名    
		  if(request.getQueryString()!=null) //判断请求参数是否为空
		  url+="?"+request.getQueryString();   // 参数 
		  return url;
	}
	/** 
     * 使用Get方式获取数据 
     *  
     * @param url 
     *            URL包括参数，http://HOST/XX?XX=XX&XXX=XXX 
     * @param charset 
     * @return 
     */  
    public static String sendGet(String url, String charset) {  
        String result = "";  
        BufferedReader in = null;  
        try {  
            URL realUrl = new URL(url);  
            // 打开和URL之间的连接  
            URLConnection connection = realUrl.openConnection();  
            // 设置通用的请求属性  
            connection.setRequestProperty("accept", "*/*");  
            connection.setRequestProperty("connection", "Keep-Alive");  
            connection.setRequestProperty("user-agent",  
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");  
            // 建立实际的连接  
            connection.connect();  
            // 定义 BufferedReader输入流来读取URL的响应  
            in = new BufferedReader(new InputStreamReader(  
                    connection.getInputStream(), charset));  
            String line;  
            while ((line = in.readLine()) != null) {  
                result += line;  
            }  
        } catch (Exception e) {  
            log.warn("发送GET请求出现异常！" + e);  
            e.printStackTrace();  
        }  
        // 使用finally块来关闭输入流  
        finally {  
            try {  
                if (in != null) {  
                    in.close();  
                }  
            } catch (Exception e2) {  
                e2.printStackTrace();  
            }  
        }  
        return result;  
    }  
  
    /**  
     * POST请求，字符串形式数据  
     * @param url 请求地址  
     * @param param 请求数据  
     * @param charset 编码方式  
     */  
    public static JSONObject sendPostUrl(String url, String param, String charset) {  
  
        PrintWriter out = null;  
        BufferedReader in = null;  
        String result = "";  
        try {  
            URL realUrl = new URL(url);  
            // 打开和URL之间的连接  
            URLConnection conn = realUrl.openConnection();  
            // 设置通用的请求属性  
            conn.setRequestProperty("accept", "*/*");  
            conn.setRequestProperty("connection", "Keep-Alive");  
            conn.setRequestProperty("user-agent",  
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");  
            // 发送POST请求必须设置如下两行  
            conn.setDoOutput(true);  
            conn.setDoInput(true);  
            // 获取URLConnection对象对应的输出流  
            out = new PrintWriter(conn.getOutputStream());  
            // 发送请求参数  
            out.print(param);  
            // flush输出流的缓冲  
            out.flush();  
            // 定义BufferedReader输入流来读取URL的响应  
            in = new BufferedReader(new InputStreamReader(  
                    conn.getInputStream(), charset));  
            String line;  
            while ((line = in.readLine()) != null) {  
                result += line;  
            }  
        } catch (Exception e) {  
            log.warn("发送 POST 请求出现异常！" + e);  
            e.printStackTrace();  
        }  
        // 使用finally块来关闭输出流、输入流  
        finally {  
            try {  
                if (out != null) {  
                    out.close();  
                }  
                if (in != null) {  
                    in.close();  
                }  
            } catch (IOException ex) {  
                ex.printStackTrace();  
            }  
        }  
        return JSONObject.fromObject(result);  
    }  
    /**  
     * POST请求，Map形式数据  
     * @param url 请求地址  
     * @param param 请求数据  
     * @param charset 编码方式  
     */  
    public static String sendPost(String url, Map<String, String> param,  
            String charset) {  
  
        StringBuffer buffer = new StringBuffer(); 
        buffer.append("<xml>");
        if (param != null && !param.isEmpty()) {  
            for (Map.Entry<String, String> entry : param.entrySet()) {  
            	if(entry.getKey().equals("attach") || entry.getKey().equals("body") || entry.getKey().equals("sign")){
            		buffer.append("<"+entry.getKey()+">");
            		buffer.append("<![CDATA["+entry.getValue()+"]]>");
            		buffer.append("</"+entry.getKey()+">");
            	}else{
            		buffer.append("<"+entry.getKey()+">");
            		buffer.append(entry.getValue());
            		buffer.append("</"+entry.getKey()+">");
            	}
            }  
        }  
        buffer.append("</xml>");
        PrintWriter out = null;  
        BufferedReader in = null;  
        String result = "";  
        try {  
            URL realUrl = new URL(url);  
            // 打开和URL之间的连接  
            URLConnection conn = realUrl.openConnection();  
            // 设置通用的请求属性  
            conn.setRequestProperty("accept", "*/*");  
            conn.setRequestProperty("connection", "Keep-Alive");  
            conn.setRequestProperty("user-agent",  
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");  
            // 发送POST请求必须设置如下两行  
            conn.setDoOutput(true);  
            conn.setDoInput(true);  
            
            // 获取URLConnection对象对应的输出流
            OutputStreamWriter outs = new OutputStreamWriter(  
            		conn.getOutputStream(), "UTF-8");
            // 获取URLConnection对象对应的输出流  
            out = new PrintWriter(outs);  
            // 发送请求参数  
            
            out.print(buffer);  
            // flush输出流的缓冲  
            out.flush();  
            // 定义BufferedReader输入流来读取URL的响应  
            
            in = new BufferedReader(new InputStreamReader(  
                    conn.getInputStream(), charset));  
            String line;  
            while ((line = in.readLine()) != null) {  
                result += line;  
            }  
        } catch (Exception e) {  
            log.warn("发送 POST 请求出现异常！" + e);  
            e.printStackTrace();  
        }  
        // 使用finally块来关闭输出流、输入流  
        finally {  
            try {  
                if (out != null) {  
                    out.close();  
                }  
                if (in != null) {  
                    in.close();  
                }  
            } catch (IOException ex) {  
                ex.printStackTrace();  
            }  
        }  
        return result;  
    }  
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setUseCaches(false);
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Content-Type", "application/json"); 
            conn.setRequestProperty("user-agent",
                    "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2376.0 Safari/537.36");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            OutputStreamWriter outs = new OutputStreamWriter(  
            		conn.getOutputStream(), "UTF-8");
            out = new PrintWriter(outs);
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(),"utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    } 
    
    
	public static JSONObject httpRequest(String requestUrl,String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// /1、解决https请求的问题

			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url
					.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);

			// /2、兼容GET、POST两种方式

			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod)) {
				httpUrlConn.connect();
			}

			// /3、兼容有数据提交、无数据提交两种情况

			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (Exception ce) {
			ce.printStackTrace();
		}
		return jsonObject;
	}

	
	public static void main(String[] args) {
//		JsonObject jsonObject = new JsonObject();
//    	jsonObject.addProperty("sendMark", "JFY");
//    	log.warn(jsonObject.toString());
        //发送 GET 请求
//        String s=HttpRequestTool.sendGet("http://localhost:6144/Home/RequestString", "key=123&v=456");
//        log.warn(s);
        
        //发送 POST 请求
//    	String sr=sendPostUrl("http://115.28.174.174:8098/CloudPlatform/webInterface.action", "parameter=" + jsonObject.toString(), "UTF-8");
//        String sr=sendPostUrl("http://localhost:8080/CloudPlatform/webInterface.action", "parameter=" + jsonObject.toString(), "UTF-8");
//        log.warn(sr);

        Map<String, Object> map=new HashMap<String, Object>();

        map.put("pageSize",10);
        map.put("pageNum",1);

        String result = sendPost("http://h.minddt.com:9250/CallCenter/call/list.do", new Gson().toJson(map));
        
        System.out.println(result);




	}
}