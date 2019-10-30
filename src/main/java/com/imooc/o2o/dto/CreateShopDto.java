package com.imooc.o2o.dto;

import java.util.Map;

/**
 * @author wudi
 */
public interface CreateShopDto {
  /**
   * 取得注册商铺页面需要的信息
   *
   * @return 注册商铺页面需要的信息。
   */
  Map<String, Object> getCreateShopInfo();
}
