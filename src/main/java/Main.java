import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Решение multithreading_task2 в ветке task2
 *
 * @author Aleksandr Polochkin
 * 02.06.2022
 */

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Future<String>> futureTask = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            futureTask.add(executorService.submit(new ThreadCallable("Task" + i)));
        }

        Thread.sleep(15000);
        executorService.shutdownNow();

        for (Future<String> future : futureTask) {
            System.out.println(future.get());
        }

    }
}

