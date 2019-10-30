package com.imooc.o2o.service;

import com.imooc.o2o.base.BaseTest;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.fake.FakeData;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ShopServiceTest extends BaseTest {
  @Autowired
  private ShopService shopService;

  @Test
  public void case1() {
    Shop shop = FakeData.getShop();
    int affectedRow = shopService.createShop(shop);
    Assert.assertTrue("添加商铺失败", affectedRow > 0);
  }
}
