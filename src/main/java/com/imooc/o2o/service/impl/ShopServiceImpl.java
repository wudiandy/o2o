package com.imooc.o2o.service.impl;

import com.imooc.o2o.dao.ShopDao;
import com.imooc.o2o.dao.ShopKindDao;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopKind;
import com.imooc.o2o.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wudi
 */
@Service
public class ShopServiceImpl implements ShopService {
  private ShopDao shopDao;
  private ShopKindDao shopKindDao;

  @Autowired
  public ShopServiceImpl(ShopDao shopDao, ShopKindDao shopKindDao) {
    this.shopDao = shopDao;
    this.shopKindDao = shopKindDao;
  }

  /**
   * 创建一个商铺
   *
   * @param shop 商店对象
   */
  @Override
  @Transactional
  public int createShop(Shop shop) {
    // TODO 检查店铺是否已经创建过了

    return shopDao.insert(shop);
  }

  /**
   * 取得商铺类型列表
   *
   * @return 商铺类型列表
   */
  @Override
  public List<ShopKind> getShopKindList() {
    return shopKindDao.getShopKindList();
  }
}
