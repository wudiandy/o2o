package com.imooc.o2o.service;

import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopKind;

import java.util.List;

/**
 * @author wudi
 */
public interface ShopService {
  /**
   * 创建一个商铺
   *
   * @param shop 商店对象
   * @return 操作影响的行数
   */
  int createShop(Shop shop);

  /**
   * 取得商铺类型列表
   *
   * @return 商铺类型列表
   */
  List<ShopKind> getShopKindList();
}
