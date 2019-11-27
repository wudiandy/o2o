package com.imooc.o2o.utils;

import org.apache.commons.codec.digest.Md5Crypt;

/**
 * @author wudi
 */
public class StringUtil {
  public static String getTimeBasedRandomString() {
    String timeStampStr = String.valueOf(System.currentTimeMillis());
    return Md5Crypt.md5Crypt(timeStampStr.getBytes());
  }
}
