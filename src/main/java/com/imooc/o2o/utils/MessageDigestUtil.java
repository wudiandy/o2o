package com.imooc.o2o.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 本类用于封装java.security.MessageDigest，实现方便的加密功能
 *
 * @author 吴笛
 * @date 2020/01/01
 */
public class MessageDigestUtil {
  private static final String[] HEX_DIG_ITS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
  private static final String ALGORITHM_MD5 = "MD5";
  private static final String ALGORITHM_SHA_256 = "SHA-256";

  /**
   * 对字符串进行SHA-265加密
   *
   * @param str 被加密字符串
   * @return 加密后的字符串
   */
  public static String string2Sha256(String str) {
    try {
      return computeDigest(str, ALGORITHM_SHA_256);
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * 对字符串进行MD5加密
   *
   * @param str 被加密字符串
   * @return 加密后的MD5字符串
   */
  public static String string2Md5(String str) {
    try {
      return computeDigest(str, ALGORITHM_MD5);
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * 计算加密摘要
   *
   * @param str       需要加密的字符串
   * @param algorithm 加密算法名
   * @return 加密后字符串
   * @throws NoSuchAlgorithmException 如果加密算法名不对或不支持，会抛出这个Exception
   */
  private static String computeDigest(String str, String algorithm) throws NoSuchAlgorithmException {
    MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
    byte[] resultBytes = messageDigest.digest(str.getBytes());
    return byteArray2HexString(resultBytes);
  }

  /**
   * 把10进制的字节数组转换成16进制的字符串
   *
   * @param bytes 原字节数组
   * @return 16进制的字符串
   */
  private static String byteArray2HexString(byte[] bytes) {
    StringBuilder stringBuilder = new StringBuilder();

    for (byte resultByte : bytes) {
      int tempByte = resultByte;

      if (tempByte < 0) {
        tempByte += 256;
      }

      // 计算高8位角标
      int indexHigh = tempByte / 16;
      // 计算低8位角标
      int indexLow = tempByte % 16;

      String high = HEX_DIG_ITS[indexHigh];
      String low = HEX_DIG_ITS[indexLow];

      stringBuilder.append(high).append(low);
    }

    return stringBuilder.toString();
  }
}
