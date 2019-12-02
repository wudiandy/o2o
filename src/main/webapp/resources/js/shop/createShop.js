"use strict";

$(function () {
    // 页面初始化
    init();

    // 绑定注册按钮点击事件
    $("#submit").on("click", function () {
        const formData = new FormData();
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
        // 取得用户输入的验证码
        const verificationCode = $("#inputCode").val();
        if (!verificationCode) {
            // 如果验证是空的
            // 提示用用户输入验证码
            alert("请输入验证码");
            return;
        }
        formData.append("verificationCode", verificationCode);

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
                    alert(data.message);
                    // TODO 接下来如何跳转
                } else {
                    alert(data.message);
                }

                // 更换验证码
                $("#verificationCode").click();
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