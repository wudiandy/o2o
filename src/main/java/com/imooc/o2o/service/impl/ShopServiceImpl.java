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
  @Transactional(rollbackFor = Exception.class)
  public int createShop(Shop shop) {
    // 检查店铺是否已经创建过了
    if (shop.getShopId() == null) {
      return shopDao.insert(shop);
    } else {
      return shopDao.update(shop);
    }
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

  /**
   * 根据商铺ID获取商铺对象
   *
   * @param id 商铺ID
   * @return 商铺对象
   */
  @Override
  public Shop getShopInformationById(int id) {
    return shopDao.queryShopById(id);
  }

  /**
   * 通过店主ID取得店铺列表
   *
   * @param id 店主ID
   * @return 店铺列表
   */
  @Override
  public List<Shop> getShopListByOwnerId(Long id) {
    return shopDao.queryShopByOwner(id);
  }
}
