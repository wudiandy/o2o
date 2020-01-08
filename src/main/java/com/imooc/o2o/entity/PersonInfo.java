package com.imooc.o2o.entity;

import java.util.Date;

/**
 * @author 吴笛
 */
public class PersonInfo {
  private Long personId;
  private String personName;
  private String imgLocation;
  private String email;
  /**
   * 0：女性
   * 1：男性
   */
  private Integer gender;
  /**
   * 0：不可用
   * 1：可用
   */
  private Integer status;
  /**
   * 1：顾客
   * 2：店主
   * 3：超级管理员
   */
  private Integer role;
  private Date createTime;
  private Date lastEditedTime;

  public Long getPersonId() {
    return personId;
  }

  public void setPersonId(Long personId) {
    this.personId = personId;
  }

  public String getPersonName() {
    return personName;
  }

  public void setPersonName(String personName) {
    this.personName = personName;
  }

  public String getImgLocation() {
    return imgLocation;
  }

  public void setImgLocation(String imgLocation) {
    this.imgLocation = imgLocation;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getGender() {
    return gender;
  }

  public void setGender(Integer gender) {
    this.gender = gender;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Integer getRole() {
    return role;
  }

  public void setRole(Integer role) {
    this.role = role;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getLastEditedTime() {
    return lastEditedTime;
  }

  public void setLastEditedTime(Date lastEditedTime) {
    this.lastEditedTime = lastEditedTime;
  }
}
