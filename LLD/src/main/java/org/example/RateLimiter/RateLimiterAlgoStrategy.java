package org.example.RateLimiter;

import org.example.RateLimiter.Enum.Tier;

public interface RateLimiterAlgoStrategy {
    /**
     * Returns whether one request may proceed.
     *
     * @param userId identifier of the user making the request
     * @param tier tier associated with the user
     * @param reqCount maximum requests allowed for this user and tier in a window; must be positive
     * @param time window duration in milliseconds; must be positive
     */
    boolean allowRequest(String userId, Tier tier, int reqCount, long time);
}
