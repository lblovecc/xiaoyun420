package com.xiaoyun.main.util;

import java.io.FileInputStream;
import java.net.URLDecoder;
import java.util.Properties;

/**
 * ClassName: InitSystem
 * @Description: 读取系统配置
 * @author 周献峰
 * @date 2015-11-25
 */
public class InitSystem {

	
	/**
	 * @Description: 获取系统配置
	 * @param key
	 * @return String
	 */
	public static String getProperties(String key) {
		Properties prop = new Properties();
		try {
			String path = InitSystem.class.getResource("/").getPath();
			path = URLDecoder.decode(path, "utf-8");
			path = path.substring(1, path.indexOf("classes"));
			String coder = System.getProperty("file.separator");
			prop.load(new FileInputStream(coder + path + coder + "classes" + coder + "config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop.getProperty(key).trim();
	}
}