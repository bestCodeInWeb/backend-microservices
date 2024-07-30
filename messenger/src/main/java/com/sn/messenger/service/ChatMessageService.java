package com.sn.messenger.service;

import com.sn.messenger.entity.ChatMessage;
import com.sn.messenger.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.sn.messenger.entity.ChatMessage.MessageStatus.DELIVERED;
import static com.sn.messenger.entity.ChatMessage.MessageStatus.RECEIVED;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ChatMessageService {
    private final ChatMessageRepository repository;
    private final ChatRoomService chatRoomService;
    private final MongoOperations mongoOperations;

    public ChatMessage save(ChatMessage chatMessage) {
        chatMessage.setStatus(RECEIVED);
        repository.save(chatMessage);
        return chatMessage;
    }

    public long countNewMessages(String senderId, String recipientId) {
        return repository.countBySenderIdAndRecipientIdAndStatus(senderId, recipientId, RECEIVED);
    }

    public List<ChatMessage> findChatMessages(String senderId, String recipientId) {
        var chatId = chatRoomService.getChatId(senderId, recipientId, false);

        var messages = chatId.map(repository::findByChatId).orElse(new ArrayList<>());

        if(messages.size() > 0) {
            updateStatuses(senderId, recipientId, DELIVERED);
        }

        return messages;
    }

    public ChatMessage findById(String id) {
        return repository
            .findById(id)
            .map(chatMessage -> {
                chatMessage.setStatus(DELIVERED);
                return repository.save(chatMessage);
            })
            .orElseThrow(() ->
//                new ResourceNotFoundException("can't find message (" + id + ")"));
                new RuntimeException("can't find message (" + id + ")"));
    }

    public void updateStatuses(String senderId, String recipientId, ChatMessage.MessageStatus status) {
        Query query = new Query(
            Criteria
                .where("senderId").is(senderId)
                .and("recipientId").is(recipientId));
        Update update = Update.update("status", status);
        mongoOperations.updateMulti(query, update, ChatMessage.class);
    }
}
