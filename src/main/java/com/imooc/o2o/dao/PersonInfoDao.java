package com.imooc.o2o.dao;

import com.imooc.o2o.entity.PersonInfo;

/**
 * @author 吴笛
 * @date 2020/1/5
 */
public interface PersonInfoDao {
  /**
   * 通过用户ID取得用户信息
   *
   * @param id
   * @return
   */
  PersonInfo getPersonInfoById(int id);
}
