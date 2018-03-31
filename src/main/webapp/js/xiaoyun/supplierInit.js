var orderNumber = 0;
var refreshCount = 0;
$(function () {
    /*setTimeout(function () {
        queryOrder();
    }, 1000 * 1);*/

    $('#btnPasswordReset').click(function () {
        $('#passwordForm').trigger("validate");
        var instance = $('#passwordForm').validator().data("validator");
        if (!instance.isFormValid()) {
            return;
        }
        Common.showModalConfirm('modalConfirmPassword');
    });

    $('#btnPasswordConfirm').click(function () {
        $('#modalConfirmPassword').modal('hide');
        doResetPassword('supplierjson');
    });

    $("#orderVoice").audio5js({
        url: "/js/plugins/audio/order.mp3"
    });
});

function queryOrder() {
    $.ajax({
        url: "/supplierjson/order/quartz",
        type: "POST",
        async: false,
        dataType: "json",
        //contentType: "application/json",
        data: {},
        success: function (data) {
            if (data.total > orderNumber && refreshCount > 0) {//新打开页面不提示
                $('#orderVoice').audio5js('play');
            }
            refreshCount++;
            orderNumber = data.total;
            $('#new_order_num').html(data.total);
            $('#new_order_num_show').html('您有' + data.total + '个新订单');
            $('#new_order_list').html(getOrderListHtml(data.rows));

            setTimeout(function () {
                queryOrder();
            //}, 1000 * 60 * 5);
            }, 1000 * 5);
            //}, 1000 * 6);

        }
    });
}


function getOrderListHtml(rows) {
    var html = '';
    for (var each in rows) {
        var tmp = '<li><a href="javascript:;"><span class="time" style="max-width: 130px">' + Common.changeMsToTime(rows[each].orderDate) + '</span><span class="details">门店：' + rows[each].shopName + '</span></a></li>';
        html += tmp;
    }
    return html;
}



