package com.lld.rp.pubsub.repository;

import com.lld.rp.pubsub.entity.Topic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopicRepository {
    private final HashMap<String, Topic> topicsMap;

    public TopicRepository() {
        this.topicsMap = new HashMap<>();
    }

    public Topic findByName(String name) {
        if(topicsMap.containsKey(name))
            return topicsMap.get(name);

        return null;
    }

    public void save(String name, Topic newTopic) {
        topicsMap.put(name, newTopic);
    }

    public List<Topic> getTopics() {
        List<Topic> topicsObjList = new ArrayList<>();

        for (Map.Entry<String, Topic> entry : topicsMap.entrySet()) {
            // String topicName = entry.getKey();
            // Topic topicObj = entry.getValue();
            topicsObjList.add(entry.getValue());
        }

        return topicsObjList;
    }

}
