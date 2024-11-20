package part3.thread.numberGenerator;

public class Main {
    public static int count = 1;

    public static void main(String[] args) throws InterruptedException {
        NumberGenerator generator1 = new NumberGenerator();
        NumberGenerator generator2 = new NumberGenerator();
        NumberGenerator generator3 = new NumberGenerator();
        NumberGenerator generator4 = new NumberGenerator();
        NumberGenerator generator5 = new NumberGenerator();
        NumberGenerator generator6 = new NumberGenerator();

        generator1.start();
        generator2.start();
        generator3.start();
        generator4.start();
        generator5.start();
        generator6.start();

        try {
            while (generator1.isAlive() || generator2.isAlive() || generator3.isAlive() || generator4.isAlive() || generator5.isAlive()) {
                Thread.sleep(1000);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End");
    }
}
