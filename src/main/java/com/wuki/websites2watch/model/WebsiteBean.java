package com.wuki.websites2watch.model;

import java.util.List;

public class WebsiteResponse {

  private final String idName;
  private final String requestUrl;
  private final String description;
  private final List<String> regions;
  private final List<String> tags;
  private final List<String> actions;

  public WebsiteResponse(String idName,
                         String requestUrl,
                         String description,
                         List<String> tags,
                         List<String> actions,
                         List<String> regions) {
    this.idName = idName;
    this.requestUrl = requestUrl;
    this.description = description;
    this.tags = tags;
    this.actions = actions;
    this.regions = regions;
  }

  public String getIdName() {
    return idName;
  }

  public String getRequestUrl() {
    return requestUrl;
  }

  public String getDescription() {
    return description;
  }

  public List<String> getTags() {
    return tags;
  }

  public List<String> getActions() {
    return actions;
  }

  public List<String> getRegions() {
    return regions;
  }
}
