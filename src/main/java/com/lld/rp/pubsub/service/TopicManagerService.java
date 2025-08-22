package com.lld.rp.pubsub.service;

import com.lld.rp.pubsub.entity.Topic;
import com.lld.rp.pubsub.exceptions.DuplicateTopicException;
import com.lld.rp.pubsub.repository.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TopicManagerService {
    private final TopicRepository topicRepository;

    public TopicManagerService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public Topic createTopic(String name) throws DuplicateTopicException {
        // Find if name is already take
        if(Objects.nonNull(getTopicByName(name)))
            throw new DuplicateTopicException();

        Topic newTopic = new Topic(name);

        // Create a new topic
        topicRepository.save(name, newTopic);
        return newTopic;
    }

    public List<Topic> getTopics() {
        return topicRepository.getTopics();
    }

    public void deleteTopic(String name) {
        ;   // TODO
    }

    public Boolean isPresent(String name) {
        if(Objects.nonNull(topicRepository.findByName(name)))
            return Boolean.TRUE;
        return Boolean.FALSE;
    }

    public Topic getTopicByName(String name) {
        return topicRepository.findByName(name);
    }
}
