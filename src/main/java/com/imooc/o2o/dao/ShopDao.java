package com.imooc.o2o.dao;

import com.imooc.o2o.entity.Shop;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopDao {
  /**
   * 向o2o.shop表中插入一条记录
   * @param shop 要插入的商铺对象
   * @return 插入操作影响数据表的行数
   */
  int insert(Shop shop);

  /**
   * 根据商铺名称查询商铺对象
   * @param shopName  商铺名称
   * @return          商铺对象
   */
  Shop queryShopByShopName(String shopName);
}
