package com.wuki.websites2watch.model;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unused")
public class WebsiteRequest extends WebsiteBean {

  private final Set<Tag> tags;
  private final Set<Action> actions;
  private final Set<Region> regions;

  public WebsiteRequest(
      String idName,
      String requestUrl,
      String description,
      List<String> tags,
      List<String> actions,
      List<String> regions) {
    super(idName, requestUrl, description);
    this.tags = (Set<Tag>) buildEntities(tags, Tag.class);
    this.actions = (Set<Action>) buildEntities(actions, Action.class);
    this.regions = (Set<Region>) buildEntities(regions, Region.class);
  }

  Set<? extends ISingleValue<String>> buildEntities(List<String> inputSet, Class<? extends ISingleValue<String>> clazz) {
    Set<ISingleValue<String>> result = new LinkedHashSet<>();
    try {
      Constructor<ISingleValue<String>> cons = (Constructor<ISingleValue<String>>) clazz.getConstructor();
      for (String singleValue: inputSet) {
        ISingleValue<String> obj = cons.newInstance();
        obj.setVal(singleValue);
        result.add(obj);
      }
    } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
      throw new RuntimeException(e);
    }
    return result;
  }


  public Set<Tag> getTags() {
    return tags;
  }

  public Set<Action> getActions() {
    return actions;
  }

  public Set<Region> getRegions() {
    return regions;
  }
}
