package threadsexp;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Naveen Bavu
 */
public class ExecutorServiceRunnableImpl {

  public static void main(String[] args) {

    ExecutorService executorService = Executors.newFixedThreadPool(10);
//    executorService.execute(newRunnable("Task 1"));
//    executorService.execute(newRunnable("Task 2"));
//    executorService.execute(newRunnable("Task 3"));
    Future submit = executorService.submit(newRunnable("Task 1"));
    if (submit.isDone()) {
      System.out.println("It's Done!");
    }
    try {
      submit.get();
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
    System.out.println("It's Done or not :  " + submit.isDone());
    executorService.shutdown();

  }

  private static Runnable newRunnable(String message) {
    return new Runnable() {
      @Override
      public void run() {
        System.out.println(Thread.currentThread().getName() + " :" + message);
      }
    };
  }
}
