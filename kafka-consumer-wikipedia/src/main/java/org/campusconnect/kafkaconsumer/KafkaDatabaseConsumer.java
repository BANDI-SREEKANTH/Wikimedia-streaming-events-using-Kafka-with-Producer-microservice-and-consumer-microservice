package org.campusconnect.kafkaconsumer;

import org.campusconnect.kafkaconsumer.entity.WikimediaData;
import org.campusconnect.kafkaconsumer.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {
    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private WikimediaDataRepository dataRepository;
    public KafkaDatabaseConsumer(WikimediaDataRepository dataRepository)
    {
        this.dataRepository=dataRepository;
    }
    @KafkaListener(topics = "wikimedia_recent_change",groupId = "myGroup")
    public void consume(String eventMessage)
    {
        LOGGER.info(String.format("Event Message received -> %s",eventMessage));
        WikimediaData wikimediaData=new WikimediaData();
        wikimediaData.setWikimediaEvent(eventMessage);
        dataRepository.save(wikimediaData);
    }
}
