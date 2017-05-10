import java.util.concurrent.*;

public class TestDriver {
    public static void main(String args[]) throws Exception {
        System.out.println("Hello world");

        Runnable helloRunnable = new Runnable() {
            public void run() {
                System.out.println("Hello world");
            }
        };


        Runnable helloRunnable1 = new Runnable() {
            public void run() {
                System.out.println("Hello world1");
            }
        };


        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(helloRunnable, 0, 3, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(helloRunnable1, 0, 3, TimeUnit.SECONDS);
    }
}