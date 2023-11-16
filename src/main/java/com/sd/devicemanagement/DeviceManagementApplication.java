package com.sd.devicemanagement;

import com.sd.devicemanagement.dto.DeviceUpdateDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import static java.lang.Thread.sleep;

@SpringBootApplication
public class DeviceManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeviceManagementApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, DeviceUpdateDTO> kafkaTemplate) {
		return args -> {
			for (int i = 0; i < 100; i++) {
				kafkaTemplate.send("device", new DeviceUpdateDTO("vladradu", "bec", (float) 45.56));
				sleep(3000);
			}
		};
	}
}