package com.crossasyst.trackingdatabase.repository;

import com.crossasyst.trackingdatabase.entity.ActivityEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActivityRepository extends CrudRepository<ActivityEntity, Integer> {

    /**
     * @author @Query written by - Rakesh Chavan
     */
    @Query(value = "select a from ActivityEntity a Left join Fetch a.messageEntity where a.messageEntity.msgId=?1")
    Optional<ActivityEntity> findByMessageId(Long messageId);
}
