package com.wuki.websites2watch.service;

import com.wuki.websites2watch.model.Region;
import com.wuki.websites2watch.model.Website;
import com.wuki.websites2watch.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RegionService {

  private final RegionRepository repo;

  public RegionService(RegionRepository repo) {
    this.repo = repo;
  }

  public void loadRegions(Website website) {
    Set<Region> result = new HashSet<>();
    for(Region region: website.getRegions()){
      result.add(lookupOrSave(region));
    }
    website.setRegions(result);
  }

  protected Region lookupOrSave(Region newEntity) {
    Region result = repo.findBySingleValue(newEntity.getVal());
    if (result == null)
      result = repo.save(newEntity);
    return result;
  }


}
