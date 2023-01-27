package com.crossasyst.tracking.repository;

import com.crossasyst.tracking.entity.MessageEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessageRepository extends CrudRepository<MessageEntity, Long> {

    Optional<MessageEntity> findByMessageGuid(String messageGuid);
}
