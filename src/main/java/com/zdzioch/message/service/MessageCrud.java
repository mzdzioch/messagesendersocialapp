package com.zdzioch.message.service;

import com.zdzioch.message.domain.Message;
import com.zdzioch.message.domain.MessageFactory;
import com.zdzioch.message.domain.MessageRepository;

public class MessageCrud {

    private final MessageRepository messageRepository;

    public MessageCrud(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Response createNew(MessageDTO messageDTO){
        Message message = new MessageFactory().createFrom(messageDTO);

        if (!messageRepository.exists(message)) {
            message.setId("1");
            messageRepository.add(message);

            return Response.aSuccessfulResponseWith("1");
        }

        return Response.aFailureResponse("Message already exists");
    }



}
