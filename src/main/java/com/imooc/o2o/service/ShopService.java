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

  /**
   * 根据商铺ID获取商铺对象
   *
   * @param id 商铺ID
   * @return 商铺对象
   */
  Shop getShopInformationById(int id);

  /**
   * 通过店主ID取得店铺列表
   * @param id  店主ID
   * @return    店铺列表
   */
  List<Shop> getShopListByOwnerId(Long id);
}
