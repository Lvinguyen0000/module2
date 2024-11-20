package part3.thread.numberGenerator;

import static part3.thread.numberGenerator.Main.count;

public class NumberGenerator extends Thread{
    public static final Object lock = new Object();
    public NumberGenerator() {}

    public void run() {
        while (count <= 100) {
            synchronized (lock) {
                if (count <= 100) {
                    System.out.println(count);
                    count++;
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
