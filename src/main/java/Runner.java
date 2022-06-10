import java.util.Random;

/**
 * @author Aleksandr Polochkin
 * 10.06.2022
 */

public class Runner implements Runnable {

    private final int DELAY = 2000 + new Random().nextInt(1000);

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Я " + Thread.currentThread().getName() + ". Всем привет!");

                Thread.sleep(DELAY);

            }
        } catch (InterruptedException e) {
            System.out.println("Выполнение потока прервано: " + e);
        } finally {
            System.out.println(Thread.currentThread().getName() + " завершён");
        }
    }
}

