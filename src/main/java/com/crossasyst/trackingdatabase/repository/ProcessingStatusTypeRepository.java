package com.crossasyst.trackingdatabase.repository;

import com.crossasyst.trackingdatabase.entity.ProcessingStatusTypeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProcessingStatusTypeRepository extends CrudRepository<ProcessingStatusTypeEntity, String> {

    /**
     * @author @Query written by - Rakesh Chavan
     */
    @Query(value = "select p from ProcessingStatusTypeEntity p join p.messageEntity m where m.dataJobGUID=?1 ")
    Optional<ProcessingStatusTypeEntity> findByDataJobGuid(String dataJobGuid);
}
