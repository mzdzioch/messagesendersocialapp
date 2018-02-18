package com.zdzioch.message.domain;

import com.zdzioch.message.service.MessageDTO;

public class MessageFatory {
    public Message createFrom(MessageDTO messageDTO) {
        return new Message.MessageBuilder()
                .withBody(messageDTO.getBody())
                .withSubject(messageDTO.getSubject())
                .withFrom(messageDTO.getFrom())
                .withTo(messageDTO.getTo())
                .build();
    }
}
