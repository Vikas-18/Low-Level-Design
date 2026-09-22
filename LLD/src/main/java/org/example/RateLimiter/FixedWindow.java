package org.example.RateLimiter;

import org.example.RateLimiter.Enum.Tier;

import java.util.HashMap;
import java.util.Map;

public class FixedWindow implements RateLimiterAlgoStrategy {

    private final Map<RateLimitKey, WindowState> windows = new HashMap<>();

    @Override
    public synchronized boolean allowRequest(String userId, Tier tier, int reqCount, long time) {
        if (userId == null || userId.isBlank()) {
            throw new IllegalArgumentException("User id must not be blank");
        }
        if (tier == null) {
            throw new IllegalArgumentException("Tier must not be null");
        }
        if (reqCount <= 0) {
            throw new IllegalArgumentException("Request limit must be positive");
        }
        if (time <= 0) {
            throw new IllegalArgumentException("Window duration must be positive");
        }

        long currentTime = System.currentTimeMillis();
        RateLimitKey key = new RateLimitKey(userId, tier);
        WindowState window = windows.get(key);

        // Each user and tier combination has its own fixed window.
        if (window == null || window.requestLimit != reqCount || window.windowDurationMillis != time) {
            window = new WindowState(currentTime, reqCount, time);
            windows.put(key, window);
        }

        if (currentTime - window.windowStartTime >= window.windowDurationMillis) {
            window.windowStartTime = currentTime;
            window.requestsInCurrentWindow = 0;
        }

        if (window.requestsInCurrentWindow >= window.requestLimit) {
            return false;
        }

        window.requestsInCurrentWindow++;
        return true;
    }

    private record RateLimitKey(String userId, Tier tier) {
    }

    private static class WindowState {
        private long windowStartTime;
        private final int requestLimit;
        private final long windowDurationMillis;
        private int requestsInCurrentWindow;

        private WindowState(long windowStartTime, int requestLimit, long windowDurationMillis) {
            this.windowStartTime = windowStartTime;
            this.requestLimit = requestLimit;
            this.windowDurationMillis = windowDurationMillis;
        }
    }
}
