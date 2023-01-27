package com.wuki.websites2watch.model;

import java.util.LinkedHashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class WebsiteBean implements Cloneable {

  private final String uniqueName;
  private final String requestUrl;
  private final String description;
  private final Set<String> tags;
  private final Set<String> actions;
  private final Set<String> regions;

  public WebsiteBean(
      String uniqueName,
      String requestUrl,
      String description,
      Set<Tag> tags,
      Set<Action> actions,
      Set<Region> regions) {
    this.uniqueName = uniqueName;
    this.requestUrl = requestUrl;
    this.description = description;
    this.tags = extractValues(tags);
    this.actions = extractValues(actions);
    this.regions = extractValues(regions);
  }

  Set<String> extractValues(Set<? extends ISingleValue<String>> inputSet) {
    Set<String> result = new LinkedHashSet<>();
    for (ISingleValue<String> singleValue: inputSet) {
      result.add(singleValue.getVal());
    }
    return result;
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

  public Set<String> getTags() {
    return tags;
  }

  public Set<String> getActions() {
    return actions;
  }

  public Set<String> getRegions() {
    return regions;
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
