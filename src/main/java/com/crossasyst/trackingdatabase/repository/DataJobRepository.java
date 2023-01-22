package com.crossasyst.trackingdatabase.repository;

import com.crossasyst.trackingdatabase.entity.DataJobEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataJobRepository extends CrudRepository<DataJobEntity, Long> {
}
