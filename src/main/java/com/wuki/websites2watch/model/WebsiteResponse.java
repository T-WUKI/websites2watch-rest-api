package com.wuki.websites2watch.model;

import java.util.Set;

public class WebsiteResponse extends WebsiteBean implements Response {

  public WebsiteResponse(
      String idName,
      String requestUrl,
      String description,
      Set<Tag> tags,
      Set<Action> actions,
      Set<Region> regions) {
    super(idName, requestUrl, description, tags, actions, regions);
  }


  public WebsiteResponse(Website base) {
    this(
      base.getName(),
      base.getRequestUrl(),
      base.getDescription(),
      base.getTags(),
      base.getActions(),
      base.getRegions()
    );
  }
}
