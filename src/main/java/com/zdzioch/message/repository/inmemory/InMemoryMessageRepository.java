package com.zdzioch.message.repository.inmemory;
import com.zdzioch.message.domain.Message;
import com.zdzioch.message.domain.MessageRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryMessageRepository implements MessageRepository{

    private final List<Message> messages;

    public InMemoryMessageRepository() {
        this(new ArrayList<>());
    }

    public InMemoryMessageRepository(List<Message> messages) {
        this.messages = messages;
    }

    public boolean exists(String id) {
        return messages
                .stream()
                .anyMatch(message -> message.hasSameId(id));
    }

    public void add(Message message) {
        messages.add(message);
    }

    public boolean exists(Message message) {
        return messages.contains(message);
    }
}
