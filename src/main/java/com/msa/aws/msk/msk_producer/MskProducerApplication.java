package com.msa.aws.msk.msk_producer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MskProducerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MskProducerApplication.class, args);

		MessageSender messageSender = context.getBean(MessageSender.class);
		messageSender.sendMessage("Hello, Kafka!");

		// アプリケーション終了時にコンテキストを閉じる
		context.close();
	}
}