package org.example.RateLimiter;

import org.example.RateLimiter.Enum.Tier;

public class User {
    private final String id;
    private final Tier tier;
    private final RateLimiter rateLimiter;
    private final int reqCount;
    private final long time;

    public User(String id, Tier tier, RateLimiter rateLimiter, int reqCount, long time) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("User id must not be blank");
        }
        if (tier == null || rateLimiter == null) {
            throw new IllegalArgumentException("Tier and rate limiter must not be null");
        }
        this.id = id;
        this.tier = tier;
        this.rateLimiter = rateLimiter;
        this.reqCount = reqCount;
        this.time = time;
    }

    public boolean allowRequest() {
        return rateLimiter.allowRequest(this);
    }

    public String getId() {
        return id;
    }

    public Tier getTier() {
        return tier;
    }

    public int getReqCount() {
        return reqCount;
    }

    public long getTime() {
        return time;
    }
}
