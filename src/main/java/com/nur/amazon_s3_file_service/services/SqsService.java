package com.nur.amazon_s3_file_service.services;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SqsService {

    public static final String QUEUE_NAME = "My-test-queue";

    @Autowired
    private SqsTemplate sqsTemplate;

    public void sendMessage(String message) {
        sqsTemplate.send(sqsSendOptions -> sqsSendOptions
                .queue(QUEUE_NAME)
                .payload(message)
        );
    }
}

