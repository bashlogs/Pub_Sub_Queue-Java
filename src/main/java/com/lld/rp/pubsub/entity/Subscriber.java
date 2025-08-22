package com.lld.rp.pubsub.entity;


public class Subscriber {
    private String name;
    private Topic topic;

    public Subscriber(String name, Topic topic) {
        this.name = name;
        this.topic = topic;
    }

    public Topic getTopic() {
        return this.topic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
