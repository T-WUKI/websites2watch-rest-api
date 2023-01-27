package com.wuki.websites2watch.repository;

import com.wuki.websites2watch.model.Website;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public interface WebsiteRepository extends JpaRepository<Website,Long> {

  @Query(value = "SELECT w FROM Website w where w.name = :uniqueName ")
  Website findByUniqueName(String uniqueName);

  /*

  private List<WebsiteBean> websites;
  public WebsiteRepository() {
    websites = new ArrayList<>();
    List<String> tags = new ArrayList<>();
    tags.addAll(Arrays.asList("Genossenschaft", "Miete"));
    List<String> actions = new ArrayList<>();
    actions.addAll(Arrays.asList("watchSingleChanges"));
    List<String> regions = new ArrayList<>();
    regions.addAll(Arrays.asList("Zürich Schwamendingen"));
    websites.add(
      new WebsiteBean(
        "bg-glattal",
        "https://www.bg-glattal.ch/vermietung/",
        "first website to watch",
        tags,
        actions,
        regions
      )
    );
    tags = new ArrayList<>();
    tags.addAll(Arrays.asList("Genossenschaft", "Miete"));
    actions = new ArrayList<>();
    actions.addAll(Arrays.asList("watchSingleChanges"));
    regions = new ArrayList<>();
    regions.addAll(Arrays.asList("Zürich Frankental"));
    websites.add(
      new WebsiteBean(
        "bsh-zürich",
        "https://www.bsh-zuerich.ch/freie-wohnungen/",
        "second website to watch",
        tags,
        actions,
        regions
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

  public WebsiteBean findByIdName(String idName) {
    Optional<WebsiteBean> result = websites.stream().filter(r -> r.getIdName().equals(idName)).findFirst();
    if (result.isPresent())
      return result.get();
    return null;
  }

  public void deleteWebsiteByIdName(String idName) {
    List<WebsiteBean> changed = new ArrayList<>();
    changed.addAll(websites.stream().filter(r -> !r.getIdName().equals(idName)).toList());
    websites = changed;
  }

  public WebsiteBean save(WebsiteBean request) {
    WebsiteBean result = request.clone();
    websites.add(result);
    return result;
  }

  public void updateWebsite(WebsiteBean updated) {
    deleteWebsiteByIdName(updated.getIdName());
    websites.add(updated);
  }

  */
}
