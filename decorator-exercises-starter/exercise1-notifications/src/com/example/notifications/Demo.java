package com.example.notifications;

/**
 * Starter demo that uses only the existing Email notifier.
 * TODOs guide you to add decorators and compose them.
 */
public class Demo {
    public static void main(String[] args) {
        Notifier base = new EmailNotifier("user@example.com");

        // Baseline behavior (already works)
        base.notify("Baseline email only.");

        System.out.println("\n=== Email + SMS ===");
        Notifier smsAndEmail = new SmsDecorator(base, "+91-99999-11111");
        smsAndEmail.notify("Build green ✅");
        
        System.out.println("\n=== Email + WhatsApp ===");
        Notifier whatsappAndEmail = new WhatsAppDecorator(base, "user_wa");
        whatsappAndEmail.notify("Server status update 📊");
        
        System.out.println("\n=== Email + Slack ===");
        Notifier slackAndEmail = new SlackDecorator(base, "deployments");
        slackAndEmail.notify("Deployment completed 🚀");
        
        System.out.println("\n=== Email + WhatsApp + Slack ===");
        Notifier full = new SlackDecorator(new WhatsAppDecorator(base, "user_wa"), "deployments");
        full.notify("System maintenance scheduled 🔧");
    }
}
