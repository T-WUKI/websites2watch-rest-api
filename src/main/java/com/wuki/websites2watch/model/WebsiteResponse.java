package com.wuki.websites2watch.model;

import java.util.List;

public class WebsiteResponse extends WebsiteBean implements Response {

  public WebsiteResponse(
      String idName,
      String requestUrl,
      String description,
      List<String> tags,
      List<String> actions,
      List<String> regions) {
    super(idName, requestUrl, description, tags, actions, regions);
  }

  public WebsiteResponse(WebsiteBean base) {
    this(
      base.getIdName(),
      base.getRequestUrl(),
      base.getDescription(),
      base.getTags(),
      base.getActions(),
      base.getRegions()
    );
  }
}
