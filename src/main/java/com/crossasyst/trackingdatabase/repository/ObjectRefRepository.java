package com.crossasyst.trackingdatabase.repository;

import com.crossasyst.trackingdatabase.entity.ObjectRefEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectRefRepository extends CrudRepository<ObjectRefEntity, Long> {
}
