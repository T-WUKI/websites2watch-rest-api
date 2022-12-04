package com.wuki.websites2watch.controller;

import com.wuki.websites2watch.model.WebsiteBean;
import com.wuki.websites2watch.repository.WebsiteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WebsiteController {

  private WebsiteRepository websiteRepo;

  public WebsiteController(WebsiteRepository repo) {
    this.websiteRepo = repo;
  }

  @GetMapping("/websites")
  public List<WebsiteBean> getAllWebsites(
          @RequestParam(required = false) String tag,
          @RequestParam(required = false) String region
  ) {
    return websiteRepo.findAll(tag, region);
  }

  @GetMapping("/websites/{idName}")
  public ResponseEntity<WebsiteBean> getWebsiteByIdName(
    @PathVariable String idName
  ){
    Optional<WebsiteBean> resultByIdName = websiteRepo.findByIdName(idName);
    if (resultByIdName.isPresent())
      return ResponseEntity.ok(resultByIdName.get());
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/websites/{idName}")
  public ResponseEntity deleteWebsite(
    @PathVariable String idName
  ){
    websiteRepo.deleteWebsiteByIdName(idName);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/websites")
  public ResponseEntity<WebsiteBean> createWebsite(
    @RequestBody WebsiteBean request
  ){
    return   ResponseEntity.ok(websiteRepo.save(request));
  }

}
