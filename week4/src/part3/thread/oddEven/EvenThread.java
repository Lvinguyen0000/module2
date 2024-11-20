package part3.thread.oddEven;

import static part3.thread.oddEven.TestThread.lock;

public class EvenThread extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            synchronized (lock) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
            try{
                Thread.sleep(15);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
