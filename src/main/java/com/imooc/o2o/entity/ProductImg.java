package com.imooc.o2o.entity;

import java.util.Date;

public class ProductImg {
  private Long productImgId;
  private Shop shop;
  private String addr;
  private String description;
  private Integer priority;
  private Date createTime;

  public Long getProductImgId() {
    return productImgId;
  }

  public void setProductImgId(Long productImgId) {
    this.productImgId = productImgId;
  }

  public Shop getShop() {
    return shop;
  }

  public void setShop(Shop shop) {
    this.shop = shop;
  }

  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
}
