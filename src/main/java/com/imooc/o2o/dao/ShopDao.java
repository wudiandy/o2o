package com.imooc.o2o.dao;

import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wudi.andy@qq.com
 */
@Repository
public interface ShopDao {
  /**
   * 向o2o.shop表中插入一条记录
   * @param shop 要插入的商铺对象
   * @return 插入操作影响数据表的行数
   */
  int insert(Shop shop);

  /**
   * Get shop object based on shop id
   *
   * @param id shop id
   * @return shop object
   */
  Shop queryShopById(int id);

  /**
   * 更新商铺信息
   *
   * @param shop 商铺对象
   * @return 影响的行数
   */
  int update(Shop shop);

  /**
   * 查询店主的店铺列表
   * @param personInfoId  店主id
   * @return              店铺列表
   */
  List<Shop> queryShopByOwner(Long personInfoId);
}
