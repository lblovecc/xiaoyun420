var Common = {};


Common.ak = 'ZXVXEc1ROftZeAZzw1OCTaqGPa3EmDZY';
Common.service_id = '123836';

//Common.pictureDirectory = "http://localhost:8080/img/goods/images";
//Common.thumbnailDirectory = "http://localhost:8080/img/goods/thumbnails";
Common.originalDirectory = "http://120.25.63.127/img/goods/original";
Common.pictureDirectory = "http://120.25.63.127/img/goods/images";
Common.thumbnailDirectory = "http://120.25.63.127/img/goods/thumbnails";

/**
 * 页面跳转
 * @param page
 */
Common.gotoPage = function (page) {
    window.location.href = page;
};

/**
 * 页面跳转
 * @param page
 */
Common.openPage = function (page) {
    window.open(page);
};

Common.showTitles = {
    "": "",
    "": ""
};

Common.getUserName = function () {
    var param = {};
    var userName = '';
    $.ajax({
        url: "/commonjson/user/info",
        type: "POST",
        async: false,
        dataType: "json",
        data: param,
        success: function (data) {
            if (data.flag) {
                userName = data.user.userName;
            } else {
                return null;
            }
        }
    });
    return userName;
};

Common.getUrlParam = function (name) {
    var url = location.search; //获取url中"?"符后的字串
    var theRequest = {};
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for (var i = 0; i < strs.length; i++) {
            theRequest[strs[i].split("=")[0]] = (strs[i].split("=")[1]);
        }
    }
    if (theRequest[name] == null) {
        return null;
    } else {
        return decodeURIComponent(theRequest[name]);
    }
};

Common.parseUrlParamsFromObj = function (obj) {
    var paramArr = [];
    for (var name in obj) {
        paramArr.push(name + "=" + obj[name]);
    }
    return paramArr.join('&');
};
//easyui start...

Common.reloadTable = function (tableId) {
    var id = tableId != null ? tableId : "data-table";
    $("#" + id).datagrid('reload');
};

Common.getFieldFormatterUrlParam2 = function (funcName, title, param1, param2) {
    return '<a style="text-decoration:none; color: blue" href="javascript:' + funcName + '(\'' + param1 + '\',' + '\'' + param2 + '\')" >' + title + '</a>';

};

Common.clearFormValidatorMsg = function (formDomId) {
    var domId = formDomId == null ? 'mngForm' : formDomId;
    $('#' + domId).validator("cleanUp");
};

Common.clearFormData = function (formDomId) {
    var domId = formDomId == null ? 'mngForm' : formDomId;
    $('#' + domId).find('input').not('[type=hidden]').val('').removeAttr('checked')
        .removeAttr('selected');
    $('#' + domId).find('textarea').val('');
    $('#' + domId).find('select').val('');
    //$('#' + domId).find('checkbox').val('');

};

//metronic start...
/**
 * select2下拉框组件从服务器获取数据，并进行初始化
 * @param url
 * @param select2DomId
 * @param placeholder
 */
Common.loadSelect2DataFromServer = function (url, select2DomId, placeholder) {
    $.ajax({
        url: url,
        type: "POST",
        async: false,
        dataType: "json",
        //contentType: "application/json",
        data: {},
        success: function (data) {
            console.info(data);
            $('#' + select2DomId).select2({
                placeholder: placeholder,
                allowClear: true,
                data: data,
                language: "zh-CN"
            });

        }

    });

};

Common.showModalInfo = function (msg) {
    $('#modalInfoMsg').html(msg);
    $('#modalInfoMsg').removeClass('alert-info alert-warning alert-warning alert-warning alert-danger');
    $('#modalInfoMsg').addClass('alert-info');
    $('#modalInfo').modal('show');
};

Common.showModalWarn = function (msg) {
    $('#modalInfoMsg').html(msg);
    $('#modalInfoMsg').removeClass('alert-info alert-warning alert-warning alert-warning alert-danger');
    $('#modalInfoMsg').addClass('alert-warning');
    $('#modalInfo').modal('show');
};

Common.showModalError = function (msg) {
    $('#modalInfoMsg').html(msg);
    $('#modalInfoMsg').removeClass('alert-info alert-warning alert-warning alert-warning alert-danger');
    $('#modalInfoMsg').addClass('alert-danger');
    $('#modalInfo').modal('show');
};

Common.showModalSuccess = function (msg) {
    $('#modalInfoMsg').html(msg);
    $('#modalInfoMsg').removeClass('alert-info alert-warning alert-warning alert-success alert-danger');
    $('#modalInfoMsg').addClass('alert-success');
    $('#modalInfo').modal('show');
};

Common.showModalConfirm = function (modalConfirmDomId) {
    var domId = modalConfirmDomId == null ? 'modalConfirm' : modalConfirmDomId;
    $('#' + domId).modal({backdrop: 'static', keyboard: false, show: false});
    $('#' + domId).modal('show');
};

Common.showModalMng = function (modalMngDomId) {
    var domId = modalMngDomId == null ? 'modalMng' : modalMngDomId;
    $('#' + domId).modal({backdrop: 'static', keyboard: false, show: false});
    $('#' + domId).modal('show');
};

//metronic end...

Common.hideHighchartsLink = function () {
    $('text[text-anchor="end"]').hide();
};
/**
 *
 * @param func：函数名称
 * @param title：操作链接显示文字
 * @param param：函数参数
 * @returns {string}
 */
Common.getFieldFormatterUrl = function (func, title, param) {
    return '<a href="#" style="text-decoration:none; color:blue" onclick="javascript:' + func + '(' + param + ')">' + title + '<' + '/a>';
};

Common.getFieldFormatterImg = function (directory, width, height) {
    //所有图片使用图片管理系统进行维护
    //return '<img src="' + Common.serverImgPath + directory + '"' + ' width="' + width + '" height="' + height + '">';
    return '<img src="' + directory + '"' + ' width="' + width + '" height="' + height + '">';
};

Common.getMsg = function () {
    $.messager.alert('提示', '操作成功');
};

Common.getErrmsg = function (errmsg) {
    $.messager.alert('提示', '更新失败，错误原因：' + errmsg);
};

Common.getSysErrmsg = function () {
    $.messager.alert('提示', '更新失败，错误原因：网络异常');
};


Common.formantDatetime = function (date, isFull) {
    var pattern = "";
    if (isFull == true || isFull == undefined) {
        pattern = "yyyy-MM-dd hh:mm:ss";
    } else {
        pattern = "yyyy-MM-dd";
    }
    return Common.getFormatDate(date, pattern);
};

Common.changeMsToTime = function (ms) {
    var format = function (time, format) {
        var t = new Date(time);
        var tf = function (i) {
            return (i < 10 ? '0' : '') + i
        };
        return format.replace(/yyyy|MM|dd|HH|mm|ss/g, function (a) {
            switch (a) {
                case 'yyyy':
                    return tf(t.getFullYear());
                    break;
                case 'MM':
                    return tf(t.getMonth() + 1);
                    break;
                case 'mm':
                    return tf(t.getMinutes());
                    break;
                case 'dd':
                    return tf(t.getDate());
                    break;
                case 'HH':
                    return tf(t.getHours());
                    break;
                case 'ss':
                    return tf(t.getSeconds());
                    break;
            }
        })
    };
    if (ms == null) {
        return "-";
    }
    var nDate = format(new Date(ms).getTime(), 'yyyy-MM-dd HH:mm:ss');
    return nDate;
};

Common.changeMsToDate = function (ms) {
    if (ms == null) {
        return '-';
    }
    var format = function (time, format) {
        var t = new Date(time);
        var tf = function (i) {
            return (i < 10 ? '0' : '') + i
        };
        return format.replace(/yyyy|MM|dd|HH|mm|ss/g, function (a) {
            switch (a) {
                case 'yyyy':
                    return tf(t.getFullYear());
                    break;
                case 'MM':
                    return tf(t.getMonth() + 1);
                    break;
                case 'mm':
                    return tf(t.getMinutes());
                    break;
                case 'dd':
                    return tf(t.getDate());
                    break;
                case 'HH':
                    return tf(t.getHours());
                    break;
                case 'ss':
                    return tf(t.getSeconds());
                    break;
            }
        })
    };
    var nDate = format(new Date(ms).getTime(), 'yyyy-MM-dd');
    return nDate;
};

Common.getFormatDate = function (date, format) {
    if (date == null) {
        return null;
    }
    var o = {
        "M+": date.getMonth() + 1,
        "d+": date.getDate(),
        "h+": date.getHours(),
        "m+": date.getMinutes(),
        "s+": date.getSeconds(),
        "q+": Math.floor((date.getMonth() + 3) / 3),
        "S": date.getMilliseconds()
    };
    if (/(y+)/.test(format)) {
        format = format.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
        }
    }
    return format;
};

Common.getBlanks = function (num) {
    var txt = '';
    for (var i = 0; i < num; i++) {
        txt += "&nbsp;";
    }
    return txt;
};

Common.isEmpty = function (value) {
    return value == null || value == '';
};

Common.elementValueIsEmpty = function (domId) {
    return Common.isEmpty($('#' + domId).val());
};

Common.initProvinceCityArea = function () {
    var html = "<option value=''>==请选择==</option>";
    $("#city").append(html);
    $("#area").append(html);
    $.each(pdata, function (idx, item) {
        if (parseInt(item.level) == 0) {
            html += "<option value='" + item.names + "' exid='" + item.code + "'>" + item.names + "</option>";
        }
    });
    $("#province").append(html);

    $("#province").change(function () {
        if ($(this).val() == "") return;
        $("#city option").remove();
        $("#area option").remove();
        var code = $(this).find("option:selected").attr("exid");
        code = code.substring(0, 2);
        var html = "<option value=''>==请选择==</option>";
        $("#area").append(html);
        $.each(pdata, function (idx, item) {
            if (parseInt(item.level) == 1 && code == item.code.substring(0, 2)) {
                html += "<option value='" + item.names + "' exid='" + item.code + "'>" + item.names + "</option>";
            }
        });
        $("#city").append(html);
    });

    $("#city").change(function () {
        if ($(this).val() == "") return;
        $("#area option").remove();
        var code = $(this).find("option:selected").attr("exid");
        code = code.substring(0, 4);
        var html = "<option value=''>==请选择==</option>";
        $.each(pdata, function (idx, item) {
            if (parseInt(item.level) == 2 && code == item.code.substring(0, 4)) {
                html += "<option value='" + item.names + "' exid='" + item.code + "'>" + item.names + "</option>";
            }
        });
        $("#area").append(html);
    });
    //绑定
    //$("#province").val("广东省");
    //$("#province").change();
    //$("#city").val("深圳市");
    //$("#city").change();
    //$("#area").val("罗湖区");


};

Common.getMenuShowTitle = function (menu) {
    return Common.showTitles.menu;
};
/**
 * 列表删除后调用回调函数重新加载列表数据
 * @param tableId
 */
Common.tableReload = function (formId) {
    formId == null ? $('#channelListForm').submit() : $('#' + formId).submit();
};

/**
 * easyui table reload
 * @param tableId
 */
Common.gridReload = function (tableId) {
    tableId == null ? $("#data-table").datagrid('reload') : $("#" + tableId).datagrid('reload');
};

Common.pagerFormSubmit = function () {
    $('#pagerForm').submit();
};

Common.updateSuccCallback = function (data, formId) {
    if (data.flag) {
        alertMsg.correct(data.result);
        $.pdialog.closeCurrent();//$.pdialog.close(dlgId);
        //navTab.reloadFlag('channelMng');//重新加载navTab（index.html中定义的菜单a链接的rel属性值）。
        var tmpFormId = formId == null ? "pagerForm" : formId;
        $('#' + tmpFormId).submit();
    } else {
        alertMsg.info(data.errmsg);
    }
};

Common.isRowSelected = function (tableDomId) {
    var domId = tableDomId == null ? 'table' : tableDomId;
    var rows = $('#' + domId).bootstrapTable('getSelections');
    if (rows == null || rows.length == 0) {
        Common.showModalWarn("请选择一条记录进行操作！");
        return false;
    } else {
        return true;
    }
};

Common.initSelectFromDict = function (selectDomId, dictId, showAll) {
    $.ajax({
        url: "/common/dict/dictSelectOption",
        type: 'POST',
        dataType: "json",
        //contentType: "application/json",
        data: {'dictId': dictId},
        success: function (data) {
            if (data.flag) {
                if (showAll) {
                    $('#' + selectDomId).append("<option value=''>全部</option>" + data.optionStr);
                } else {
                    $('#' + selectDomId).append(data.optionStr);
                }
            }
        }
    });
};

Common.initSelectFromUrl = function (selectDomId, url, showAll) {
    $.ajax({
        url: url,
        type: 'POST',
        dataType: "json",
        //contentType: "application/json",
        data: {},
        success: function (data) {
            if (showAll) {
                $('#' + selectDomId).append("<option>全部</option>" + data.optionStr);
            } else {
                $('#' + selectDomId).append(data.optionStr);
            }
        }
    });
};


Common.checkAmount = function (obj) {
    if (/^-\d+\.?\d{0,2}$/.test(obj.value)) {
        obj.value = obj.value;
    } else {
        obj.value = obj.value.substring(0, obj.value.length - 1);
    }
};

Common.fenToYuan = function (amount) {
    return amount == null ? 0 : (amount / 100).toFixed(2);
};

Common.yuanToFen = function (amount) {
    return amount == null ? 0 : (amount * 100).toFixed(0);
};

Common.printContent = function (contentId) {//id-str 打印区域的id
    var el = document.getElementById(contentId);
    var iframe = document.createElement('IFRAME');
    var doc = null;
    //iframe.setAttribute('style', 'position:absolute;width:0px;height:0px;left:-500px;top:-500px;');
    document.body.appendChild(iframe);
    doc = iframe.contentWindow.document;
    // 引入打印的专有CSS样式，根据实际修改
    doc.write("<LINK rel=\"stylesheet\" type=\"text/css\" href=\"/metronic/global/plugins/bootstrap-table/bootstrap-table.min.css\">");
    doc.write("<LINK rel=\"stylesheet\" type=\"text/css\" href=\"/css/bootstrap.min.css\">");
    doc.write('<div>' + el.innerHTML + '</div>');
    doc.close();
    iframe.contentWindow.focus();
    iframe.contentWindow.print();
    if (navigator.userAgent.indexOf("MSIE") > 0) {
        document.body.removeChild(iframe);
    }
};