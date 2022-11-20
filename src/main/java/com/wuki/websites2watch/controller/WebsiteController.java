package com.wuki.websites2watch.controller;

import com.wuki.websites2watch.model.WebsiteResponse;
import com.wuki.websites2watch.repository.WebsiteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class WebsiteController {

  private WebsiteRepository websiteRepo = new WebsiteRepository();

  @GetMapping("/websites")
  public List<WebsiteResponse> getAllWebsites(
          @RequestParam(required = false) String tag,
          @RequestParam(required = false) String region
  ) {
    return websiteRepo.findAll(tag, region);
  }
}
