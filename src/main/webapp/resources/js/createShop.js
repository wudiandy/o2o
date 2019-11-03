"use strict";

$(function () {
   init();
});

function init() {
    $.ajax({
        url: "../shop/init/create/shop",
        dataType: "json",
        success: function (data) {
            // 添加商铺区域选项
            $.each(data.areaList, function (index, obj) {
                $("#area").append("<option>" + obj.areaName + "</option>");
            });

            // 添加商铺分类选项
            $.each(data.shopKindList, function (index, obj) {
                $("#shopKind").append("<option>" + obj.name + "</option>");
            })
        },
        error: function (textStatus) {
            alert(textStatus);
        }
    });
}