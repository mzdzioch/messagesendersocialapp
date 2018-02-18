package com.zdzioch.message.repository.inmemory;

import com.zdzioch.message.domain.Message;
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

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/message-sender.xml")

public class InMemoryMessageRepositoryTest {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private MessageCrud messageCrud;

    @Test
    public void shouldNotCreateMessage1(){
        String subject = "some subject";
        String body = "some body";
        String to = "javakrk5";
        String from  = "zdzioch";

        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setSubject(subject);
        messageDTO.setBody(body);
        messageDTO.setFrom(from);
        messageDTO.setTo(to);

        Response response = messageCrud.createNew(messageDTO);

        Assert.assertFalse(response.isSuccess());
    }

    @Test
    public void shouldNotCreateMessage2(){
        String subject = "any text";
        String body = "body of message";
        String to = "google";
        String from = "misiek";

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
        String body = "text of body";
        String to = "somewhere";
        String from = "me";

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
        String body = "text of body";
        String to = "somewhere";
        String from = "me";

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