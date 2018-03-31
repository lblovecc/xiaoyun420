package com.xiaoyun.main.controller.base;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.xiaoyun.main.common.EasyUIPaginator;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Mr.LB
 *
 */
public abstract class AbstractBaseController {
    //结果关键字

    protected static final Map<String, Object> baseInfoParamMap = new HashMap<>();


    private static final String DATA = "data";
    private static final String RESULT = "result";
    private static final String RESULT_FLAG = "flag";
    private static final String RESULT_ERRCODE = "errcode";
    private static final String RESULT_ERRMSG = "errmsg";

//    public AbstractBaseController() {
//        baseInfoParamMap.put("version", ConfigUtils.get("version"));
////        baseInfoParamMap.put("roleId", );
//    }
//
//    protected Integer getRequestIntValue(HttpServletRequest request, String paramName) {
//        return StringUtils.isEmpty(paramName) ? null : Integer.parseInt(request.getParameter(paramName));
//
//    }

    protected Map<String, Object> getModelViewMap(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("pageNum", request.getParameter("pageNum"));
        map.put("numPerPage", request.getParameter("numPerPage"));
        map.put("orderField", request.getParameter("orderField"));
        map.put("orderDirection", request.getParameter("orderDirection"));
        return map;
    }

    protected Map<String, Object> initPagingParams(EasyUIPaginator paginator) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        int start = (paginator.getPage() - 1) * paginator.getRows();
        int size = paginator.getRows();
        paramMap.put("pagingStart", start);
        paramMap.put("pagingSize", size);
        return paramMap;
    }

    protected JSONObject queryListToJSONObject(List queryList) {
        JSONObject jsonObject = new JSONObject();
        if (queryList == null || queryList.size() == 0) {
            jsonObject.put("total", 0);
            jsonObject.put("rows", new ArrayList());
        } else {
            Page page = (Page) queryList;
            jsonObject.put("total", page.getTotal());
            jsonObject.put("rows", queryList);
        }
        return jsonObject;
    }

    protected String getAddressDetail(String province, String city, String area, String detail) {
        return new StringBuilder(province).append(city).append(area).append(detail).toString();
    }


    protected JSONObject queryListToJSONObjectWithoutPage(List queryList) {
        JSONObject jsonObject = new JSONObject();
        if (queryList == null || queryList.size() == 0) {
            jsonObject.put("total", 0);
            jsonObject.put("rows", new ArrayList());
        } else {
            jsonObject.put("total", queryList.size());
            jsonObject.put("rows", queryList);
        }
        return jsonObject;
    }

    protected JSONObject queryListToBSJSONObject(List queryList) {
        JSONObject jsonObject = new JSONObject();
        if (queryList == null || queryList.size() == 0) {
            jsonObject.put("total", 0);
            jsonObject.put("rows", new ArrayList());
        } else {
            Page page = (Page) queryList;
            jsonObject.put("total", page.getTotal());
            jsonObject.put("rows", queryList);
        }
        return jsonObject;
    }

    protected JSONObject queryListToBSJSONObjectWithoutPage(List queryList) {
        JSONObject jsonObject = new JSONObject();
        if (queryList == null || queryList.size() == 0) {
            jsonObject.put("total", 0);
            jsonObject.put("rows", new ArrayList());
        } else {
            jsonObject.put("total", queryList.size());
            jsonObject.put("rows", queryList);
        }
        return jsonObject;
    }

    protected JSONObject queryListToAppJSONObject(List queryList) {
        JSONObject jsonObject = new JSONObject();
        if (queryList == null || queryList.size() == 0) {
            jsonObject.put("pages", 0);
            jsonObject.put("rows", new ArrayList());
        } else {
            Page page = (Page) queryList;
            jsonObject.put("pages", page.getPages());
            jsonObject.put("rows", queryList);
        }
        return jsonObject;
    }


    protected JSONObject getErrorJsonResult(String errmsg) {
        JSONObject resultObject = new JSONObject();
        resultObject.put(RESULT_FLAG, false);
        resultObject.put(RESULT_ERRMSG, errmsg);
//        resultObject.put(RESULT_ERRMSG,errmsg);
        return resultObject;
    }


    protected JSONObject getAppErrorJsonResult(String errcode, String errmsg) {
        JSONObject resultObject = new JSONObject();
        resultObject.put(RESULT_ERRCODE, errcode);
        resultObject.put(RESULT_ERRMSG, errmsg);
        return resultObject;
    }

    protected JSONObject getAppJsonResult() {
        JSONObject resultObject = new JSONObject();
        resultObject.put(RESULT_ERRCODE, "0");
//        resultObject.put(DATA,null);
        return resultObject;
    }

    protected JSONObject getAppJsonResult(Object result) {
        JSONObject resultObject = new JSONObject();
        resultObject.put(RESULT_ERRCODE, "0");
        resultObject.put(DATA, result);
        return resultObject;
    }

    protected JSONObject getJsonResult(Object result) {
        JSONObject resultObject = new JSONObject();
        resultObject.put(RESULT_FLAG, true);
        resultObject.put(RESULT, result);
        return resultObject;
    }

    protected JSONObject getJsonResult() {
        JSONObject resultObject = new JSONObject();
        resultObject.put(RESULT_FLAG, true);
        return resultObject;
    }

    protected void updateBaseInfo(Object obj, HttpServletRequest request) {

    }

    protected BigDecimal getPercentWith2Bit(BigDecimal num, BigDecimal totalNum) {
        if (num == null || totalNum == null || totalNum.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }
        return num.multiply(new BigDecimal(100)).divide(totalNum, 2, BigDecimal.ROUND_HALF_UP);

    }
}
