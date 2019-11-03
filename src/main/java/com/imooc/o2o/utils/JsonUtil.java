package com.imooc.o2o.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.o2o.entity.Shop;

import java.io.IOException;

/**
 * @author wudi
 */
public class JsonUtil {
  private static ObjectMapper objectMapper = new ObjectMapper();

  /**
   * 把json字符串转换称Shop对象
   *
   * @param jsonStr json对象
   * @return Shop对象的引用
   * @throws IOException json字符串不能转换成Shop对象
   */
  public static Shop json2Shop(String jsonStr) throws IOException {
    return objectMapper.readValue(jsonStr, Shop.class);
  }
}
