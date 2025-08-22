package com.lld.rp.pubsub.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Topic {
    private String name;
    private List<Message> messages;
    private HashMap<String,Integer> subsOffset;

    public Topic(String name) {
        this.name = name;
        this.messages = new ArrayList<>();
        this.subsOffset = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void addMessage(Message message) {
        this.messages.add(message);
    }

    public void addSubscriber(Subscriber subscriber) {
        this.subsOffset.put(subscriber.getName(), 0);
    }

    public HashMap<String, Integer> getSubsOffset() {
        return this.subsOffset;
    }

    public void setSubsOffset(HashMap<String, Integer> subsOffset) {
        this.subsOffset = subsOffset;
    }

    public void removeSubscriber(Subscriber subscriber) {
        if(this.subsOffset.containsKey(subscriber.getName())) {
            subsOffset.remove(subscriber.getName());
        }
    }

    public Message getSubscriberMessage(Subscriber subscriber) {
        if(this.subsOffset.containsKey(subscriber.getName())) {
            Integer offset = this.subsOffset.get(subscriber.getName());

            if(offset < this.messages.size()) {
                Message message = this.messages.get(offset);

                // Atomic Operation to increment offset
                this.subsOffset.put(subscriber.getName(), offset+1);

                return message;
            }
            // Or can return Exception
            return null;
        }
        return null;
    }
}
