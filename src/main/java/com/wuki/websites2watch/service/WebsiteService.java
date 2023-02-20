package com.wuki.websites2watch.service;

import com.wuki.websites2watch.exception.Website2watchException;
import com.wuki.websites2watch.model.Website;
import com.wuki.websites2watch.model.WebsiteResponse;
import com.wuki.websites2watch.repository.WebsiteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WebsiteService {

  private final WebsiteRepository repo;

  public WebsiteService(WebsiteRepository repo) {
    this.repo = repo;
  }

  /*
  public List<WebsiteResponse> findAll(String tag, String region) {
    return repo.findAll(tag, region)
      .stream()
      .map(WebsiteResponse::new)
      .toList();
  }
  */

  public List<WebsiteResponse> findAll(String tag, String region) {
    List<WebsiteResponse> result = new ArrayList<>();
    List<Website> queryResult = repo.findAll();
    for (Website website: queryResult) {
      result.add(new WebsiteResponse(website));
    }
    return result;
  }

  public WebsiteResponse findByUniqueName(String uniqueName) throws Website2watchException {
    Website entity = repo.findByUniqueName(uniqueName);
    if (entity == null)
      throw new Website2watchException("Website-Entity not found!", 400);
    return new WebsiteResponse(entity);
  }

  public WebsiteResponse save(Website website) throws Website2watchException {
    Website entity = repo.findByUniqueName(website.getName());
    if (entity != null)
      throw new Website2watchException("Website-Entity already exists!", 400);
    return new WebsiteResponse(repo.save(website));
  }


  public void deleteWebsiteByUniqueName(String uniqueName, TagService tagService, ActionService actionService, RegionService regionService) throws Website2watchException {
    Website entity = repo.findByUniqueName(uniqueName);
    if (entity == null)
      throw new Website2watchException("Website-Entity not found!", 400);
    tagService.deleteTags(entity);
    actionService.deleteActions(entity);
    regionService.deleteRegions(entity);
    repo.delete(entity);
  }

  /*


  public WebsiteResponse save(WebsiteRequest request) {
    return new WebsiteResponse(repo.save(request));
  }

  public WebsiteResponse updateWebsiteTags(String idName, WebsiteTagsRequest request) throws Website2watchException {

    WebsiteBean origin = repo.findByIdName(idName);
    if (origin == null)
      throw new Website2watchException("Website-Entity not found!", 400);

    WebsiteBean updated = new WebsiteBean(
      origin.getIdName(),
      origin.getRequestUrl(),
      origin.getDescription(),
      request.getTags(),
      origin.getActions(),
      origin.getRegions()
    );
    repo.updateWebsite(updated);
    return new WebsiteResponse(updated);

  }

   */

}
