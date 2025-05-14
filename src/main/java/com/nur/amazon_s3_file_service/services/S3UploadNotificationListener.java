package com.nur.amazon_s3_file_service.services;

import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class S3UploadNotificationListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(S3UploadNotificationListener.class);

    public static final String QUEUE_NAME = "My-test-queue";

    //public record S3UploadEvent(String fileKey, String bucketName) {}

    @SqsListener(QUEUE_NAME)  // or the queue ARN
    public void listen(String message) {
        LOGGER.info("Received SQS message: {}", message);

        try {
            // Best practice: Handle business logic inside try-catch
            // You can deserialize if needed, e.g., with Jackson
            // ObjectMapper.readValue(message, YourDTO.class);

            // Example: parse message and store to DB, or trigger another service
        } catch (Exception e) {
            LOGGER.error("Error processing message: {}", message, e);
            // Optionally send to dead-letter queue or alerting
        }
    }
}

