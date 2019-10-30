"use strict";
$(function () {
   init();
});

function init() {
    $.ajax({
        url: "/shop/init/create/shop",
        dataType: "json",
        success: function (data) {
            console.log(data);
        },
        error: function (jqXHR, textStatus) {
            alert(textStatus);
        }
    });
    // 添加商铺分类
}