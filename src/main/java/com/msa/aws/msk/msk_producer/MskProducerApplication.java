package com.msa.aws.msk.msk_producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MskProducerApplication implements ApplicationRunner {
	@Autowired
	private MessageSender messageSender;

	public static void main(String[] args) {
		SpringApplication.run(MskProducerApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if (args.getSourceArgs().length > 0) {
			String message = args.getSourceArgs()[0];
			messageSender.sendMessage(message);
		} else {
			System.out.println("No message provided.");
		}
	}
}