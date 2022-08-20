package com.example.mystore.repository;

import com.example.mystore.model.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity,Long> {

    Set<MessageEntity> findBySenderIdAndReceiverId(Long senderId, Long receiverId);

    void deleteByProductId(Long id);
}
