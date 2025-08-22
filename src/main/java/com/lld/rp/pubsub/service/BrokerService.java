package com.lld.rp.pubsub.service;

import com.lld.rp.pubsub.entity.Message;
import com.lld.rp.pubsub.entity.Subscriber;
import com.lld.rp.pubsub.entity.Topic;
import com.lld.rp.pubsub.exceptions.TopicIsNullException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BrokerService {

    public BrokerService() {
    }

    public Subscriber addSubscriber(String name, Topic topic) throws Exception {
        if(Objects.isNull(topic))
            throw new TopicIsNullException();

        if(name.isBlank())
            throw new Exception("subscriberName is blank");

        // Create new subscriber
        Subscriber subscriber = new Subscriber(name, topic);

        // Add subscriber name to Topic map
        topic.addSubscriber(subscriber);

        return subscriber;
    }

    public void removeSubscriber(Subscriber subscriber) {
        Topic topic = subscriber.getTopic();
        topic.removeSubscriber(subscriber);
    }

    public Boolean publishMessage(Topic topic, Message message) {
        try {
            // Add checks if publisher, topic, message validations
            // -> Publisher should have an interface

            // Append message to topic
            topic.addMessage(message);
        } catch (Exception e) {
            // Logging of exception
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }
}
