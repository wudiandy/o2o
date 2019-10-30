package com.imooc.o2o.entity;

import java.util.Date;

public class HeadLine {
  private Long headLineId;
  private Integer priority;
  private Integer status;
  private String name;
  private String link;
  private String img;
  private Date createTime;
  private Date lastEditTime;

  public Long getHeadLineId() {
    return headLineId;
  }

  public void setHeadLineId(Long headLineId) {
    this.headLineId = headLineId;
  }

  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
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
