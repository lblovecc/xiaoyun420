package com.xiaoyun.main.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UploadUtils {

    private static final Logger logger = LoggerFactory.getLogger(UploadUtils.class);

    public static void uploadOriginalAndThumbImage2(HttpServletRequest request) throws FileUploadException {

    }

    /**
     * 上传图片，在服务器并相应生成：1）新图和2）缩略图，3）生成图片原图，
     *
     * @param fileItemList
     * @param newImagePicWidth
     * @param thumbailsPicWidth
     * @throws FileUploadException
     */
    public static List<String> uploadAdvertisementImage(List<FileItem> fileItemList, int newImagePicWidth, int thumbailsPicWidth) throws Exception {

        List<String> filePathList = new ArrayList<>();
        try {
            for (FileItem fileItem : fileItemList) {
                String generatedImagePathAndNameStr = uploadImg(fileItem, newImagePicWidth, thumbailsPicWidth);
                filePathList.add(generatedImagePathAndNameStr);
            }
        } catch (Exception e) {
            return null;
        }
        return filePathList;
    }

    public static String uploadImg(FileItem fileItem, int newImagePicWidth, int thumbailsPicWidth) throws Exception {
//随机生成图片路径和文件名称（不保护扩展名），如：/02/12/021243456
        String fileName = fileItem.getName();
        String generatedImagePathAndNameStr = generateImagePathAndName(fileName);

        //1）生成新图
        String newImageFilePathAndName = getFullNewImageFilePathAndName(generatedImagePathAndNameStr);
        logger.info("image:{}", newImageFilePathAndName);

        uploadFileItem(fileItem, newImageFilePathAndName, newImagePicWidth);

        //2）生成缩略图
        String thumbFilePathAndName = getFullThumbFilePathAndName(generatedImagePathAndNameStr);
        logger.info("thumb:{}", thumbFilePathAndName);
        uploadFileItem(fileItem, thumbFilePathAndName, thumbailsPicWidth);

        //3）上传原图。会删除服务器上的临时文件，所以放到最后一步。原图用800的尺寸来保存
        String origFilePathAndName = getOriginalFilePathAndName(generatedImagePathAndNameStr);
        logger.info("original:{}", origFilePathAndName);
        saveFileItem(fileItem, origFilePathAndName);
        return generatedImagePathAndNameStr;
    }



    public static String uploadOriginalImg(FileItem fileItem) throws Exception {
        String fileName = fileItem.getName();
        String generatedImagePathAndNameStr = generateImagePathAndName(fileName);
        String origFilePathAndName = getOriginalFilePathAndName(generatedImagePathAndNameStr);
        logger.info("original:{}", origFilePathAndName);
        saveFileItem(fileItem, origFilePathAndName);
        return generatedImagePathAndNameStr;
    }

    /**
     * 随机生成两层目录和文件名
     *
     * @return
     */
    public static String generateImagePathAndName(String fileName) {
        String fileExtension = getFileExtension(fileName).toLowerCase();
        String fileStorageName = Long.toHexString(System.nanoTime());
        int nameLength = fileStorageName.length();
        if (nameLength < 6) {
            fileStorageName = fileStorageName + Long.toHexString(System.nanoTime());
            nameLength = fileStorageName.length();
        }
        String firstFolder = fileStorageName.substring(nameLength - 6, nameLength - 4);
        String secondFolder = fileStorageName.substring(nameLength - 4, nameLength - 2);
        String thirdFolder = fileStorageName.substring(nameLength - 2, nameLength);
//        String twoFolders = "/" + firstFolder + "/" + secondFolder;

        StringBuilder folders = new StringBuilder(File.separator)
                .append(firstFolder)
                .append(File.separator)
                .append(secondFolder)
                .append(File.separator)
                .append(thirdFolder);

        String imageFullPath = new StringBuilder(ConfigUtils.get("save_path"))
                .append(ConfigUtils.get("image_path_head"))
                .append(folders)
                .toString();

        String originalFullPath = new StringBuilder(ConfigUtils.get("save_path"))
                .append(ConfigUtils.get("original_path_head"))
                .append(folders)
                .toString();

        String thumbnailsFullPath = new StringBuilder(ConfigUtils.get("save_path"))
                .append(ConfigUtils.get("thumbnails_path_head"))
                .append(folders)
                .toString();

        createFolder(imageFullPath);
        createFolder(thumbnailsFullPath);
        createFolder(originalFullPath);

        return folders.append(File.separator).append(fileStorageName)
                .append(Constants.SYMBOL_DOT)
                .append(fileExtension)
                .toString();

    }

    /**
     * 根据文件扩展名生成存储目录
     *
     * @param fileName
     * @return 带路径的文件名
     */
    public static String generateFileStoragePathAndName(String fileName) {

        String fileStorageName = Long.toHexString(System.nanoTime());
        String fileExtension = getFileExtension(fileName);
        int nameLength = fileStorageName.length();
        if (nameLength < 6) {
            fileStorageName += Long.toHexString(System.nanoTime());
            nameLength = fileStorageName.length();
        }
        String firstFolder = fileStorageName.substring(nameLength - 6, nameLength - 4);
//        String secondFolder = fileStorageName.substring(nameLength - 4, nameLength - 2);
//        String thirdFolder = fileStorageName.substring(nameLength - 2, nameLength);

        StringBuilder folders = new StringBuilder()
                .append(File.separator)
                .append(firstFolder);
//                .append(File.separator)
//                .append(thirdFolder);
//        String realPath = ConfigUtils.get("save_path") + folders.toString();
        String realPath = PathUtils.getSaveImgPath(folders.toString());
        createFolder(realPath);

        return folders.append(File.separator).append(fileStorageName)
                .append(Constants.SYMBOL_DOT)
                .append(fileExtension)
                .toString();
    }

    /**
     * 生成目录
     *
     * @param fileFullPath
     */
    private static void createFolder(String fileFullPath) {
        String[] splitedFolder = fileFullPath.split(File.separator);
        StringBuilder path = new StringBuilder();
        for (int i = 0; i < splitedFolder.length; i++) {
            if (i > 0) {
                path.append(File.separator);
            }
            path.append(splitedFolder[i]);
            File filePath = new File(path.toString());
            if (!filePath.exists())
                filePath.mkdir();
        }
    }


    /**
     * 获取文件扩展名
     *
     * @param fileName：文件名称
     * @return 文件扩展名
     */
    public static String getFileExtension(String fileName) {
        return StringUtils.substringAfterLast(fileName, ".");
    }


    private static String getOriginalFilePathAndName(String originalFileName) {
        return new StringBuilder(ConfigUtils.get("save_path"))
                .append(ConfigUtils.get("original_path_head"))
//                .append(System.currentTimeMillis())
//                .append(new Random().nextInt(10000))
                .append(originalFileName)
                .toString();

    }

    private static String getFullNewImageFilePathAndName(String newImagePath) {
        return new StringBuilder(ConfigUtils.get("save_path"))
                .append(ConfigUtils.get("image_path_head"))
                .append(newImagePath)
                .toString();
    }

    private static String getFullThumbFilePathAndName(String thumbImagePath) {
        return new StringBuilder(ConfigUtils.get("save_path"))
                .append(ConfigUtils.get("thumbnails_path_head"))
                .append(thumbImagePath)
                .toString();
    }

    public static void saveFileItem(FileItem fileItem, String filePath) throws Exception {
        File uploadedFile = new File(filePath);
        fileItem.write(uploadedFile);
    }

    /**
     * 传入原图名称，，获得一个以时间格式的新名称
     *
     * @param fileName 原图名称
     * @return
     */
    @SuppressWarnings("unused")
	private String generateFileName(String fileName) {
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String formatDate = format.format(new Date());
//        int random = new Random().nextInt(10000);
        int position = fileName.lastIndexOf(".");
        String extension = fileName.substring(position);
//        return formatDate + random + extension;
        return formatDate + extension;
    }

    /**
     * 按照图片宽高比，计算压缩后尺寸<br>
     * 例如，限制600，(700,800)->(525,600);(700,500)->(600,428);(400,500)->(400,500)
     *
     * @param width
     * @param height
     * @param limit  限制大小
     * @return int[width, height]
     */
    private static int[] getScale(int width, int height, int limit) {
        int[] size = new int[2];
        size[0] = width;
        size[1] = height;
        double scale = (double) width / (double) height;

        if (width >= height) {
            if (width > limit) {
                int tempH = (int) (limit / scale);

                size[0] = limit;
                size[1] = tempH;
            }
        } else {
            if (height > limit) {
                int tempW = (int) (limit * scale);

                size[0] = tempW;
                size[1] = limit;
            }
        }
        return size;
    }

    public static List<FileItem> parseFileItemListFromRequest(HttpServletRequest request) throws FileUploadException {
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding(Constants.ENCODING_UTF_8);
        List<FileItem> tmpFileItemList = upload.parseRequest(request);
        List<FileItem> fileItemList = new ArrayList<>();
        for (FileItem tmpFileItem : tmpFileItemList) {
            if (!tmpFileItem.isFormField()) {
                fileItemList.add(tmpFileItem);
            }
        }
        return fileItemList;
    }

    public static void uploadFileItem(FileItem fileItem, String imagePathAndName, int dimension) throws IOException {
        String imagePath = StringUtils.substringBeforeLast(imagePathAndName, File.separator);
        String imageName = StringUtils.substringAfterLast(imagePathAndName, File.separator);
        uploadFileItem(fileItem, imagePath, imageName, dimension);
    }

    /**
     * @param imagePath
     * @param fileItem
     * @param dimension
     * @param imageName
     * @return
     * @throws IOException
     */
    public static void uploadFileItem(FileItem fileItem, String imagePath, String imageName, int dimension) throws IOException {

        BufferedImage srcBufferImage = ImageIO.read(fileItem.getInputStream());
        logger.info("");
        BufferedImage scaledImage;
        ScaleImage scaleImage = ScaleImage.getInstance();

        int yw = srcBufferImage.getWidth();
        int yh = srcBufferImage.getHeight();

        String lastUploadName = imageName.substring(imageName.indexOf(".") + 1, imageName.length());
        int[] toScale = getScale(yw, yh, dimension);
        scaledImage = scaleImage.imageZoomOut(srcBufferImage, toScale[0], toScale[1]);
        File directory = new File("/home/img/");
        if (!directory.exists()) {
            directory.mkdirs();
        }
        String path = imagePath + "/" + imageName;
        logger.info("path:{}", path);
        try {
            FileOutputStream out = new FileOutputStream(path);
            ImageIO.write(scaledImage, lastUploadName, out);
            if (out != null) {
                out.close();
            }
            if (srcBufferImage != null) {
                srcBufferImage.flush();
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw e;
        }

    }

}
