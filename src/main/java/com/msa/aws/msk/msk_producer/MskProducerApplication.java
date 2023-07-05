package com.msa.aws.msk.msk_producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MskProducerApplication implements CommandLineRunner {
	@Autowired
	private MessageSender messageSender;
	public static void main(String[] args) {
		SpringApplication.run(MskProducerApplication.class, args);
	}
	public void run(String... args) {
		if (args.length > 0) {
			String message = args[0];
			messageSender.sendMessage(message);
		} else {
			System.out.println("No message provided.");
		}
	}

}
