package com.xiaoyun.main.util;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/8/28.
 */
public class Constans {
    public static final String PAY_ENCRY_PASS_KEY = "YTLytlGetToken2017YF2B0821";//加密解密的key
    public static final String MODEL_ID = "82000001";//售电系统必须判断模块id是否
    public static final String YINJIAN_VERSION = "YTL02V01";//硬件版本号，与模块返回的相同 不同则报错
    public static final String DESIGNATOR = "LK";//命令符
    public static final String KEY_REGISTER_NO = "01";//
    public static final String PARENT_REGISTER_NUMBER = "96";//新秘钥加密父秘钥寄存器号
    public static final String KEY_VALUE = "8AB0E22A9C4F31AF";//新秘钥值
    public static final String KEY_CHECK_DIGITS = "E1C2";//密码校验位
    public static final String DATA_SENT = "20150608";//
    public static final String KEY_REVISION_NUMBER = "1";//
    public static final String KEY_EXPIRY_NUMBER = "255";//
    public static final String SUPPLY_GROUP_CODE = "000019";//82000019
    public static final String SUPPLY_GROUP_NAME = "HNLY";//
    public static final String CRC = "BDF8";//
    public static final int readTime = 300;//接收数据返回消息超时的时间
    public static final String OnOffUrl = "http://120.27.239.81:29000/callback/yongtailong/api/v1";
    private static Constans instance;

    private Constans() {
    }

    ;
    private static ReentrantLock lock = new ReentrantLock();

    public static Constans getInstance() {
        lock.lock();
        try {
            if (instance == null) {//懒汉式
                //创建实例之前可能会有一些准备性的耗时工作
//              tokenMap =new HashMap<>();
//              stringSocketHashMap = Collections.synchronizedMap(new HashMap<>());
//              socketInstrucmentStatusHashMap = Collections.synchronizedMap(new HashMap<>());
//              dogStringHashMap = Collections.synchronizedMap(new HashMap<>());
//              socketPayInstrucmentStatusHashMap = Collections.synchronizedMap(new HashMap<>());

                instance = new Constans();
            }
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            lock.unlock();
        }
        return instance;
    }

}
