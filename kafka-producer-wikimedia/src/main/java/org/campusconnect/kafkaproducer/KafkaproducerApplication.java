package org.campusconnect.kafkaproducer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaproducerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(KafkaproducerApplication.class, args);
	}

	private WikimediaChangesProducer wikimediaChangesProducer;

	@Override
	public void run(String... args) throws Exception
	{
		wikimediaChangesProducer.sendMessage();
	}
}
