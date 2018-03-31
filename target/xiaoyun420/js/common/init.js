function doResetPassword(role) {
    $.ajax({
        url: "/" + role + "/account/resetPassword",
        type: "POST",
        async: true,
        dataType: "json",
        data: $('#passwordForm').serialize(),
        beforeSubmit: function () {
            return true;
        },
        success: function (data) {
            if (data.flag) {
                $('#passwordModal').modal('hide');
                $('#passwordForm')[0].reset();
                $('#passwordMsgInfo').html('重置成功！');
                $('#modalInfo2').modal('show');
            } else {
                $('#modalInfo2').modal('show');
            }
        }
    });
}

function resetPassword() {
    Common.clearFormData('passwordModal');
    Common.clearFormValidatorMsg('passwordModal');
    Common.showModalMng('passwordModal');
}