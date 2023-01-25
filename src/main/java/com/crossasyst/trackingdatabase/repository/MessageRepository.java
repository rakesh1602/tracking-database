package com.crossasyst.trackingdatabase.repository;

import com.crossasyst.trackingdatabase.entity.MessageEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MessageRepository extends CrudRepository<MessageEntity, Long> {

   /* @Query(value = "select m from MessageEntity m where m.messageGuid=?1")
    Optional<MessageEntity> findByGuid(String messageGuid);*/

    MessageEntity findByMessageGuid(String messageGuid);
}
