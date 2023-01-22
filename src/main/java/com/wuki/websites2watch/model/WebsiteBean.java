package com.wuki.websites2watch.model;

import java.util.List;

public class WebsiteBean implements Cloneable {

  private String idName;
  private String requestUrl;
  private String description;
  private List<String> tags;
  private List<String> actions;
  private List<String> regions;

  public WebsiteBean(
      String idName,
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

  @Override
  public WebsiteBean clone() {
    try {
      WebsiteBean clone = (WebsiteBean) super.clone();
      // TODO: copy mutable state here, so the clone can't change the internals of the original
      return clone;
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }
}
