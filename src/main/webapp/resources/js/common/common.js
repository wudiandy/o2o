/**
 * 点击注册码图片后更换注册码
 */
function changeVerificationCode(img) {
    // 在次向服务器请求验证码
    img.src = "../kaptcha?" + Math.floor(Math.random() * 100);
}

/**
 * 从请求URL中根据参数名取出对应参数值
 *
 * @param name
 */
function getParameter(name) {
    // TODO 从请求URL中根据参数名取出对应参数值
}