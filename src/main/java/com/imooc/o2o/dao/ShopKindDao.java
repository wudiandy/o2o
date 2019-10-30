package com.imooc.o2o.dao;

import com.imooc.o2o.entity.ShopKind;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wudi
 */
@Repository
public interface ShopKindDao {
  /**
   * 返回商铺类型列表
   *
   * @return 商铺类型列表
   */
  List<ShopKind> getShopKindList();
}
