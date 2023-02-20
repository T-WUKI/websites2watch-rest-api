package com.wuki.websites2watch.controller;

import com.wuki.websites2watch.exception.Website2watchException;
import com.wuki.websites2watch.model.Website;
import com.wuki.websites2watch.model.WebsiteRequest;
import com.wuki.websites2watch.model.WebsiteResponse;
import com.wuki.websites2watch.service.ActionService;
import com.wuki.websites2watch.service.RegionService;
import com.wuki.websites2watch.service.TagService;
import com.wuki.websites2watch.service.WebsiteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SuppressWarnings("unused")
public class WebsiteController {


  private final WebsiteService wsService;
  private final TagService tagService;
  private final ActionService actionService;
  private final RegionService regionService;

  public WebsiteController(WebsiteService wsService,
                           TagService tagService,
                           ActionService actionService,
                           RegionService regionService) {
    this.wsService = wsService;
    this.tagService = tagService;
    this.actionService = actionService;
    this.regionService = regionService;
  }



  /*
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
  */

  @GetMapping("/websites")
  public List<WebsiteResponse> getAllWebsites(
    @RequestParam(required = false) String tag,
    @RequestParam(required = false) String region
  ) {
    return wsService.findAll(tag, region);
  }


  @GetMapping("/websites/{uniqueName}")
  public WebsiteResponse getWebsiteByName(
    @PathVariable String uniqueName
  ) throws Website2watchException {
    return wsService.findByUniqueName(uniqueName);
  }

  @PostMapping("/websites")
  public WebsiteResponse createWebsite(
    @RequestBody WebsiteRequest request
  ) throws Website2watchException {
    Website website = new Website(request);
    tagService.loadTags(website);
    actionService.loadActions(website);
    regionService.loadRegions(website);
    return wsService.save(website);
  }

  @DeleteMapping("/websites/{uniqueName}")
  public ResponseEntity<?> deleteWebsite(
    @PathVariable String uniqueName
  ) throws Website2watchException {
    wsService.deleteWebsiteByUniqueName(uniqueName, tagService, actionService, regionService);
    return ResponseEntity.noContent().build();
  }

  /*

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
*/
}
