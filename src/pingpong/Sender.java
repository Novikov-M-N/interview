package pingpong;

public class Sender implements Runnable{
    private final String message;
    private final Writer locker;

    public Sender(String message, Writer locker) {
        this.message = message;
        this.locker = locker;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int delay = (int)((Math.random() * 1500) + 100);
            locker.write(message);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
