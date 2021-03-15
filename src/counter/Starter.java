package counter;

import java.util.concurrent.locks.Lock;

/**
 * Класс, увеличивающий значение счётчика
 */
public class Starter implements Runnable{
    private final Counter counter;
    private final int number; // Нужно для тестирования, чтобы идентифицировать поток в консоли

    public Starter(int number, Counter counter) {
        this.number = number;
        this.counter = counter;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            counter.increment(number);
            try {
                Thread.sleep((long)(Math.random() * 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
