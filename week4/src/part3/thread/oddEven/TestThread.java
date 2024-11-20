package part3.thread.oddEven;

public class TestThread {
    public static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        OddThread oddThread = new OddThread();
        EvenThread evenThread = new EvenThread();

        oddThread.start();
        oddThread.join();
        evenThread.start();
    }
}
