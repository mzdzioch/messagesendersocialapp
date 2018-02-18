package com.zdzioch.message.domain;

import com.zdzioch.message.service.MessageDTO;

public class MessageFactory {
    public Message createFrom(MessageDTO messageDTO) {
        return new Message.MessageBuilder()
                .withBody(messageDTO.getBody())
                .withSubject(messageDTO.getSubject())
                .withFrom(messageDTO.getFrom())
                .withTo(messageDTO.getTo())
                .build();
    }

    public Message createFrom(MessageDTO messageDTO, String id) {
        return new Message.MessageBuilder()
                .withBody(messageDTO.getBody())
                .withSubject(messageDTO.getSubject())
                .withFrom(messageDTO.getFrom())
                .withTo(messageDTO.getTo())
                .withId(id)
                .build();
    }
}
