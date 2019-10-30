package com.imooc.o2o.web;

import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.service.ShopService;
import com.imooc.o2o.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/shop")
public class ShopController {
  private ShopService shopService;

  @Autowired
  public ShopController(ShopService shopService) {
    this.shopService = shopService;
  }

  /**
   * 创建一个新的店铺实体
   *
   * @param request request.shop是店铺实体对应的json。
   * @return  result: success表示店铺添加成功。
   *          result: failed表示店铺添加失败。
   *          message是成功或者失败的信息。相对成功的信息，失败的信息更加有用。
   */
  @RequestMapping("/createShop")
  @ResponseBody
  public Map<String, String> createShop(HttpServletRequest request) {
    Map<String, String> returnMap = new HashMap<>();
    String jsonStr = request.getParameter("shop");

    try {
      Shop shop = JsonUtil.json2Shop(jsonStr);
      int affectedRow = shopService.createShop(shop);
      if (affectedRow > 0) {
        returnMap.put("result", "success");
        returnMap.put("message", "success");
      } else {
        throw new RuntimeException("未能添加店铺");
      }
    } catch (IOException e) {
      e.printStackTrace();
      returnMap.put("result", "failed");
      returnMap.put("message", e.getMessage());
    }

    return returnMap;
  }

  /**
   * 访问创建店铺的页面
   *
   * @param request 没有用
   * @return 页面解析地址
   */
  @RequestMapping("/showCreateShopPage")
  public String showCreateShopPage(HttpServletRequest request) {
    return "/shop/createShop";
  }
}
