package com.example.logconsumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

@Service
public class KafkaLogConsumer {

    private final RestHighLevelClient esClient;

    @Value("${elasticsearch.index}")
    private String index;

    public KafkaLogConsumer(RestHighLevelClient esClient) {
        this.esClient = esClient;
    }

    @KafkaListener(topics = "${kafka.topic}", groupId = "${kafka.group-id}")
    public void consume(ConsumerRecord<String, String> record) {
        String log = record.value();
        IndexRequest request = new IndexRequest(index).source(log, XContentType.JSON);
        try {
            esClient.index(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}