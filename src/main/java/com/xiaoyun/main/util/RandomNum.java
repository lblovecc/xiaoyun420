package com.xiaoyun.main.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RandomNum {

	/**
	 * 自动按日期格式生
	 * @return
	 */
	public synchronized static String getAutoDateOrderNum() {
		SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMddHHmmss");
		return df1.format(new Date())+(new Random().nextInt(899999)+100000);
	}
	
	public static String genRandomNum(int pwd_len) {
		// 35是因为数组是从0开始的，26个字母+10个数字
		// final int maxNum = 10;
		int i; // 生成的随机数
		int count = 0; // 生成的密码的长度
		char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
				'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

		// char[] str = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

		StringBuffer pwd = new StringBuffer("");
		Random r = new Random();
		while (count < pwd_len) {
			// 生成随机数，取绝对值，防止生成负数，

			i = Math.abs(r.nextInt(str.length)); // 生成的数最大为36-1

			if (i >= 0 && i < str.length) {
				pwd.append(str[i]);
				count++;
			}
		}
		return pwd.toString();
	}
	public static String genRandomxzNum(int pwd_len) {
		// 35是因为数组是从0开始的，26个字母+10个数字
		// final int maxNum = 10;
		int i; // 生成的随机数
		int count = 0; // 生成的密码的长度
		char[] str = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		// char[] str = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		StringBuffer pwd = new StringBuffer("");
		Random r = new Random();
		while (count < pwd_len) {
			// 生成随机数，取绝对值，防止生成负数，

			i = Math.abs(r.nextInt(str.length)); // 生成的数最大为36-1

			if (i >= 0 && i < str.length) {
				pwd.append(str[i]);
				count++;
			}
		}

		return pwd.toString();
	}
	public static String getWebEditor(String s){
		    StringBuffer stringbuffer = new StringBuffer();
		    int j = s.length();
		    for(int i = 0; i < j; i++){
		      char c = s.charAt(i);
		      switch(c){
		            case 60: stringbuffer.append("&lt;"); break;
		            case 62: stringbuffer.append("&gt;"); break;
		            case 38: stringbuffer.append("&amp;"); break;
		            case 34: stringbuffer.append("&quot;"); break;
		            case 169: stringbuffer.append("&copy;"); break;
		            case 174: stringbuffer.append("&reg;"); break;
		            case 165: stringbuffer.append("&yen;"); break;
		            case 8364: stringbuffer.append("&euro;"); break;
		            case 8482: stringbuffer.append("&#153;"); break;
		            case 13:
		              if(i < j - 1 && s.charAt(i + 1) == 10)
		              {stringbuffer.append("<br>");
		               i++;
		              }
		              break;
		            case 32:
		              if(i < j - 1 && s.charAt(i + 1) == ' ')
		                {
		                  stringbuffer.append(" &nbsp;");
		                  i++;
		                  break;
		                }
		            default:
		                stringbuffer.append(c);
		                break;
		            }
		        }
		    return new String(stringbuffer.toString());
	}
}
