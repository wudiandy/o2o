package com.imooc.o2o.dto.impl;

import com.imooc.o2o.dto.CreateShopDto;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.ShopKind;
import com.imooc.o2o.service.AreaService;
import com.imooc.o2o.service.ShopKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 吴笛
 */
@Component
public class CreateShopDtoImpl implements CreateShopDto {
  private ShopKindService shopKindService;
  private AreaService areaService;

  @Autowired
  public CreateShopDtoImpl(ShopKindService shopKindService) {
    this.shopKindService = shopKindService;
  }

  @Autowired
  public CreateShopDtoImpl(ShopKindService shopKindService, AreaService areaService) {
    this.shopKindService = shopKindService;
    this.areaService = areaService;
  }

  /**
   * 取得注册商铺页面需要的信息
   *
   * @return 注册商铺页面需要的信息。
   */
  @Override
  public Map<String, Object> getCreateShopInfo() {
    List<ShopKind> shopKindList = shopKindService.getShopKindList();
    List<Area> areaList = areaService.getAllArea();
    Map<String, Object> map = new HashMap<>(16);
    map.put("shopKindList", shopKindList);
    map.put("areaList", areaList);
    return map;
  }
}
