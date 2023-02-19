package com.wuki.websites2watch.model;

@SuppressWarnings("unused")
public class WebsiteBean implements Cloneable {

  private final String uniqueName;
  private final String requestUrl;
  private final String description;

  public WebsiteBean(
      String uniqueName,
      String requestUrl,
      String description) {
    this.uniqueName = uniqueName;
    this.requestUrl = requestUrl;
    this.description = description;
  }

  /*
  public WebsiteBean(
    String uniqueName,
    String requestUrl,
    String description,
    List<String> tags,
    List<String> actions,
    List<String> regions) {
    this.uniqueName = uniqueName;
    this.requestUrl = requestUrl;
    this.description = description;
    this.tags = new HashSet<>(tags);
    this.actions = new HashSet<>(actions);
    this.regions = new HashSet<>(regions);
 }
 */



  public String getUniqueName() {
    return uniqueName;
  }

  public String getRequestUrl() {
    return requestUrl;
  }

  public String getDescription() {
    return description;
  }


  @Override
  public WebsiteBean clone() {
    try {
      // TODO: copy mutable state here, so the clone can't change the internals of the original
      return (WebsiteBean) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }
}
