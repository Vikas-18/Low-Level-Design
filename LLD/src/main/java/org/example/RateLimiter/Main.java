package org.example.RateLimiter;

import org.example.RateLimiter.Enum.Tier;

public class Main {
    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter(new FixedWindow());
        User freeUser = new User("free-1", Tier.FREE, rateLimiter, 2, 1_000);
        User premiumUser = new User("premium-1", Tier.PREMIUM, rateLimiter, 5, 1_000);

        System.out.println(freeUser.allowRequest());    // true: free user's first request
        System.out.println(freeUser.allowRequest());    // true: free user's second request
        System.out.println(freeUser.allowRequest());    // false: free user's limit is exhausted
        System.out.println(premiumUser.allowRequest()); // true: premium user has a separate limit
    }
}
