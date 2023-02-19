package com.wuki.websites2watch.model;

import java.util.LinkedHashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class WebsiteResponse extends WebsiteBean implements Response {

  private final Set<String> tags;
  private final Set<String> actions;
  private final Set<String> regions;

  public WebsiteResponse(
      String uniqueName,
      String requestUrl,
      String description,
      Set<Tag> tags,
      Set<Action> actions,
      Set<Region> regions) {
    super(uniqueName, requestUrl, description);
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

  public Set<String> getTags() {
    return tags;
  }

  public Set<String> getActions() {
    return actions;
  }

  public Set<String> getRegions() {
    return regions;
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
