package com.example.mystore.service;

import com.example.mystore.model.binding.MessageBindingModel;
import com.example.mystore.model.entity.MessageEntity;
import com.example.mystore.model.view.messages.MessageChatViewModel;
import java.util.Set;

public interface MessageService {

    MessageEntity addInDb(MessageEntity message);

    MessageEntity createAndSave(MessageBindingModel messageBindingModel, Long productId, Long receiverId, Long currentUserId);

    Set<MessageEntity> getMessageBySenderAndReceiver(Long senderId, Long receiverId);

    void deleteByProductId(Long id);

    Set<MessageChatViewModel> findChatsMessagesByProductIdSenderIdReceiverId(Long productId, Long senderId, Long currentUsedId);
}
