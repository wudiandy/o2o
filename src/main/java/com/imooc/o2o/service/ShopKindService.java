package com.imooc.o2o.service;

import com.imooc.o2o.entity.ShopKind;

import java.util.List;

/**
 *
 * @author wudi
 */
public interface ShopKindService {
  /**
   * 取得商铺类型列表
   *
   * @return 商铺类型列表
   */
  List<ShopKind> getShopKindList();
}
