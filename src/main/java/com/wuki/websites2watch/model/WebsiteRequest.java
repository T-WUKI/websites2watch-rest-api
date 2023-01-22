package com.wuki.websites2watch.model;

import java.util.List;

public class WebsiteRequest extends WebsiteBean {

  public WebsiteRequest(
      String idName,
      String requestUrl,
      String description,
      List<String> tags,
      List<String> actions,
      List<String> regions) {
    super(idName, requestUrl, description, tags, actions, regions);
  }
}
