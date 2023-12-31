package com.sd.devicemanagement.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic deviceTopic() {
        return TopicBuilder.name("device")
                .build();
    }

    @Bean
    public NewTopic deleteDeviceTopic() {
        return TopicBuilder.name("deleteDevice")
                .build();
    }
}