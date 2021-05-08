package threadsexp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Naveen Bavu
 */
public class ExecutorServiceCallableInvokeAny {

  public static void main(String[] args) throws ExecutionException, InterruptedException {

    ExecutorService executorService = Executors.newFixedThreadPool(3);

    List<Callable<String>> callable = new ArrayList<>();
    callable.add(newCallable("Task 1"));
    callable.add(newCallable("Task 2"));
    callable.add(newCallable("Task 3"));

    String s = executorService.invokeAny(callable);
    System.out.println("Callable result is :" + s);
    executorService.shutdown();
  }

  private static Callable newCallable(String message) {
    return new Callable() {
      @Override
      public Object call() throws Exception {
        return "naveen :" + Thread.currentThread().getName();
      }
    };
  }
}
