package com.imooc.o2o.entity;

import java.util.Date;

public class ShopKind {
  private Long shopKindId;
  private Integer priority;
  private ShopKind parent;
  private String name;
  private String description;
  private String img;
  private Date createTime;
  private Date lastEditTime;

  public Long getShopKindId() {
    return shopKindId;
  }

  public void setShopKindId(Long shopKindId) {
    this.shopKindId = shopKindId;
  }

  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  public ShopKind getParent() {
    return parent;
  }

  public void setParent(ShopKind parent) {
    this.parent = parent;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getLastEditTime() {
    return lastEditTime;
  }

  public void setLastEditTime(Date lastEditTime) {
    this.lastEditTime = lastEditTime;
  }
}
