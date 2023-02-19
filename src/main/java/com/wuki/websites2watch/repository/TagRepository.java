package com.wuki.websites2watch.repository;

import com.wuki.websites2watch.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public interface TagRepository extends JpaRepository<Tag,Long> {

  @Query(value = "SELECT t FROM Tag t where t.val = :singleValue ")
  Tag findBySingleValue(String singleValue);

  //Tag save(Tag newEntity);


}
