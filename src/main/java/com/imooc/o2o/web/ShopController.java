package com.imooc.o2o.web;

import com.imooc.o2o.directory.ShopStatusDirectory;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopKind;
import com.imooc.o2o.service.AreaService;
import com.imooc.o2o.service.ShopService;
import com.imooc.o2o.utils.ImageUtil;
import com.imooc.o2o.utils.VerificationCodeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wudi
 */
@Controller
@RequestMapping("/shop")
public class ShopController {
  private ShopService shopService;
  private AreaService areaService;

  private static final Logger logger = LoggerFactory.getLogger(ShopController.class);

  @Autowired
  public ShopController(ShopService shopService, AreaService areaService) {
    this.shopService = shopService;
    this.areaService = areaService;
  }

  /**
   * 创建一个新的店铺实体
   *
   * @param request request.shop是店铺实体对应的json。
   * @return  result: success表示店铺添加成功。
   *          result: failed表示店铺添加失败。
   *          message是成功或者失败的信息。相对成功的信息，失败的信息更加有用。
   */
  @RequestMapping(value = "/registerShop", method = RequestMethod.POST)
  @ResponseBody
  public Map<String, Object> registerShop(HttpServletRequest request) throws Exception {
    Map<String, Object> returnMap = new HashMap<>(16);
    CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());

    // 判断是否有上传的文件流，如果没有上传店铺图片，则店铺添加失败
    if (!resolver.isMultipart(request)) {
      returnMap.put("result", "failed");
      returnMap.put("message", "没有上传店铺图片");
      return returnMap;
    }

    // 检查验证码输入是否正确
    if (!VerificationCodeUtil.checkVerificationCodeUtil(request)) {
      returnMap.put("result", "failed");
      returnMap.put("message", "验证码错误");
      return returnMap;
    }

    MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;

    // 通过参数构建商铺对象
    Shop shop = getShop(request, multipartHttpServletRequest);

    // 添加商铺对象
    int affectedRows = shopService.createShop(shop);
    if (affectedRows > 0) {
      returnMap.put("result", "success");
      returnMap.put("message", "恭喜你，成功创建店铺！");
    } else {
      returnMap.put("result", "failed");
      returnMap.put("message", "很遗憾，未能成功创建店铺！");
    }

    return returnMap;
  }

  private Shop getShop(HttpServletRequest request, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
    Shop shop = new Shop();
    shop.setName(request.getParameter("shopName") == null ? "" : request.getParameter("shopName"));
    List<ShopKind> shopKindList = shopService.getShopKindList();
    for (ShopKind shopKind : shopKindList) {
      if (shopKind.getShopKindId() == Integer.parseInt(request.getParameter("shopKindId"))) {
        shop.setShopKind(shopKind);
        break;
      }
    }
    List<Area> areaList = areaService.getAllArea();
    for (Area area : areaList) {
      if (area.getAreaId() == Integer.parseInt(request.getParameter("areaId"))) {
        shop.setArea(area);
        break;
      }
    }
    shop.setAddr(request.getParameter("address"));
    shop.setDescription(request.getParameter("desc"));

    CommonsMultipartFile commonsMultipartFile = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
    if (commonsMultipartFile != null) {
      try {
        InputStream inputStream = commonsMultipartFile.getInputStream();
        byte[] bytes = new byte[inputStream.available()];
        int readBytes = inputStream.read(bytes);
        // 如果没有读到任何字符，说明临时文件损坏
        if (readBytes <= 0) {
          throw new Exception("临时文件损坏");
        }
        inputStream.close();

        File file = ImageUtil.createImageFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(bytes);
        fileOutputStream.close();
        shop.setShopImg(file.getAbsolutePath());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    // 设置优先级，新商铺默认优先级为1
    shop.setPriority(1);

    shop.setContactInfo("");

    // 设置用户ID
    // fixme 应该从session中取出用户信息，当前暂时手动创建用户信息
    PersonInfo personInfo = new PersonInfo();
    personInfo.setPersonId(1L);
    shop.setPersonInfo(personInfo);

    // 设置商铺状态
    shop.setStatus(ShopStatusDirectory.REVIEWING);

    // 设置店铺创建时间
    shop.setCreateTime(new Date());

    // 设置最后编辑时间，店铺首次创建时，最后编辑时间就是店铺创建时间
    shop.setLastEditTime(shop.getCreateTime());
    return shop;
  }

  /**
   * 访问创建店铺的页面
   *
   * @return 页面解析地址
   */
  @RequestMapping("/showCreateShopPage")
  public String showCreateShopPage() {
    return "/shop/createShop";
  }

  @RequestMapping("/init/shop")
  @ResponseBody
  public Map<String, Object> getCreateShopPageInitInfo() {
    Map<String, Object> map = new HashMap<>(16);
    List<ShopKind> shopKindList;
    List<Area> areaList;
    shopKindList = shopService.getShopKindList();
    areaList = areaService.getAllArea();
    map.put("shopKindList", shopKindList);
    map.put("areaList", areaList);
    return map;
  }

  /**
   * 通过商铺ID获取商铺信息
   *
   * @param id 商铺ID
   * @return 商铺信息
   */
  @RequestMapping(value = "/getShopInfoById", method = RequestMethod.POST)
  @ResponseBody
  public Map<String, Object> getShopInfoById(@RequestParam int id) {
    logger.debug("id = " + id);
    Shop shop = shopService.getShopInformationById(id);
    Map<String, Object> map = new HashMap<>(16);
    map.put("shopInfo", shop);
    return map;
  }

  /**
   * 返回商铺信息变更页面
   *
   * @return 页面地址
   */
  @RequestMapping("/update")
  public String showUpdateShopPage(@RequestParam int shopId, Model model) {
    model.addAttribute("shopId", shopId);
    model.addAttribute("name", "wudi");
    return "/shop/updateShop";
  }

  /**
   * 返回商铺列表页面
   *
   * @return  商铺列表页面
   */
  @RequestMapping(value = "/shopList/page", method = RequestMethod.GET)
  public String showPageShopList() {
    return "/shop/shopList";
  }

  /**
   * Get the current user's shop list
   *
   * @return shop list
   */
  @RequestMapping(value = "/shopList", method = RequestMethod.GET)
  public Map<String, Object> getShopList() {
    // fixme personInfoId should get from person information in session
    Long personInfoId = 1L;
    List<Shop> shopList = shopService.getShopListByOwnerId(personInfoId);

    Map<String, Object> map = new HashMap<>(16);
    map.put("shopList", shopList);
    return map;
  }
}
