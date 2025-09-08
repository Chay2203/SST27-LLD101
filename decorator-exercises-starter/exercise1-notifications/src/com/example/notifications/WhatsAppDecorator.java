package com.example.notifications;

public class WhatsAppDecorator extends NotifierDecorator {
    private final String whatsappId;
    
    public WhatsAppDecorator(Notifier notifier, String whatsappId) {
        super(notifier);
        this.whatsappId = whatsappId;
    }
    
    @Override
    public void notify(String text) {
        // Send WhatsApp message first
        System.out.println("[WhatsApp -> " + whatsappId + "]: " + text);
        // Then delegate to wrapped notifier
        notifier.notify(text);
    }
}
