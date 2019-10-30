package com.imooc.o2o.dao;

import com.imooc.o2o.entity.Area;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaDao {
  /**
   * 查询出o2o.area表中的所有数据
   * @return 区域对象列表
   */
  List<Area> findAllArea();
}
