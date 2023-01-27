package com.crossasyst.trackingdatabase.repository;

import com.crossasyst.trackingdatabase.entity.DataJobEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DataJobRepository extends CrudRepository<DataJobEntity, Long> {

    /**
     * @author @Query written by - Rakesh Chavan
     */
    @Query(value = "select d from DataJobEntity d where d.dataJobGUID=?1")
    Optional<DataJobEntity> findByDataJobGuid(String dataJobGuid);
}
