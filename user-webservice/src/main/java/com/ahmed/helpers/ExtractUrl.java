package com.ahmed.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractUrl {

  private ExtractUrl() {}

  public static UrlKeyValue extractKeyValueFromUri(String uri) {
    UrlKeyValue urlKeyValue = new UrlKeyValue();
    Pattern pattern = Pattern.compile("(\\w+)=?([^&]+)?");
    Matcher matcher = pattern.matcher(uri);
    while (matcher.find()) {
      urlKeyValue.setKey(matcher.group(1));
      urlKeyValue.setValue(matcher.group(2));
    }
    return urlKeyValue;
  }
}
