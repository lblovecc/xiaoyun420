var Money = {};

Money.commafyFenOnly = function (fenAmount) {
    fenAmount = fenAmount == null ? 0 : fenAmount;
    return Money.commafy((fenAmount / 100).toFixed(2));
};

Money.commafyFen = function (fenAmount) {
    fenAmount = fenAmount == null ? 0 : fenAmount;
    return '¥' + Money.commafy((fenAmount / 100).toFixed(2));
};

/**
 * 金额数字格式化，添加千分位
 * @param num
 * @returns {string|*}
 */
Money.commafy = function (num) {
    if (num == null || num == '' || num === 0) {
        return '0';
    }
    //1.先去除空格,判断是否空值和非数
    num = num + "";
    num = num.replace(/[ ]/g, ""); //去除空格
    if (num == "") {
        return;
    }
    if (isNaN(num)) {
        return;
    }
    //2.针对是否有小数点，分情况处理
    var index = num.indexOf(".");
    if (index == -1) {//无小数点
        var reg = /(-?\d+)(\d{3})/;
        while (reg.test(num)) {
            num = num.replace(reg, "$1,$2");
        }
    } else {
        var intPart = num.substring(0, index);
        var pointPart = num.substring(index + 1, num.length);
        var reg = /(-?\d+)(\d{3})/;
        while (reg.test(intPart)) {
            intPart = intPart.replace(reg, "$1,$2");
        }
        num = intPart + "." + pointPart;
    }
    return num;
};

/**
 * 金额数字去除千分位
 * @param num
 * @returns {string|*}
 */
Money.deCommafy = function (num) {
    if (num == null || num == '') {
        return '';
    }
    num = num.replace(/[ ]/g, "");//去除空格
    num = num.replace(/,/gi, '');
    return num;
};

Money.numberCommafy = function (_this) {
    var val = Money.deCommafy($(_this).val());
    $(_this).val(Money.commafy(val));
};

Money.numberDecommafy = function (_this) {
    $(_this).val(Money.deCommafy($(_this).val()));
};

/**
 * 金额转大写
 *
 * @param amount
 * @param amount_zh_show
 */
Money.money2Zh = function (amount, amount_zh_show) {
    var strOutput = "";
    var strUnit = '仟佰拾亿仟佰拾万仟佰拾元角分';
    amount = unComma($('#' + amount).val());
    if (amount == '') {
        $("#" + amount_zh_show).html("");
        $("#" + amount_zh_show).addClass("hidden");
        return;
    }
    $("#" + amount_zh_show).removeClass("hidden");
    amount += "00";
    var intPos = amount.indexOf('.');
    if (intPos >= 0)
        amount = amount.substring(0, intPos) + amount.substr(intPos + 1, 2);
    strUnit = strUnit.substr(strUnit.length - amount.length);
    for (var i = 0; i < amount.length; i++)
        strOutput += '零壹贰叁肆伍陆柒捌玖'.substr(amount.substr(i, 1), 1) + strUnit.substr(i, 1);
    $("#" + amount_zh_show).html(strOutput.replace(/零角零分$/, '整').replace(/零[仟佰拾角]/g, '零').replace(/零{2,}/g, '零').replace(/零([亿|万])/g, '$1').replace(/零+元/, '元').replace(/亿零{0,3}万/, '亿').replace(/^元/, "零元"));
};