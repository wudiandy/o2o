/**
 * 点击注册码图片后更换注册码
 */
function changeVerificationCode(img) {
    // 在次向服务器请求验证码
    img.src = "../kaptcha?" + Math.floor(Math.random() * 100);
}

let commonUtil = {
    /**
     * 从请求URL中根据参数名取出对应参数值
     *
     * @param name
     */
    "getParameter": function (name) {
        let reg = new RegExp(name + "=*");
        let matched = window.location.search.substr(1).match(reg);
        if (matched != null) {
            return matched.input.split("=")[1];
        }
        return "";
    }
};