package com.slack.app.controller;

import org.springframework.web.bind.annotation.*;

import com.slack.app.model.SlackMessage;
import com.slack.app.service.SlackService;

@RestController
@RequestMapping("/api/slack")
public class SlackController {

    private final SlackService slackService;

    public SlackController(SlackService slackService) {
        this.slackService = slackService;
    }

    @PostMapping
    public void sendMessage(@RequestBody SlackMessage slackMessage) {
        slackService.sendMessageToSlack(slackMessage);
    }

}
