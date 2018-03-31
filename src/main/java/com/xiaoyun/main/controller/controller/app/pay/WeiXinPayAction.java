package com.xiaoyun.main.controller.controller.app.pay;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xiaoyun.main.controller.base.AbstractBaseController;
import com.xiaoyun.main.util.IpUtils;
import com.xiaoyun.main.util.PayUtil;

/**
 * 微信支付
 * 
 * @author Mr.LB
 *
 */
@Controller
@RequestMapping(value = "/xiaochengxu")
public class WeiXinPayAction extends AbstractBaseController {

    /** 
     * @Description: 发起微信支付 
     * @param request 
     */
	@RequestMapping(value = "/weixin_pay")
    public JSONObject wxPay(String openid, HttpServletRequest request){  
        try{  
            //生成的随机字符串  
            String nonce_str = UUID.randomUUID().toString(); 
            
            //商品名称  
            String body = "测试商品名称";  
            
            //获取客户端的ip地址  
            String spbill_create_ip = IpUtils.getIpAddr(request);  
              
            //组装参数，用户生成统一下单接口的签名  
            Map<String, String> packageParams = new HashMap<String, String>();  
            packageParams.put("appid", WxPayConfig.appid);  
            packageParams.put("mch_id", WxPayConfig.mch_id);  
            packageParams.put("nonce_str", nonce_str);  
            packageParams.put("body", body);  
            packageParams.put("out_trade_no", "123456789");//商户订单号  
            packageParams.put("total_fee", "1");//支付金额，这边需要转成字符串类型，否则后面的签名会失败  
            packageParams.put("spbill_create_ip", spbill_create_ip);  
            packageParams.put("notify_url", WxPayConfig.notify_url);//支付成功后的回调地址  
            packageParams.put("trade_type", WxPayConfig.TRADETYPE);//支付方式  
            packageParams.put("openid", openid);  
                 
                String prestr = PayUtil.createLinkString(packageParams); // 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串   
              
                //MD5运算生成签名，这里是第一次签名，用于调用统一下单接口  
                String mysign = PayUtil.sign(prestr, WxPayConfig.key, "utf-8").toUpperCase();  
              
            //拼接统一下单接口使用的xml数据，要将上一步生成的签名一起拼接进去  
            String xml = "<xml>" + "<appid>" + WxPayConfig.appid + "</appid>"   
                    + "<body><![CDATA[" + body + "]]></body>"   
                    + "<mch_id>" + WxPayConfig.mch_id + "</mch_id>"   
                    + "<nonce_str>" + nonce_str + "</nonce_str>"   
                    + "<notify_url>" + WxPayConfig.notify_url + "</notify_url>"   
//                    + "<openid>" + order.getOpenId() + "</openid>"   				//TODO  获取openid
//                    + "<out_trade_no>" + order.getOrderNo() + "</out_trade_no>"   	//TODO	获取订单号
                    + "<spbill_create_ip>" + spbill_create_ip + "</spbill_create_ip>"   
//                    + "<total_fee>" + order.getPayMoney() + "</total_fee>"  		//TODO	获取支付金额
                    + "<trade_type>" + WxPayConfig.TRADETYPE + "</trade_type>"   
                    + "<sign>" + mysign + "</sign>"  
                    + "</xml>";  
              
            System.out.println("调试模式_统一下单接口 请求XML数据：" + xml);  
  
            //调用统一下单接口，并接受返回的结果  
            String result = PayUtil.httpRequest(WxPayConfig.pay_url, "POST", xml);  
              
            System.out.println("调试模式_统一下单接口 返回XML数据：" + result);  
              
            // 将解析结果存储在HashMap中     
            Map<String,String> map = PayUtil.doXMLParse(result);  
              
            String return_code = (String) map.get("return_code");//返回状态码  
              
            JSONObject response = new JSONObject();//返回给小程序端需要的参数  
            if(return_code=="SUCCESS"||return_code.equals(return_code)){     
                String prepay_id = (String) map.get("prepay_id");//返回的预付单信息     
                response.put("nonceStr", nonce_str);  
                response.put("package", "prepay_id=" + prepay_id);  
                Long timeStamp = System.currentTimeMillis() / 1000;     
                response.put("timeStamp", timeStamp + "");//这边要将返回的时间戳转化成字符串，不然小程序端调用wx.requestPayment方法会报签名错误  
                //拼接签名需要的参数  
                String stringSignTemp = "appId=" + WxPayConfig.appid + "&nonceStr=" + nonce_str + "&package=prepay_id=" + prepay_id+ "&signType=MD5&timeStamp=" + timeStamp;     
                //再次签名，这个签名用于小程序端调用wx.requesetPayment方法  
                String paySign = PayUtil.sign(stringSignTemp, WxPayConfig.key, "utf-8").toUpperCase();  
                  
                response.put("paySign", paySign);  
            }  
              
            response.put("appid", WxPayConfig.appid);  
              
            return response;  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
        return null;  
    }  
	
	/** 
     * @Description:微信支付     
     * @return 
     * @throws Exception  
     */  
    @RequestMapping(value="/weixin_notify")  
    @ResponseBody  
    public void wxNotify(HttpServletRequest request,HttpServletResponse response) throws Exception{  
        BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream)request.getInputStream()));  
        String line = null;  
        StringBuilder sb = new StringBuilder();  
        while((line = br.readLine()) != null){  
            sb.append(line);  
        }  
        //sb为微信返回的xml  
        String notityXml = sb.toString();  
        String resXml = "";  
        System.out.println("接收到的报文：" + notityXml);  
      
        Map<String,String> map = PayUtil.doXMLParse(notityXml);  
          
        String returnCode = (String) map.get("return_code");  
        if("SUCCESS".equals(returnCode)){  
            //验证签名是否正确  
            if(PayUtil.verify(PayUtil.createLinkString(map), (String)map.get("sign"), WxPayConfig.key, "utf-8")){  
                /**此处添加自己的业务逻辑代码start**/  
                  
                  
                /**此处添加自己的业务逻辑代码end**/  
                //通知微信服务器已经支付成功  
                resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"  
                + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";  
            }  
        }else{  
            resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"  
            + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";  
        }  
        System.out.println(resXml);  
        System.out.println("微信支付回调数据结束");  
  
  
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());  
        out.write(resXml.getBytes());  
        out.flush();  
        out.close();  
    }
}
