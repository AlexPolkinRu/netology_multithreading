/**
 * @author Aleksandr Polochkin
 * 10.06.2022
 */

public class Runner implements Runnable {

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Я " + Thread.currentThread().getName() + ". Всем привет!");

                Thread.sleep(2000);

            }
        } catch (InterruptedException e) {
            System.out.println("Выполнение потока прервано: " + e);
        } finally {
            System.out.println(Thread.currentThread().getName() + " завершён");
        }
    }
}
