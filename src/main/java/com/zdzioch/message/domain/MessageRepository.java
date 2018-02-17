package com.zdzioch.message.domain;

public interface MessageRepository {

    boolean exists(String id);

    void add(Message message);

    boolean exists(Message message);
}
