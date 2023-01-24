package com.crossasyst.trackingdatabase.repository;

import com.crossasyst.trackingdatabase.entity.DataChannelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataChannelRepository extends CrudRepository<DataChannelEntity, String> {
}
