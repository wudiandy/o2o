package com.imooc.o2o.service;

import com.imooc.o2o.entity.Shop;

public interface ShopService {
  /**
   * 创建一个商铺
   *
   * @param shop 商店对象
   * @return 操作影响的行数
   */
  int createShop(Shop shop);
}
