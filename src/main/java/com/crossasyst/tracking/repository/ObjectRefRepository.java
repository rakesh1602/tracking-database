package com.crossasyst.tracking.repository;

import com.crossasyst.tracking.entity.ObjectRefEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectRefRepository extends CrudRepository<ObjectRefEntity, Long> {
}
