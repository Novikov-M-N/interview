package pingpong;

public class Writer {
    private String message = "";

    public synchronized void write(String message) {
        while (message.equals(this.message)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.message = message;
        System.out.println(message);
        notify();
    }
}
