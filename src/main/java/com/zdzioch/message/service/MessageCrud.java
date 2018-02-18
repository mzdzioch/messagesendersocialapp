package com.zdzioch.message.service;

import com.zdzioch.message.domain.Message;
import com.zdzioch.message.domain.MessageRepository;

public class MessageCrud {

    private final MessageRepository messageRepository;

    public MessageCrud(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Response createNew(MessageDTO messageDTO){
        Message message = new Message.MessageBuilder()
                .withBody(messageDTO.getBody())
                .withSubject(messageDTO.getSubject())
                .withFrom(messageDTO.getFrom())
                .withTo(messageDTO.getTo())
                .build();

        if (!messageRepository.exists(message)) {
            message.setId("1");
            messageRepository.add(message);

            return Response.aSuccessfulResponseWith("1");
        }

        return Response.aFailureResponse("Message already exists");
    }

}
