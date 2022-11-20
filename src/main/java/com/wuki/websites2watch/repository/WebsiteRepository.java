package com.wuki.websites2watch.repository;

import com.wuki.websites2watch.model.WebsiteResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebsiteRepository {

  private List<WebsiteResponse> websites = Arrays.asList(
    new WebsiteResponse(
      "bg-glattal",
      "https://www.bg-glattal.ch/vermietung/",
      "first website to watch",
      Arrays.asList("Genossenschaft", "Miete"),
      Arrays.asList("watchSingleChanges"),
      Arrays.asList("Zürich Schwamendingen")
    ),
    new WebsiteResponse(
      "bsh-zürich",
      "https://www.bsh-zuerich.ch/freie-wohnungen/",
      "second website to watch",
      Arrays.asList("Genossenschaft", "Miete"),
      Arrays.asList("watchSingleChanges"),
      Arrays.asList("Zürich Frankental")
    )
  );

  public List<WebsiteResponse> findAll(String tag, String region) {
    List<WebsiteResponse> result = new ArrayList<>(websites);
    result = result.stream().filter(r -> tag == null || getLowerCaseStrings(r.getTags()).contains(tag.toLowerCase())).toList();
    result = result.stream().filter(r -> region == null || getLowerCaseStrings(r.getRegions()).contains(region.toLowerCase())).toList();
    return result;
  }

  private static List<String> getLowerCaseStrings(List<String> r) {
    return r.stream().map(String::toLowerCase).toList();
  }


}
