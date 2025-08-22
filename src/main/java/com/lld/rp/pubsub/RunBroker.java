package com.lld.rp.pubsub;

import com.lld.rp.pubsub.entity.Message;
import com.lld.rp.pubsub.entity.Publisher;
import com.lld.rp.pubsub.entity.Subscriber;
import com.lld.rp.pubsub.entity.Topic;
import com.lld.rp.pubsub.repository.TopicRepository;
import com.lld.rp.pubsub.service.BrokerService;
import com.lld.rp.pubsub.service.TopicManagerService;

import java.util.List;
import java.util.Objects;

public class RunBroker {
    public static void main(String [] args) throws Exception {
        BrokerService brokerService = new BrokerService();
        TopicRepository topicRepository = new TopicRepository();
        TopicManagerService topicManagerService = new TopicManagerService(topicRepository);

        // Create topics
        Topic topic1 = topicManagerService.createTopic("topic1");
        Topic topic2 = topicManagerService.createTopic("topic2");
        Topic topic3 = topicManagerService.createTopic("topic3");

        // Print topic list
        List<Topic> topicList = topicManagerService.getTopics();
        topicList.stream().forEach(t -> System.out.println(t.getName()));

        // Create subscribers
        Subscriber subscriber1 = brokerService.addSubscriber("sub1", topic1);
        Subscriber subscriber2 = brokerService.addSubscriber("sub2", topic1);
        Subscriber subscriber3 = brokerService.addSubscriber("sub3", topic2);

        // Create publisher
        Publisher pub1 = new Publisher("pub1");

        // Create a message
        Message msg1 = new Message("msg1 text data", pub1.getName());

        // Push message
        System.out.println(brokerService.publishMessage(topic1, msg1));
        System.out.println("Published message");

        // Pull message once
        Message sub1msg1 = subscriber1.getTopic().getSubscriberMessage(subscriber1);
        System.out.println("Consumed message: " + sub1msg1.getData());

        // Pull message again
        Message sub1msg2 = subscriber1.getTopic().getSubscriberMessage(subscriber1);
        if(Objects.isNull(sub1msg2))
            System.out.println("No new message");
        else
            System.out.println("Wrong impl");
    }
}
