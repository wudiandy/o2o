package com.imooc.o2o.service;

import com.imooc.o2o.base.BaseTest;
import com.imooc.o2o.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.junit.Assert.assertEquals;

@Component
public class AreaServiceTest extends BaseTest {
  @Autowired
  private AreaService areaService;

  @Test
  public void case1() {
    List<Area> areaList = areaService.getAllArea();
    assertEquals("文昌校区", areaList.get(0).getAreaName());
  }
}
