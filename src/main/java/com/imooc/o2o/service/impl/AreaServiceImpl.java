package com.imooc.o2o.service.impl;

import com.imooc.o2o.dao.AreaDao;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author wudi
 */
@Service
public class AreaServiceImpl implements AreaService {
  private AreaDao areaDao;

  @Autowired
  public AreaServiceImpl(AreaDao areaDao) {
    this.areaDao = areaDao;
  }

  public AreaServiceImpl() {
  }

  @Override
  public List<Area> getAllArea() {
    return areaDao.findAllArea();
  }
}
