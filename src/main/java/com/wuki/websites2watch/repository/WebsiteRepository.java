package com.wuki.websites2watch.repository;

import com.wuki.websites2watch.model.WebsiteBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class WebsiteRepository {

  private List<WebsiteBean> websites = new ArrayList<>();

  {
    websites.addAll(
      Arrays.asList(
        new WebsiteBean(
          "bg-glattal",
          "https://www.bg-glattal.ch/vermietung/",
          "first website to watch",
          Arrays.asList("Genossenschaft", "Miete"),
          Arrays.asList("watchSingleChanges"),
          Arrays.asList("Zürich Schwamendingen")
        ),
        new WebsiteBean(
          "bsh-zürich",
          "https://www.bsh-zuerich.ch/freie-wohnungen/",
          "second website to watch",
          Arrays.asList("Genossenschaft", "Miete"),
          Arrays.asList("watchSingleChanges"),
          Arrays.asList("Zürich Frankental")
        )
      )
    );
  }



  public List<WebsiteBean> findAll(String tag, String region) {
    List<WebsiteBean> result = new ArrayList<>(websites);
    result = result.stream().filter(r -> tag == null || getLowerCaseStrings(r.getTags()).contains(tag.toLowerCase())).toList();
    result = result.stream().filter(r -> region == null || getLowerCaseStrings(r.getRegions()).contains(region.toLowerCase())).toList();
    return result;
  }

  private static List<String> getLowerCaseStrings(List<String> r) {
    return r.stream().map(String::toLowerCase).toList();
  }

  public Optional<WebsiteBean> findByIdName(String idName) {
    return websites.stream().filter(r -> r.getIdName().equals(idName)).findFirst();
  }

  public void deleteWebsiteByIdName(String idName) {
    websites = websites.stream().filter(r -> !r.getIdName().equals(idName)).toList();
  }

  public WebsiteBean save(WebsiteBean request) {
    WebsiteBean result = request.clone();
    websites.add(result);
    return result;
  }
}
