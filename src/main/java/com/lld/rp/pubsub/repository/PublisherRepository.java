package com.lld.rp.pubsub.repository;

import com.lld.rp.pubsub.entity.Publisher;
import com.lld.rp.pubsub.entity.Subscriber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PublisherRepository {
    private HashMap<String, Publisher> publishersMap;


    public Publisher findByName(String name) {
        if(publishersMap.containsKey(name))
            return publishersMap.get(name);

        return null;
    }

    public void save(String name, Publisher newPublisher) {
        publishersMap.put(name, newPublisher);
    }

    public List<Publisher> getSubscribers() {
        List<Publisher> publisherObjList = new ArrayList<>();

        for (Map.Entry<String, Publisher> entry : publishersMap.entrySet()) {
            publisherObjList.add(entry.getValue());
        }

        return publisherObjList;
    }

}
