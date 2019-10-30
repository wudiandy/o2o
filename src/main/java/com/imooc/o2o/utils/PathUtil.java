package com.imooc.o2o.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PathUtil {
  private static Logger logger = LoggerFactory.getLogger(PathUtil.class);

  public static String getRootPath() {
    String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    logger.debug("rootPath = " + rootPath);
    return rootPath;
  }

  public static void main(String[] args) {
    getRootPath();
  }
}
