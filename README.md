<img src="https://github.com/user-attachments/assets/66e6548c-887d-4c39-a85a-1b7e5c40c61d" width="200px">


## Pub-Sub Queue


### Requirements

1. API to expose topics
   - print list of all topics
2. API for publisher to push message against a topic
3. API to subscribe and unsubscribe from a topic
4. API for subscriber to consume from a topic
5. Maintain the state of consumption of each message in each topic for each consumer
6. Maintain order of message consumption for each consumer


### Entities

#### Message

- String data
- String publisherId

#### Subscriber

- Reads from a Topic
- Can subscribe to single topic
- name
- topic -> Topic or null
- consume()

#### Publisher

- publishes to a Topic
- can publish to multiple topics
- name
- publish(Message, Topic)

#### Topic

- name
- List of Messages
- Map of Subscribers vs offset


### Services

#### TopicService
- createTopic(name)
- getTopics()
- deleteTopic()
  - Fail if messages are pending to be consumed
- isPresent() -> checks if topic is present or not
- getTopicByName()

#### BrokerService

- addSubscriber(Subscriber, Topic)
- removeSubscriber(Subscriber)
- publishMessage(Message, Publisher, Topic)
- consumeMessage(Subscriber)


--------


#### Improvements which were suggested:

1. Create separate Services for Publisher and Subscriber
2. This implementation is Push and Pull, think of Publish and Subscribe
