package com.wuki.websites2watch.service;

import com.wuki.websites2watch.model.Tag;
import com.wuki.websites2watch.model.Website;
import com.wuki.websites2watch.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class TagService {

  private final TagRepository repo;

  public TagService(TagRepository repo) {
    this.repo = repo;
  }

  public void loadTags(Website website) {
    Set<Tag> result = new HashSet<>();
    for(Tag tag:  website.getTags()) {
      result.add(lookupOrSave(tag));
    }
    website.setTags(result);
  }

  protected Tag lookupOrSave(Tag newEntity) {
    Tag result = repo.findBySingleValue(newEntity.getVal());
    if (result == null)
      result = repo.save(newEntity);
    return result;
  }


}
