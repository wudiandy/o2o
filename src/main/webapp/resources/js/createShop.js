"use strict";

$(function () {
    // 页面初始化
    init();

    // 绑定注册按钮点击事件
    $("#submit").click(function () {
        var formData = new FormData();
        // 取得商铺名称
        formData.append("shopName", $("#shopName").val());
        // 取得商铺分类ID
        formData.append("shopKindId", $("#shopKind").val());
        // 取得区域ID
        formData.append("areaId", $("#area").val());
        // 取得详细地址
        formData.append("address", $("#address").val());
        // 取得联系电话
        formData.append("phone", $("#phone").val());
        // 取得店铺图片
        formData.append("shopImg", $("#img")[0].files[0]);
        // 取得店铺简介
        formData.append("desc", $("#description").val());

        // 调用新增商铺接口
        $.ajax({
            url: "../shop/registerShop",
            method: "POST",
            contentType: false,
            processData: false,
            data: formData,
            dataType: "json",
            success: function (data) {
                if (data.result === "success") {
                    // TODO 显示一个店铺添加成功的提示
                    // TODO 接下来如何跳转
                } else {
                    // TODO 显示一个店铺添加失败的提示
                }
            },
            error: function (jqXHR) {
                console.error(jqXHR.statusText);
            }
        });
    });
});

function init() {
    $.ajax({
        url: "../shop/init/create/shop",
        dataType: "json",
        success: function (data) {
            // 添加商铺区域选项
            $.each(data.areaList, function (index, obj) {
                $("#area").append("<option value='" + obj.areaId + "'>" + obj.areaName + "</option>");
            });

            // 添加商铺分类选项
            $.each(data.shopKindList, function (index, obj) {
                $("#shopKind").append("<option value='" + obj.shopKindId + "'>" + obj.name + "</option>");
            })
        },
        error: function (jqXHR) {
            console.error(jqXHR.statusText);
        }
    });
}