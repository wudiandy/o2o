package com.imooc.o2o.service.impl;

import com.imooc.o2o.dao.ShopDao;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShopServiceImpl implements ShopService {
  private ShopDao shopDao;

  @Autowired
  public ShopServiceImpl(ShopDao shopDao) {
    this.shopDao = shopDao;
  }

  /**
   * 创建一个商铺
   *
   * @param shop 商店对象
   */
  @Override
  @Transactional
  public int createShop(Shop shop) {
    return shopDao.insert(shop);
  }
}
