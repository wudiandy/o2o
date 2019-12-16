const $shopName = $("#shopName");
const $shopKind = $("#shopKind");

const id = getParameter("id");

$(function main() {
    // 店铺名不能更改
    $shopName.attr("disabled", "disabled");
    // 店铺类型不能更改
    $shopKind.attr("disabled", "disabled");

    showShopInfo();
});

/**
 * 从服务器端获取店铺信息并且赋值给表单项
 */
function showShopInfo() {
    let responseData = {};
    responseData.shopInfo = {};
    responseData.shopInfo.shopName = "";
    $.ajax({
        url: "/shop/getShopInfoById",
        data: id,
        method: "post",
        dataType: "json",
        success: function (data) {
            responseData = data;
            $shopName.val(data.shopInfo.shopName);
            // todo 给表单项赋值
        }
    })
}