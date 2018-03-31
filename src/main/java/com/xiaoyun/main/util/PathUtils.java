package com.xiaoyun.main.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class PathUtils {

    private static final Logger logger = LoggerFactory.getLogger(PathUtils.class);

    /**
     * 获取当前文件路径
     *
     * @return
     */
    public static String getWebClassesPath() {
        String path = PathUtils.class.getProtectionDomain().getCodeSource()
                .getLocation().getPath();
        return path.substring(1);
    }

    /**
     * 获取当前工程的web-inf路径
     *
     * @return
     */
    public static String getWebInfPath() {
        String path = getWebClassesPath();
        path = path.substring(0, path.indexOf("WEB-INF") + 8);
        return path;
    }

    /**
     * 获取当前工程路径
     *
     * @return
     */
    public static String getWebRoot() {
        String path = getWebClassesPath();
        path = path.substring(0, path.indexOf("WEB-INF/classes"));
        return path;
    }

    /**
     * 获取配置WebInfo/classes下的配置文件
     *
     * @param fileName 配置文件名称
     * @return
     */
    public static String getWebInfoClassesFile(String fileName) {
        String path = "/" + getWebInfPath() + "classes/" + fileName;
        return path;
    }

    public static String getHttpImgPath(String directory) {
        return new StringBuilder(ConfigUtils.get("http_image_path"))
                .append(ConfigUtils.get("image_path_head"))
                .append(directory).toString();
    }

    public static String getHttpOriginalPath(String directory) {
        return new StringBuilder(ConfigUtils.get("http_image_path"))
                .append(ConfigUtils.get("original_path_head"))
                .append(directory).toString();
    }

    public static String getHttpThumnailsPath(String directory) {
        return new StringBuilder(ConfigUtils.get("http_image_path"))
                .append(ConfigUtils.get("thumbnails_path_head"))
                .append(directory).toString();
    }

    public static String getSaveImgPath(String directory) {
        return new StringBuilder(ConfigUtils.get("save_path"))
                .append(ConfigUtils.get("image_path_head"))
                .append(directory).toString();
    }

    public static String getSaveOriginalPath(String directory) {
        return new StringBuilder(ConfigUtils.get("save_path"))
                .append(ConfigUtils.get("original_path_head"))
                .append(directory).toString();
    }

    public static String getSaveThumnailsPath(String directory) {
        return new StringBuilder(ConfigUtils.get("save_path"))
                .append(ConfigUtils.get("thumbnails_path_head"))
                .append(directory).toString();
    }


    public static void main(String[] args) throws IllegalAccessException {
        logger.info(PathUtils.getWebClassesPath());
        logger.info(PathUtils.getWebInfPath());
        logger.info(PathUtils.getWebRoot());
    }
}
