package threadsexp;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Naveen Bavu
 */
public class ExecutorServiceCallableReturn {

  public static void main(String[] args) {

    ExecutorService executorService = Executors.newFixedThreadPool(10);
//    executorService.execute(newRunnable("Task 1"));
//    executorService.execute(newRunnable("Task 2"));
//    executorService.execute(newRunnable("Task 3"));
    Future submit = executorService.submit(newCallable("Task 1"));
    if (submit.isDone()) {
      System.out.println("It's Done!");
    }
    try {
     String name =  submit.get().toString();
      System.out.println("Returned value :" + name);
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
    System.out.println("It's Done or not " + submit.isDone());
    executorService.shutdown();

  }

  private static Callable newCallable(String message) {

    return new Callable() {
      @Override
      public Object call() throws Exception {
        return "naveen";
      }
     /* @Override
      public void run() {
        System.out.println(Thread.currentThread().getName() + " :" + message);
      }*/
    };
  }
}
