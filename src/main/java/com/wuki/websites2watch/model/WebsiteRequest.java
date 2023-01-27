package com.wuki.websites2watch.model;

import java.util.Set;

@SuppressWarnings("unused")
public class WebsiteRequest extends WebsiteBean {

  public WebsiteRequest(
      String idName,
      String requestUrl,
      String description,
      Set<Tag> tags,
      Set<Action> actions,
      Set<Region> regions) {
    super(idName, requestUrl, description, tags, actions, regions);
  }
}
