package com.lld.rp.pubsub.repository;

import com.lld.rp.pubsub.entity.Subscriber;
import com.lld.rp.pubsub.entity.Topic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubscriberRepository {
    private HashMap<String, Subscriber> subscribersMap;


    public Subscriber findByName(String name) {
        if(subscribersMap.containsKey(name))
            return subscribersMap.get(name);

        return null;
    }

    public void save(String name, Subscriber newSubscriber) {
        subscribersMap.put(name, newSubscriber);
    }

    public List<Subscriber> getSubscribers() {
        List<Subscriber> subscriberObjList = new ArrayList<>();

        for (Map.Entry<String, Subscriber> entry : subscribersMap.entrySet()) {
            subscriberObjList.add(entry.getValue());
        }

        return subscriberObjList;
    }

}
