package com.sn.messenger.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {
    @Id
    private String id;

    private String chatId;

    private String senderId;

    private String recipientId;

    private String senderName;

    private String recipientName;

    private String content;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date updatedDate;

    private MessageStatus status;

    public static enum MessageStatus {
        RECEIVED, DELIVERED
    }
}
