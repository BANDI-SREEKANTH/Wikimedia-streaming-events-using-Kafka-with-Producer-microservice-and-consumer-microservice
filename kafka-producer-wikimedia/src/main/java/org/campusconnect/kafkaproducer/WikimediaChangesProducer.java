package org.campusconnect.kafkaproducer;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class WikimediaChangesProducer
{

    private static final Logger LOGGER= LoggerFactory.getLogger(WikimediaChangesProducer.class);
    private KafkaTemplate<String,String> kafkaTemplate;
    public WikimediaChangesProducer(KafkaTemplate<String,String> kafkaTemplate)
    {
        this.kafkaTemplate=kafkaTemplate;
    }

    public void sendMessage() throws InterruptedException {
        String topic="wikimedia_recent_change";
        /* Now inorder read the data from wikimedia, we need "Event Source"
        To read realtime stream data from wikimedia. we use an event source

        To use the event source, we need a couple of libraries

        Need to include the below maven dependencies in pom.xml

        https://mvnrepository.com/artifact/com.launchdarkly/okhttp-eventsource

         */
        // to read real time stream data from wikimedia, using an event source
        EventHandler eventHandler=new WikimediaChangesHandler(kafkaTemplate,topic);
        String wikimediaUrl="https://stream.wikimedia.org/v2/stream/recentchange";

        //now need to create eventsource that will connect to a wikimedia source that will read the data
        EventSource.Builder builder=new EventSource.Builder(eventHandler, URI.create(wikimediaUrl));

        EventSource eventSource=builder.build();
        eventSource.start();
        TimeUnit.MINUTES.sleep(10);

    }
}
