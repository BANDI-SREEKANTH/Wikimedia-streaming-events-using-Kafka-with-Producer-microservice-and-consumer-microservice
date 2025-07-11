package org.campusconnect.kafkaproducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class WikimediaChangesProducer
{

    private static final Logger LOGGER= LoggerFactory.getLogger(WikimediaChangesProducer.class);
    private KafkaTemplate<String,String> kafkaTemplate;
    public WikimediaChangesProducer(KafkaTemplate<String,String> kafkaTemplate)
    {
        this.kafkaTemplate=kafkaTemplate;
    }

    public void sendMessage()
    {
        String topic="wikimedia_recent_change";
        /* Now inorder read the data from wikimedia, we need "Event Source"
        To read realtime stream data from wikimedia. we use an event source

        To use the event source, we need a couple of libraries

        Need to include the below maven dependencies in pom.xml

        https://mvnrepository.com/artifact/com.launchdarkly/okhttp-eventsource

         */

    }
}
