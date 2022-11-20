package com.wuki.websites2watch.repository;

import com.wuki.websites2watch.model.WebsiteResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebsiteRepository {

  public List<WebsiteResponse> findAll(String tag, String region) {
    List<WebsiteResponse> result = new ArrayList<>();
    result.addAll(
      Arrays.asList(
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
      )
    );
    result = result.stream().filter(r -> tag == null || r.getTags().stream().map(String::toLowerCase).toList().contains(tag.toLowerCase())).toList();
    result = result.stream().filter(r -> region == null || r.getRegions().stream().map(String::toLowerCase).toList().contains(region.toLowerCase())).toList();
    return result;
  }


}
