package com.wuki.websites2watch.model;

import java.util.List;

public class WebsiteResponse {

  private final String uniqueName;
  private final String requestUrl;
  private final String description;
  private final List<String> regions;
  private final List<String> tags;
  private final List<String> actions;

  public WebsiteResponse(String uniqueName,
                         String requestUrl,
                         String description,
                         List<String> tags,
                         List<String> actions,
                         List<String> regions) {
    this.uniqueName = uniqueName;
    this.requestUrl = requestUrl;
    this.description = description;
    this.tags = tags;
    this.actions = actions;
    this.regions = regions;
  }

  public String getUniqueName() {
    return uniqueName;
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
