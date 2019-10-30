package com.imooc.o2o.dao;

import com.imooc.o2o.base.BaseTest;
import com.imooc.o2o.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AreaDaoTest extends BaseTest {
  @Autowired
  private AreaDao areaDao;

  @Test
  public void case1() {
    List<Area> areaList = areaDao.findAllArea();
    assert areaList != null;
    assert areaList.get(0).getAreaName().equals("文昌校区");
    assert areaList.get(0).getPriority().equals(1);
  }
}
