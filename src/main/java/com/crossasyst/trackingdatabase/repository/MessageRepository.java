package com.crossasyst.trackingdatabase.repository;

import com.crossasyst.trackingdatabase.entity.MessageEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessageRepository extends CrudRepository<MessageEntity, Long> {

    Optional<MessageEntity> findByMessageGuid(String messageGuid);
}
