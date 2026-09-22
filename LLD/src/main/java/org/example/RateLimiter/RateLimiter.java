package org.example.RateLimiter;

public class RateLimiter {
    private final RateLimiterAlgoStrategy rateLimiterAlgoStrategy;

    public RateLimiter(RateLimiterAlgoStrategy rateLimiterAlgoStrategy) {
        if (rateLimiterAlgoStrategy == null) {
            throw new IllegalArgumentException("Rate limiter strategy must not be null");
        }
        this.rateLimiterAlgoStrategy = rateLimiterAlgoStrategy;
    }

    public boolean allowRequest(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User must not be null");
        }
        return rateLimiterAlgoStrategy.allowRequest(
                user.getId(), user.getTier(), user.getReqCount(), user.getTime());
    }
}
