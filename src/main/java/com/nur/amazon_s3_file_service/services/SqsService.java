package com.nur.amazon_s3_file_service.services;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SqsService {

    @Value("${aws.sqs.queue-name}")
    private String queueName;

    @Autowired
    private SqsTemplate sqsTemplate;

    public void sendMessage(String message) {
        sqsTemplate.send(sqsSendOptions -> sqsSendOptions
                .queue(queueName)
                .payload(message)
        );
    }
}

