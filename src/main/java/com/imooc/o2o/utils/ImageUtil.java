package com.imooc.o2o.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * @author wudi
 */
@Component
public class ImageUtil {
  private static String imgBaseLocation;

  @Value("${shop.img}")
  public void setImgBaseLocation(String imgBaseLocation) {
    ImageUtil.imgBaseLocation = imgBaseLocation;
  }

  public static File createImageFile() throws IOException {
    String fileLocationStr = imgBaseLocation + StringUtil.getTimeBasedRandomString() + ".jpg";
    File file = new File(fileLocationStr);
    if (!file.exists()) {
      file.createNewFile();
    }
    return file;
  }
}
