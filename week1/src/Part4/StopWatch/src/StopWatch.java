package Part4.StopWatch.src;

public class StopWatch {
    private long startTime, stopTime;

    public StopWatch(){
        this.startTime = System.currentTimeMillis();
        this.stopTime = System.currentTimeMillis();
    }

    public void start(){this.startTime = System.currentTimeMillis();}
    public void stop(){this.stopTime = System.currentTimeMillis();}

    public long getElapsedTime() {
        return this.stopTime - this.startTime;
    }
}
