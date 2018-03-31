package com.xiaoyun.main.controller.controller.app.login;

import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaoyun.main.controller.base.AbstractBaseController;
import com.xiaoyun.main.model.User;
import com.xiaoyun.main.service.app.AppUserService;
import com.xiaoyun.main.util.UrlUtil;

import jcifs.util.Base64;

/**
 * 
 * @author Mr.LB 
 * 
 * 程序登陆获取微信商户的基本信息
 *
 */

@Controller
@RequestMapping({"/xiaochengxu"})
public class WeiXinLoginAction extends AbstractBaseController{
	
	private static Logger log = Logger.getLogger(WeiXinLoginAction.class);

	private static final String APPID = "wx1f3974237719b7b5";

	private static final String SECRET = "9253bc06db40c2673860358940ce673b";

	@Autowired
	private AppUserService userService;
	
	
	/**
	 * 授权验证,获取微信小程序 session_key 和   openid
	 * 
	 * @author Mr.LB
	 * 
	 * @param code 调用微信登陆返回的code
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping({"/weixin_user_authorization"})
	public JSONObject weixinUserAuthorization(HttpServletRequest request, HttpServletResponse response){
		// 微信端登录code值
		String wxCode = request.getParameter("code");

		String requestUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=" + APPID 
				+ "&secret=" + SECRET + "&js_code=" + wxCode + "&grant_type=authorization_code";
		Map<String, String> requestUrlParam = new HashMap<String, String>();
		requestUrlParam.put("appid", APPID); 						// 开发者设置中的appId
		requestUrlParam.put("secret", SECRET); 						// 开发者设置中的appSecret
		requestUrlParam.put("js_code", wxCode); 					// 小程序调用wx.login返回的code
		requestUrlParam.put("grant_type", "authorization_code"); 	// 默认参数
		
		/**
		 *  openid	 用户唯一标识
		 *	session_key	会话密钥
		 *	unionid	用户在开放平台的唯一标识符(unionid 只在满足一定条件的情况下返回)
		 *  https://mp.weixin.qq.com/debug/wxadoc/dev/api/uinionID.html		(unionid说明)
		 *
		 */
		JSONObject jsonObject = JSON.parseObject(UrlUtil.sendPost(requestUrl, requestUrlParam));
		
		String openid = jsonObject.getString("openid");
//		String session_key = jsonObject.getString("session_key");
		String unionid = jsonObject.getString("unionid");
		
		User user = new User();
		user.setOpenid(openid);
		User selectUser = userService.selectOne(user);
		
		//如果数据库没有该商户,就将该商户保存起来,如果存在该商户,就更新该商户信息
		if(null == selectUser){
			user.setStatus("1");;		// 1:启用    0:禁用
			user.setUnionid(unionid);
			userService.saveUserInfo(user);
		}else{
			selectUser.setUnionid(unionid);
			selectUser.setUpdatetime(new Date());
			userService.updateNotNull(selectUser);
		}
		
		return jsonObject;
	}
	
	/**
	 * 解密用户敏感数据获取用户信息
	 * 
	 * @author Mr.LB
	 * 
	 * @param sessionKey 数据进行加密签名的密钥
	 * 
	 * @param encryptedData 包括敏感数据在内的完整用户信息的加密数据
	 * 
	 * @param iv 加密算法的初始向量
	 * 
	 *  encryptedData 解密后为以下 json 结构:
	 * {
		    "openId": "OPENID",
		    "nickName": "NICKNAME",
		    "gender": GENDER,
		    "city": "CITY",
		    "province": "PROVINCE",
		    "country": "COUNTRY",
		    "avatarUrl": "AVATARURL",
		    "unionId": "UNIONID",
		    "watermark":
		    {
		        "appid":"APPID",
		    "timestamp":TIMESTAMP
		    }
		}
	 */
	@ResponseBody
	@RequestMapping({"/get_weixin_user_info"})
	public JSONObject getUserInfo(String encryptedData, String sessionKey, String iv) {
		
		// 被加密的数据
		byte[] dataByte = Base64.decode(encryptedData);
		// 加密秘钥
		byte[] keyByte = Base64.decode(sessionKey);
		// 偏移量
		byte[] ivByte = Base64.decode(iv);
		
		try {
			// 如果密钥不足16位，那么就补足. 这个if 中的内容很重要
			int base = 16;
			if (keyByte.length % base != 0) {
				int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
				byte[] temp = new byte[groups * base];
				Arrays.fill(temp, (byte) 0);
				System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
				keyByte = temp;
			}
			
			// 初始化
			Security.addProvider(new BouncyCastleProvider());
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
			SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
			AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
			parameters.init(new IvParameterSpec(ivByte));
			cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
			
			byte[] resultByte = cipher.doFinal(dataByte);
			if (null != resultByte && resultByte.length > 0) {
				String result = new String(resultByte, "UTF-8");
				JSONObject jsonObject2 = JSON.parseObject(result);
				
				String openid = jsonObject2.getString("openId");
				String unionid = jsonObject2.getString("unionId");
				String gender = jsonObject2.getString("gender");
				String city = jsonObject2.getString("city");
				String province = jsonObject2.getString("province");
				String country = jsonObject2.getString("country");
				String avatarUrl = jsonObject2.getString("avatarUrl");
				
				User user = new User();
				user.setOpenid(openid);
				User selectUser = userService.selectOne(user);
				
				user.setUnionid(unionid);
				user.setOpenid(openid);
				user.setSex(gender.equals("男")?"1":"0");
				user.setCity(city);
				user.setProvince(province);
				user.setCountry(country);
				user.setHeadimgurl(avatarUrl);
				user.setStatus("1");			// 1:启用    0:禁用
				
				//如果数据库没有该用户,就将该用户保存起来,如果存在该用户,就更新该用户信息
				if(null == selectUser){
					userService.saveUserInfo(user);
				}else{
					selectUser.setUpdatetime(new Date());
					userService.updateNotNull(selectUser);
				}
				
				return getAppJsonResult();
			}
			
		} catch (NoSuchAlgorithmException e) {
			log.error(e.getMessage(), e);
		} catch (NoSuchPaddingException e) {
			log.error(e.getMessage(), e);
		} catch (InvalidParameterSpecException e) {
			log.error(e.getMessage(), e);
		} catch (IllegalBlockSizeException e) {
			log.error(e.getMessage(), e);
		} catch (BadPaddingException e) {
			log.error(e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage(), e);
		} catch (InvalidKeyException e) {
			log.error(e.getMessage(), e);
		} catch (InvalidAlgorithmParameterException e) {
			log.error(e.getMessage(), e);
		} catch (NoSuchProviderException e) {
			log.error(e.getMessage(), e);
		}
		
		return getAppErrorJsonResult("1", "获取用户信息出现错误");
	}
}
