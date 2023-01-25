package com.wuki.websites2watch.controller;

import com.wuki.websites2watch.exception.Website2watchException;
import com.wuki.websites2watch.model.Response;
import com.wuki.websites2watch.model.WebsiteRequest;
import com.wuki.websites2watch.model.WebsiteResponse;
import com.wuki.websites2watch.model.WebsiteTagsRequest;
import com.wuki.websites2watch.service.WebsiteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WebsiteController {


  private WebsiteService service;

  public WebsiteController(WebsiteService service) {
    this.service = service;
  }

  @GetMapping("/websites")
  public ResponseEntity<List<WebsiteResponse>> getAllWebsites(
          @RequestParam(required = false) String tag,
          @RequestParam(required = false) String region
  ) {
    List<WebsiteResponse> result = service.findAll(tag, region);
    if (!result.isEmpty())
      return ResponseEntity.ok(result);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/websites/{idName}")
  public ResponseEntity<Response> getWebsiteByIdName(
    @PathVariable String idName
  ){
    WebsiteResponse result = service.findByIdName(idName);
    if (result != null)
      return ResponseEntity.ok(result);
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/websites/{idName}")
  public ResponseEntity<?> deleteWebsite(
    @PathVariable String idName
  ){
    service.deleteWebsiteByIdName(idName);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/websites")
  public ResponseEntity<Response> createWebsite(
    @RequestBody WebsiteRequest request
  ){
    return ResponseEntity.ok(service.save(request));
  }

  @PutMapping("/websites/{idName}/tags")
  public ResponseEntity<Response> updateWebsiteTags(
    @PathVariable String idName,
    @RequestBody WebsiteTagsRequest request
  ) throws Website2watchException {
    return ResponseEntity.ok(service.updateWebsiteTags(idName, request));
  }

}
