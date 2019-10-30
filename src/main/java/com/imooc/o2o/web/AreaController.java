package com.imooc.o2o.web;

import com.imooc.o2o.entity.Area;
import com.imooc.o2o.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/superadmin")
public class AreaController {
  private AreaService areaService;

  private static final Logger logger = LoggerFactory.getLogger(AreaController.class);

  @Autowired
  public AreaController(AreaService areaService) {
    this.areaService = areaService;
  }

  @RequestMapping("/areas")
  @ResponseBody
  public Map<String, Object> getAllArea() {
    logger.debug("****** getAllArea start ******");

    List<Area> areaList = areaService.getAllArea();
    Map<String, Object> resultMap = new HashMap<>();
    resultMap.put("areaList", areaList);

    logger.debug("****** getAllArea end ******");
    return resultMap;
  }
}
