package com.imooc.o2o.fake;

import com.imooc.o2o.constant.FilePathConstant;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopKind;

import java.util.Date;

public class FakeData {
  private static Shop shop;

  private FakeData() {}

  public static Shop getShop() {
    if (shop == null) {
      shop = new Shop();
      initShop();
      return shop;
    }
    return shop;
  }

  private static void initShop() {
    shop.setAdvice("some advice");
    shop.setAddr("an address");
    Area area = new Area();
    area.setAreaId(1);
    shop.setArea(area);
    shop.setContactInfo("some contact info");
    shop.setCreateTime(new Date());
    shop.setDescription("some description");
    shop.setLastEditTime(new Date());
    shop.setName("a name");
    PersonInfo personInfo = new PersonInfo();
    personInfo.setPersonId(1L);
    shop.setPersonInfo(personInfo);
    shop.setPriority(1);
    shop.setShopId(1L);
    shop.setShopImg(FilePathConstant.TEST_IMG);
    ShopKind shopKind = new ShopKind();
    shopKind.setShopKindId(1L);
    shop.setShopKind(shopKind);
    shop.setStatus(1);
  }
}
