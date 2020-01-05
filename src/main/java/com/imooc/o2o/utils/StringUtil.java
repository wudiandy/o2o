package com.imooc.o2o.utils;

/**
 * @author 吴笛
 */
public class StringUtil {
  public static String getTimeBasedRandomString() {
    String timeStampStr = String.valueOf(System.currentTimeMillis());
    return MessageDigestUtil.string2Md5(timeStampStr);
  }
}
