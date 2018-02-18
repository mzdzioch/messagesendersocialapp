package com.zdzioch.message.repository.inmemory;

import com.zdzioch.message.domain.MessageRepository;
import com.zdzioch.message.service.MessageCrud;
import com.zdzioch.message.service.MessageDTO;
import com.zdzioch.message.service.Response;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/message-sender.xml", "/fake-message.xml"})

public class InMemoryMessageRepositoryTest {
    public static final String SEND_FROM = "me";
    public static final String SEND_TO = "somewhere";
    public static final String BODY_TEXT = "text of body";
    public static final String SUBJECT_M2 = "any text";
    public static final String BODY_M2 = "body of message";
    public static final String SEND_TO_M2 = "google";
    public static final String SEND_FROM_M2 = "misiek";
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private MessageCrud messageCrud;

    @Test
    public void shouldNotCreateMessage1(){


        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setSubject("some subject");
        messageDTO.setBody("some body");
        messageDTO.setFrom("zdzioch");
        messageDTO.setTo("javakrk5");

        Response response = messageCrud.createNew(messageDTO);

        Assert.assertFalse(response.isSuccess());
    }

    @Test
    public void shouldNotCreateMessage2(){
        String subject = SUBJECT_M2;
        String body = BODY_M2;
        String to = SEND_TO_M2;
        String from = SEND_FROM_M2;

        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setSubject(subject);
        messageDTO.setBody(body);
        messageDTO.setFrom(from);
        messageDTO.setTo(to);

        Response response = messageCrud.createNew(messageDTO);

        Assert.assertFalse(response.isSuccess());
    }

    @Test
    public void shouldNotCreateMessage3(){
        String subject = "subject";
        String body = BODY_TEXT;
        String to = SEND_TO;
        String from = SEND_FROM;

        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setSubject(subject);
        messageDTO.setBody(body);
        messageDTO.setFrom(from);
        messageDTO.setTo(to);

        Response response = messageCrud.createNew(messageDTO);

        Assert.assertFalse(response.isSuccess());
    }

    @Test
    public void shouldCreateMessage(){
        String subject = "subjec";
        String body = BODY_TEXT;
        String to = SEND_TO;
        String from = SEND_FROM;

        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setSubject(subject);
        messageDTO.setBody(body);
        messageDTO.setFrom(from);
        messageDTO.setTo(to);

        Response response = messageCrud.createNew(messageDTO);

        Assert.assertTrue(response.isSuccess());

    }


    //        messageRepository.add(new Message.MessageBuilder()
//        .withSubject(subject)
//        .withBody(body)
//        .build());

}