import counter.Counter;
import counter.Starter;
import pingpong.Sender;
import pingpong.Writer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {

        // Задание 1 - пинг-понг
        Writer writer = new Writer();
        Sender pingWriter = new Sender("ping", writer);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Sender pongWriter = new Sender("     pong", writer);

        // Задание 2 - потокобезопасный счётчик через интерфейс Lock
        Counter counter = new Counter();
        Lock lock = new ReentrantLock();
        for (int i = 0; i < 10; i++) {
            new Starter(i, counter, lock);
        }
    }
}
