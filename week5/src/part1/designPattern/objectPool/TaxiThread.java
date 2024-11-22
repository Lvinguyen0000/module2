package part1.designPattern.objectPool;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TaxiThread implements Runnable {
    private TaxiPool taxiPool;

    public TaxiThread(TaxiPool taxiPool) {
        this.taxiPool = taxiPool;
    }

    @Override
    public void run() {
        takeATaxi();
    }

    private void takeATaxi(){
        try{
            System.out.println("New client " + Thread.currentThread().getName());
            Taxi taxi = taxiPool.getTaxi();
            TimeUnit.MICROSECONDS.sleep(randInt(1000, 1500));
            taxiPool.release(taxi);
            System.out.println("Served client " + Thread.currentThread().getName());
        }
        catch(InterruptedException | TaxiNotFoundException e){
            System.out.println("Rejected client " + Thread.currentThread().getName());
        }
    }

    private long randInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }
}
