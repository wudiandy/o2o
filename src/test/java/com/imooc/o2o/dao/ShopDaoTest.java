package com.imooc.o2o.dao;

import com.imooc.o2o.base.BaseTest;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.fake.FakeData;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
  public void queryShopById() {
    int shopId = 6;
    Shop shop = shopDao.queryShopById(shopId);
    Assert.assertEquals("七杯茶", shop.getName());
  }

  @Test
  public void queryShopByOwner() {
    Long personInfoId = 1L;
    List<Shop> shopList = shopDao.queryShopByOwner(personInfoId);
    Assert.assertEquals(12, shopList.size());
  }
}
