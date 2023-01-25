package com.wuki.websites2watch.service;

import com.wuki.websites2watch.exception.Website2watchException;
import com.wuki.websites2watch.model.WebsiteBean;
import com.wuki.websites2watch.model.WebsiteRequest;
import com.wuki.websites2watch.model.WebsiteResponse;
import com.wuki.websites2watch.model.WebsiteTagsRequest;
import com.wuki.websites2watch.repository.WebsiteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebsiteService {

  private final WebsiteRepository repo;

  public WebsiteService(WebsiteRepository repo) {
    this.repo = repo;
  }

  public List<WebsiteResponse> findAll(String tag, String region) {
    return repo.findAll(tag, region)
      .stream()
      .map(WebsiteResponse::new)
      .toList();
  }

  public WebsiteResponse findByIdName(String idName) {
    return new WebsiteResponse(repo.findByIdName(idName));
  }

  public void deleteWebsiteByIdName(String idName){
    repo.deleteWebsiteByIdName(idName);
  }

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

}
