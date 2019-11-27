package com.imooc.o2o.dao;

import com.imooc.o2o.base.BaseTest;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.fake.FakeData;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ShopDaoTest extends BaseTest {
  @Autowired
  private ShopDao shopDao;

  @Test
  public void insertShopTest() {
    Shop shop = FakeData.getShop();
    int affectedRows = shopDao.insert(shop);
    Assert.assertTrue(affectedRows > 0);
  }

  @Test
  public void queryShopByShopName() {
    shopDao.queryShopByShopName("");
  }
}
