package com.xiaoyun.main.util;

import org.slf4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static java.lang.System.out;
import static org.slf4j.LoggerFactory.getLogger;

public class ConfigUtils {
    private static final Logger logger = getLogger(ConfigUtils.class);
    private static Properties props = new Properties();

    public static String get(String key) {
        return props.getProperty(key);
    }

    public static void setProps(Properties p) {
        props = p;
    }

    public static void main(String[] args) {
        out.println("value:" + props.get("sss"));
    }


    public static void loadConfig() {
        try {
            logger.info("加载properties配置文件start...");
            props.load(Thread.currentThread().getContextClassLoader()
//                    .getResourceAsStream("classpath*:META-INF/config/wechat.properties"));
                    .getResourceAsStream("config/system.properties"));
            logger.info("加载properties配置文件end...");
        } catch (FileNotFoundException e) {
            logger.error("缺少配置文件，错误信息：{}", e.getMessage());
        } catch (IOException e) {
            logger.error("IO读写出错，错误信息：{}", e.getMessage());
        }
    }
}
