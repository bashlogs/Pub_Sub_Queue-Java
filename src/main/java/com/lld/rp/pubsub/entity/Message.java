package com.lld.rp.pubsub.entity;

public class Message {
    private String data;
    private String publisherName;

    public Message(String data, String publisherName) {
        this.data = data;
        this.publisherName = publisherName;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }
}
