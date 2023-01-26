package com.crossasyst.trackingdatabase.repository;

import com.crossasyst.trackingdatabase.entity.ProcessingStatusTypeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.Optional;

@Repository
public interface ProcessingStatusTypeRepository extends CrudRepository<ProcessingStatusTypeEntity, String> {


    //@Query(value = "select a from ActivityEntity a Left join Fetch a.messageEntity where a.messageEntity.msgId=?1")
   // @Query(value = "select a from ProcessingStatusTypeEntity a Left join fetch a.messageEntity where a.messageEntity.dataJobGuid=?1")
    @Query(value = "select p from ProcessingStatusTypeEntity p join p.messageEntity m where m.dataJobGUID=?1 ")
    Optional<ProcessingStatusTypeEntity> findByDataJobGuid(String dataJobGuid);
}
