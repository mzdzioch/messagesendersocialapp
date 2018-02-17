package com.zdzioch.message.repository.inmemory;

import com.zdzioch.message.domain.Message;
import com.zdzioch.message.domain.MessageRepository;
import com.zdzioch.message.service.MessageCrud;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class InMemoryMessageRepositoryTest {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private MessageCrud messageCrud;

    @Test
    public void shouldContainMessage(){
        Message message = new Message("some subject", "some body");





    }



}