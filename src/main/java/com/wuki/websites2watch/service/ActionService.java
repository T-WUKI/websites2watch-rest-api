package com.wuki.websites2watch.service;

import com.wuki.websites2watch.model.Action;
import com.wuki.websites2watch.model.Website;
import com.wuki.websites2watch.repository.ActionRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ActionService {

  private final ActionRepository repo;

  public ActionService(ActionRepository repo) {
    this.repo = repo;
  }

  public void loadActions(Website website) {
    Set<Action> result = new HashSet<>();
    for(Action action: website.getActions()){
      result.add(lookupOrSave(action));
    }
    website.setActions(result);
  }

  protected Action lookupOrSave(Action newEntity) {
    Action result = repo.findBySingleValue(newEntity.getVal());
    if (result == null)
      result = repo.save(newEntity);
    return result;
  }

  public void deleteActions(Website website) {
    for (Action action : website.getActions()) {
      if (action.getSites().size() == 1) {
        repo.delete(action);
      }
      else {
        action.getSites().remove(website);
      }
    }
  }


}
