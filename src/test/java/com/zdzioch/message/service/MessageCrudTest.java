package com.zdzioch.message.service;

import com.zdzioch.message.domain.Message;
import com.zdzioch.message.domain.MessageFactory;
import com.zdzioch.message.domain.MessageRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.any;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("file:C:\\dev\\workspace\\javakurs\\messagesendersocialapp\\src\\main\\java\\message-sender.xml")
@ContextConfiguration("/message-sender.xml")
public class MessageCrudTest {
    public static final String SUBJECT = "subject";
    public static final String BODY = "body";
    public static final String SEND_FROM = "from";
    public static final String SEND_TO = "to";
    @Autowired private MessageRepository messageRepository;
    @Autowired private MessageCrud messageCrud;

    @Test
    public void shouldCreateNewMessage() {

        MessageDTO messageDTO = getMessageDTO();
        messageDTO.setSubject(SUBJECT);
        messageDTO.setBody(BODY);
        messageDTO.setFrom(SEND_FROM);
        messageDTO.setTo(SEND_TO);

        Response response = messageCrud.createNew(messageDTO);

        Assert.assertTrue(response.isSuccess());
        Assert.assertThat(response.getMessage(), any(String.class));
        Assert.assertTrue(messageRepository.exists(response.getMessage()));
    }

    @Test
    public void shouldNotCreateNewMessage() {
        String subject = SUBJECT;
        String body = BODY;
        String from = SEND_FROM;
        String to = SEND_TO;

        MessageDTO messageDTO = getMessageDTO();
        messageDTO.setSubject(subject);
        messageDTO.setBody(body);
        messageDTO.setFrom(from);
        messageDTO.setTo(to);

        Message message = new MessageFactory().createFrom(messageDTO);

        Response response = messageCrud.createNew(messageDTO);

        Assert.assertFalse(response.isSuccess());
    }

    private MessageDTO getMessageDTO() {
        return new MessageDTO();
    }


}
