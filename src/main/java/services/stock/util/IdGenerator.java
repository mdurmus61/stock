package services.stock.util;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
    private int prefix;

    private final AtomicLong discriminator;
    private final Object lock;
    private final AtomicLong lastTimeMillis;

    public IdGenerator(int prefix) {
        this.lock = new Object();
        this.discriminator = new AtomicLong(0);
        this.lastTimeMillis = new AtomicLong(System.currentTimeMillis());
        this.prefix = prefix;
    }

    public String generateUUID() {
        return UUID.randomUUID().toString();
    }

    public String generateIdempotencyKey() {
        return generateUUID();
    }

    public long get() {
        return this.getLong();
    }

    public long getLong() {
        return Long.valueOf(get(""));
    }

    public String getString() {
        return get("-");
    }

    private String get(String separator) {
        synchronized (lock) {
            long now = System.currentTimeMillis();
            if (now > lastTimeMillis.get()) {
                lastTimeMillis.set(now);
                discriminator.set(0);
            }
            return this.prefix + separator + this.lastTimeMillis.get() + separator
                    + String.format("%04d", this.discriminator.incrementAndGet());
        }
    }
}
