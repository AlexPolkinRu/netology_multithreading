/**
 * @author Aleksandr Polochkin
 * 10.06.2022
 */

public class Main {
    public static void main(String[] args) {

        final int DELAY = 15_000;

        long startTime = System.currentTimeMillis();

        ThreadGroup mainGroup = new ThreadGroup("main group");

        final Thread thread1 = new Thread(mainGroup, new Runner(), "Поток1");
        final Thread thread2 = new Thread(mainGroup, new Runner(), "Поток2");
        final Thread thread3 = new Thread(mainGroup, new SomeThread(), "Поток3");
        final Thread thread4 = new Thread(mainGroup, new SomeThread(), "Поток4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            mainGroup.interrupt();
        }

    }
}
