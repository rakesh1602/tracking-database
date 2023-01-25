package com.crossasyst.trackingdatabase.repository;

import com.crossasyst.trackingdatabase.entity.ProcessingStatusTypeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProcessingStatusTypeRepository extends CrudRepository<ProcessingStatusTypeEntity, String> {

   //@Query(value = "select p from ProcessingStatusTypeEntity p Left join Fetch p.DataJobEntity where p.DataJobEntity.dataJobGUID=?1")
  @Query(value = "select a from ActivityEntity a Left join Fetch a.messageEntity where a.messageEntity.msgId=?1")
    Optional<ProcessingStatusTypeEntity> findByMsgGuid(String datajobGuid);
}
