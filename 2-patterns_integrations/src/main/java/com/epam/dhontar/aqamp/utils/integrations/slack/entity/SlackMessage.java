package com.epam.dhontar.aqamp.utils.integrations.slack.entity;

public class SlackMessage {
    private String text;

    public SlackMessage(String text) {
        this.text = text;
    }

    public SlackMessage() {
    }

    public String getText() {
        return text;
    }
}
