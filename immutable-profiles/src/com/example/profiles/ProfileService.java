package com.example.profiles;

import java.util.Objects;

/**
 * Assembles profiles with consistent validation through the Builder.
 */
public class ProfileService {

    public UserProfile createMinimal(String id, String email) {
        return new UserProfile.Builder(id, email).build();
    }

    public UserProfile createFull(String id, String email,
                                  String phone,
                                  String displayName,
                                  String address,
                                  boolean marketingOptIn,
                                  String twitter,
                                  String github) {
        return new UserProfile.Builder(id, email)
                .phone(phone)
                .displayName(displayName)
                .address(address)
                .marketingOptIn(marketingOptIn)
                .twitter(twitter)
                .github(github)
                .build();
    }

    // No more mutating after creation; expose methods that return new instances if needed.
    public UserProfile withDisplayName(UserProfile p, String displayName) {
        Objects.requireNonNull(p, "profile");
        return new UserProfile.Builder(p.getId(), p.getEmail())
                .phone(p.getPhone())
                .address(p.getAddress())
                .marketingOptIn(p.isMarketingOptIn())
                .twitter(p.getTwitter())
                .github(p.getGithub())
                .displayName(displayName)
                .build();
    }
}
