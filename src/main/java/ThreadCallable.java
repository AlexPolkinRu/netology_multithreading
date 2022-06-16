import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @author Aleksandr Polochkin
 * 02.06.2022
 */

public class ThreadCallable implements Callable<String> {

    private final int DELAY = 2000 + new Random().nextInt(1000);
    private int counterMsg = 0;
    private final String name;

    public ThreadCallable(String name) {
        this.name = name;
    }

    @Override
    public String call() {
        Thread.currentThread().setName(name);
        try {
            while (!Thread.currentThread().isInterrupted()) {

                counterMsg++;
                System.out.println("Я " + Thread.currentThread().getName() + ". Сообщение " + counterMsg);

                Thread.sleep(DELAY);

            }
        } catch (InterruptedException e) {
            System.out.println("Выполнение задачи прервано: " + e);
        } finally {
            System.out.println(Thread.currentThread().getName() + " завершён");
        }

        return Thread.currentThread().getName() + " вывел сообщения " + counterMsg + " раз";
    }
}

