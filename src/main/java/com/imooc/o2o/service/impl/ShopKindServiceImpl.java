package com.imooc.o2o.service.impl;

import com.imooc.o2o.dao.ShopKindDao;
import com.imooc.o2o.entity.ShopKind;
import com.imooc.o2o.service.ShopKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wudi
 */
@Service
public class ShopKindServiceImpl implements ShopKindService {
  private ShopKindDao shopKindDao;

  @Autowired
  public ShopKindServiceImpl(ShopKindDao shopKindDao) {
    this.shopKindDao = shopKindDao;
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
