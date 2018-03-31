package com.xiaoyun.base.excpetion;

import java.util.ResourceBundle;

/**
 * Created by yandq on 16/3/7.
 */
public class ExceptionMessage {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("message.errorMessage");
    public static String getMessage(String code){
        return resourceBundle.getString(code);
    }

}
