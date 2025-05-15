package com.nur.amazon_s3_file_service.services;

import io.awspring.cloud.sns.core.SnsTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SnsService {

    private final SnsTemplate snsTemplate;

    @Value("${aws.sns.topic-arn}")
    private String topicArn;

    public SnsService(SnsTemplate snsTemplate) {
        this.snsTemplate = snsTemplate;
    }

    public void publishNotification(String message) {
        snsTemplate.sendNotification(topicArn, message, "File Upload Notification");
    }
}
