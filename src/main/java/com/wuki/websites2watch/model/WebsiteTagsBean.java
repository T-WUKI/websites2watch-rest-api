package com.wuki.websites2watch.model;

import java.util.List;

public class WebsiteTagsBean {

  private List<String> tags;

  public WebsiteTagsBean() {

  }
  public WebsiteTagsBean(List<String> tags) {
    this.tags = tags;
  }

  public List<String> getTags() {
    return tags;
  }


}
