$(function () {
    $("#username").focus();
    $("#username").keydown(function (event) {
        if (event.which == "13") {//回车键,移动光标到密码框
            $("#password").focus();
        }
    });
    $("#password").keydown(function (event) {
        if (event.which == "13") {//回车键,移动光标到验证码
            $("#authCode").focus();
        }
    });
    $("#authCode").keydown(function (event) {
        if (event.which == "13") {//回车键，提交表单
            $("#btnSubmit").click();
        }
    });
});

function login(_this) {
    $("#loginErrorMessage").addClass("hidden");
    var username = $("#username").val();
    var password = $("#password").val();
    var authCode = $("#authCode").val();
    if (username == "") {
        showErrorMsg("用户名不能为空");
        return;
    }
    if (password == "") {
        showErrorMsg("密码不能为空");
        return;
    }
    if(authCode == ""){
        showErrorMsg("验证码不能为空");
        return;
    }
    var param = {"userName": username, "password": password,"authCode":authCode};
    $.ajax({
        url: '/doLogin',
        type: 'POST',
        dataType: 'json',
        data: param,
        beforeSend: function () {
            $(_this).button('loading');
        },
        success: function (data) {
            $(_this).button('reset');
            if (data.flag) {
                if (data.roleId.substr(0,1)=='1') {
                    window.location.href = "/admin/report/todayOverview";
                }else if(data.roleId.substr(0,1)=='2'){
                    window.location.href = "/supplier/report/shopOrder/top10";
                }
            } else {
                refresh();
                $("#loginErrorMessage").removeClass("hidden").find("span").html(data.errmsg);
            }
        },
        error: function (a) {
            $(_this).button('reset');
            $("#loginErrorMessage").removeClass("hidden").find("span").html("登录失败，请重试！");
        }
    });
}

function showErrorMsg(msg) {
    $("#loginErrorMessage").removeClass("hidden").find("span").html(msg);
}

function loginOut() {
    $.ajax({
        url: '/ife/logout.html',
        type: 'POST',
        dataType: 'json',
        data: {},
        success: function (data) {
            window.location.href = "/adminview/login";
        }
    });
}

function refresh() {
    var version = Math.ceil(Math.random() * 100000) + 100000;
    $("#authCodeRandom").attr({src: "/pub/ImageServlet?versions=" + version});
    $("#authCodeRandom").prevAll('input').each(function () {
        $(this).val("");
    });
}

