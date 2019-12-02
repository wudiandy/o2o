package com.imooc.o2o.utils;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wudi
 */
public class VerificationCodeUtil {
  /**
   * 检查用户输入的验证码与组件生成的验证是否相同
   *
   * @param request http请求
   * @return true：验证码相同，false：验证码不同
   */
  public static boolean checkVerificationCodeUtil(HttpServletRequest request) {
    // 验证码组件产生的验证码
    String expectedCode = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
    // 用户实际输入的验证码
    String actualCode = request.getParameter("verificationCode");
    // 如果用户输入的验证码不为空，并且输入的验证与组件产生的验证码相同，则返回true，否则返回false
    return actualCode != null && actualCode.equals(expectedCode);
  }
}
