package com.wuki.websites2watch.repository;

import com.wuki.websites2watch.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public interface RegionRepository extends JpaRepository<Region,Long> {

  @Query(value = "SELECT r FROM Region r where r.val = :singleValue ")
  Region findBySingleValue(String singleValue);

  //Region save(Region newEntity);

}
