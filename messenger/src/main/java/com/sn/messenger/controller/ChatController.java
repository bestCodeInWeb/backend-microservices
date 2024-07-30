package com.sn.messenger.controller;

import com.sn.messenger.dto.ChatNotification;
import com.sn.messenger.entity.ChatMessage;
import com.sn.messenger.service.ChatMessageService;
import com.sn.messenger.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;
    private final ChatMessageService chatMessageService;
    private final ChatRoomService chatRoomService;

    @MessageMapping("/chat")
    public void processMessage(@Payload ChatMessage chatMessage) {
        var chatId = chatRoomService.getChatId(chatMessage.getSenderId(), chatMessage.getRecipientId(), true);
        chatMessage.setChatId(chatId.get());

        ChatMessage saved = chatMessageService.save(chatMessage);

        messagingTemplate.convertAndSendToUser(
            chatMessage.getRecipientId(), "/queue/messages",
            new ChatNotification(
                saved.getId(),
                saved.getSenderId(),
                saved.getSenderName()
            )
        );
    }
}
