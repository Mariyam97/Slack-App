package com.slack.app.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.slack.app.model.SlackMessage;

@Service
public class SlackService {

    private final RestTemplate restTemplate;
    private final String slackWebhookUrl;

    public SlackService(RestTemplate restTemplate, @Value("${slack.webhook.url}") String slackWebhookUrl) {
        this.restTemplate = restTemplate;
        this.slackWebhookUrl = slackWebhookUrl;
    }

    public void sendMessageToSlack(SlackMessage slackMessage) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<SlackMessage> request = new HttpEntity<>(slackMessage, headers);

        restTemplate.postForEntity(slackWebhookUrl, request, String.class);
    }
}
