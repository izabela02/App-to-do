package pl.sda.todo.service;

import java.util.concurrent.atomic.AtomicLong;

public class IdGeneratorService {

    private static AtomicLong currentId = new AtomicLong(0);

    public static long generateId() {
        return currentId.incrementAndGet();
    }
}
