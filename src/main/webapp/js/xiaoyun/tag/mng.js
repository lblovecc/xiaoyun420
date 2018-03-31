var supplierId = null;
var uploader = null;
var goodsSaveUploader = null;
var goodsUpdateUploader = null;
$(function () {
    //qryBeginPrice/
    $("#qryBeginPrice").inputmask({
        "mask": "9",
        "repeat": 11,
        "greedy": false
    });
    $("#qryEndPrice").inputmask({
        "mask": "9",
        "repeat": 11,
        "greedy": false
    });

    $('#li-goods').addClass("active open");
    $('#li-goods-mng').addClass("active open");
    initGoodsUploader();

    $('#modalMng').on('shown.bs.modal', function () {
        initUploader();
    });

    tableInit();
    //Common.loadSelect2DataFromServer("/adminselect/account/role",'roleId','请选择员工职位');
    Common.initSelectFromUrl('qryCategoryId', '/supplierselect/goods/category', true);
    Common.initSelectFromUrl('categoryId', '/supplierselect/goods/category', false);

    $('#modalMng').on('hide.bs.modal', function () {
        uploader.option('destroy');
    });

    $("#mobile").inputmask({
        "mask": "9",
        "repeat": 11,
        "greedy": false
    });

    $('#btnQry').click(function () {
        loadData();
    });

    $('#btnExp').click(function () {
        Common.openPage("/supplierjson/goods/export?" + Common.parseUrlParamsFromObj(getQryParams()));
    });

    $('#btnAdd').click(function () {
        add();
    });

    $('#btnEdit').click(function () {
        edit();
    });

    $('#btnDel').click(function () {
        del();
    });

    $('#btnSave').click(function () {
        save();
    });

    $('#btnConfirm').click(function () {
        confirmSave();
    });


});

function initGoodsUploader() {
    goodsSaveUploader = WebUploader.create({
        // 选完文件后，是否自动上传。
        auto: true,
        // swf文件路径
        //swf:  'http://cdn.staticfile.org/webuploader/0.1.0/Uploader.swf',
        swf: '/js/plugins/webuploader/Uploader.swf',
        // 文件接收服务端。
        server: '/supplierjson/goods/upload/new',
        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: '#btnImpSave',
        duplicate: true, //支持重复上传
        // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
        accept: {
            title: 'Images',
            extensions: 'xls',
            mimeTypes: 'application/xls'
        }
    });
    goodsSaveUploader.on('uploadAccept', function (file, response) {
        if (response.flag) {
            $('#table').bootstrapTable('refresh');
            Common.showModalSuccess(response.result);
        } else {
            Common.showModalError(response.errmsg);
        }
    });

    goodsUpdateUploader = WebUploader.create({
        // 选完文件后，是否自动上传。
        auto: true,
        // swf文件路径
        //swf:  'http://cdn.staticfile.org/webuploader/0.1.0/Uploader.swf',
        swf: '/js/plugins/webuploader/Uploader.swf',
        // 文件接收服务端。
        server: '/supplierjson/goods/upload/update',
        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: '#btnImpUpdate',
        duplicate: true, //支持重复上传
        // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
        accept: {
            title: 'Images',
            extensions: 'xls',
            mimeTypes: 'application/xls'
        }
    });
    goodsUpdateUploader.on('uploadAccept', function (file, response) {
        if (response.flag) {
            $('#table').bootstrapTable('refresh');
            Common.showModalSuccess(response.result);

        } else {
            Common.showModalError(response.errmsg);
        }
    });

}


function initUploader() {

    uploader = WebUploader.create({
        // 选完文件后，是否自动上传。
        auto: true,
        // swf文件路径
        //swf:  'http://cdn.staticfile.org/webuploader/0.1.0/Uploader.swf',
        swf: '/js/plugins/webuploader/Uploader.swf',
        // 文件接收服务端。
        server: '/commonjson/goods/picture/upload',
        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: '#picker',
        duplicate: true, //支持重复上传
        // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
        accept: {
            title: 'Images',
            extensions: 'gif,jpg,jpeg,bmp,png',
            mimeTypes: 'image/*'
        }
    });
    uploader.on('uploadAccept', function (file, response) {
        if (response.statusCode == '200') {
            //$('#uploadResult').html('文件上传成功！');
            $('#picture').val(response.filename);
            $('#pictureName').val(response.filenameShow);

            $('#pictureStatusTxt').text('上传成功!');
            return true;
        } else {
            $('#pictureStatusTxt').text('上传失败!');
            $('#pictureName').val('');
            $('#picture').val('');
        }
    });
    // 当有文件被添加进队列的时候
    uploader.on('fileQueued', function (file) {
        Common.clearFormValidatorMsg('mngForm');
        var $list = $('#thelist');
        $list.append('<div id="' + file.id + '" class="item">' +
            '</div>');
    });
    uploader.on('uploadProgress', function (file, percentage) {
        $('#pictureShow').val(file.name);
        Common.clearFormValidatorMsg('mngForm');
        var $li = $('#' + file.id),
            $percent = $li.find('.progress .progress-bar');

        // 避免重复创建
        if (!$percent.length) {
            $percent = $('<div class="progress progress-striped active">' +
                '<div class="progress-bar" role="progressbar" style="width: 0%">' +
                '</div>' +
                '</div>').appendTo($li).find('.progress-bar');
        }

        $('#pictureStatusTxt').text('上传中...');
        $percent.css('width', percentage * 100 + '%');
    });


    uploader.on('uploadComplete', function (file) {
        $('#' + file.id).find('.progress').fadeOut();
    });

}

function changeTableStyle() {
    $('td.bs-checkbox label').removeClass('mt-radio').css('margin-bottom:-20px');
}


function loadData() {
    $('#table').bootstrapTable('refresh', {query: getQryParams()});
}

function getQryParams() {
    var beginPrice = $("#qryBeginPrice").val();
    if (beginPrice != null) {
        beginPrice = (100 * beginPrice).toFixed(0);
    } else {
        beginPrice = 0;
    }
    var endPrice = $("#qryEndPrice").val();
    if (endPrice != null) {
        endPrice = (100 * endPrice).toFixed(0);
    } else {
        endPrice = 0;
    }

    var params = {
        "goodsName": $("#qryGoodsName").val(),
        "categoryId": $("#qryCategoryId").val(),
        "beginPrice": beginPrice,
        "endPrice": endPrice,
        "status": $("#qryStatus").val()
    };
    console.info(params);
    return params;
}

function confirmSave() {
    $('#modalConfirm').modal('hide');
    var action = $('#action').val();
    var priceShow = $('#priceShow').val();
    var value = (100 * priceShow).toFixed(0);
    $('#price').val(value);

    $.ajax({
        url: "/supplierjson/goods/" + action,
        type: "POST",
        async: false,
        dataType: "json",
        data: $('#mngForm').serialize(),
        beforeSubmit: function () {
            return true;
        },
        success: function (data) {
            if (data.flag) {
                $('#modalMng').modal('hide');
                $('#table').bootstrapTable('refresh');
                var msg = '新增成功！';
                if (action == 'update') {
                    msg = '更新成功！';
                } else if (action == 'del') {
                    msg = '删除成功！';
                }
                $('#mngForm')[0].reset();
                Common.showModalSuccess(msg);
            } else {
                Common.showModalError(data.errmsg);
            }

        },
        error: function (data) {
            Common.showModalError(data.errmsg);
        }
    });
}

function save() {
    $('#mngForm').trigger("validate");
    var instance = $('#mngForm').validator().data("validator");
    if (!instance.isFormValid()) {
        return;
    }

    var contentMsg = $('#action').val() == 'add' ? '确认要新增吗？' : '确认要修改吗？';
    $('#modalConfirmContent').html(contentMsg);
    Common.showModalConfirm();
}

function add() {
    $('#pictureStatusTxt').text('');
    //Common.clearFormValidatorMsg('mngForm');
    //Common.clearFormData('mngForm');
    $('#action').val('add');
    Common.showModalMng('modalMng');
}

function edit() {
    $('#pictureStatusTxt').text('');
    var rows = $('#table').bootstrapTable('getSelections');
    if (rows == null || rows.length == 0) {
        Common.showModalWarn("请选择一条记录进行操作！");
        return null;
    }
    var record = rows[0];
    $('#action').val('update');
    $('#goodsId').val(record.goodsId);
    $("#goodsBrand").val(record.goodsBrand);
    $('#goodsName').val(record.goodsName);
    $('#categoryId').val(record.categoryId);
    $('#unit').val(record.unit);
    $('#priceShow').val((record.price / 100).toFixed(2));
    $('#price').val(record.price);
    $('#goodsDesc').val(record.goodsDesc);
    $('#picture').val(record.picture);
    $('#pictureName').val(record.pictureName);
    $('#status').val(record.status);
    $('#mngForm').validator("cleanUp");//instance.cleanUp()
    Common.showModalMng('modalMng');
}

function del() {
    var rows = $('#table').bootstrapTable('getSelections');
    if (rows == null || rows.length == 0) {
        Common.showModalWarn("请选择一条记录进行操作！");
        return null;
    }
    var userId = rows[0].userId;
    $('#action').val('del');
    $('#modalConfirmContent').html('确认要删除吗？');
    Common.showModalConfirm();
}


function tableInit() {
    $('#table').bootstrapTable({
        url: '/supplierjson/goods/list',
        idField: 'userId',
        singleSelect: true,
        queryParams: function (params) {
            return $.extend(params, getQryParams());

        },//提交ajax时候的附加参数
        columns: [
            [
                {
                    radio: true
                },
                {
                    field: 'goodsName',
                    title: '商品名称',
                    halign: 'center',
                    valign: 'middle',
                    align: 'center'
                },
                {
                    field: 'goodsBrand',
                    title: '商品品牌',
                    halign: 'center',
                    valign: 'middle',
                    align: 'center'
                },
                {
                    field: 'unit',
                    title: '商品规格(单位)',
                    halign: 'center',
                    valign: 'middle',
                    align: 'center'
                 },
                {
                    field: 'price',
                    title: '商品价格(元)',
                    align: 'center',
                    halign: 'center',
                    valign: 'middle',
                    formatter: function (value, row, index) {
                        return Money.commafyFen(value);
                    }
                },
                {
                    field: 'goodsDesc',
                    title: '商品描述',
                    halign: 'center',
                    valign: 'middle',
                    align: 'center'
                },
                {
                    field: 'thubmnail',
                    title: '商品图片',
                    align: 'center',
                    formatter: function (value, row, index) {
                        if(row.picture == null || row.picture == ''){
                            return '';
                        }

                        var directory = Common.thumbnailDirectory + row.picture;
                        return Common.getFieldFormatterImg(directory, 100, 100);
                    }
                },
                {
                    field: 'categoryName',
                    title: '类型',
                    halign: 'center',
                    valign: 'middle',
                    align: 'center'
                },
                {
                    field: 'createTime',
                    title: '创建时间',
                    align: 'center',
                    halign: 'center',
                    valign: 'middle',
                    formatter: function (value, row, index) {
                        return Common.changeMsToTime(value);
                    }
                },
                {
                    field: 'status',
                    title: '商品状态',
                    align: 'center',
                    halign: 'center',
                    valign: 'middle',
                    formatter: function (value, row, index) {
                        return value == 1 ? '在售' : '下架';
                    }
                }
            ]
        ]
    });
}

