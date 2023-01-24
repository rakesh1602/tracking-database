package com.crossasyst.trackingdatabase.repository;

import com.crossasyst.trackingdatabase.entity.ActivityEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends CrudRepository<ActivityEntity, Integer> {
}
