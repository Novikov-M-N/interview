package counter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter{
    private Integer counter = 0;
    private Lock lock = new ReentrantLock();

    public void increment(int number) { // Выводит в консоль номер потока и значение счётчика для теста
        lock.lock();
        counter++;
        System.out.println(number + " - " + counter);
        lock.unlock();
    }
}
