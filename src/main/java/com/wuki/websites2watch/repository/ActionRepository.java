package com.wuki.websites2watch.repository;

import com.wuki.websites2watch.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public interface ActionRepository extends JpaRepository<Action,Long> {

  @Query(value = "SELECT a FROM Action a where a.val = :singleValue ")
  Action findBySingleValue(String singleValue);

  //Action save(Action newEntity);

}
