package com.example.notifications;

public class SlackDecorator extends NotifierDecorator {
    private final String channel;
    
    public SlackDecorator(Notifier notifier, String channel) {
        super(notifier);
        this.channel = channel;
    }
    
    @Override
    public void notify(String text) {
        // Send Slack message first
        System.out.println("[Slack -> #" + channel + "]: " + text);
        // Then delegate to wrapped notifier
        notifier.notify(text);
    }
}
