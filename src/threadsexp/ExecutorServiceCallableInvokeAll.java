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
public class ExecutorServiceCallableInvokeAll {

  public static void main(String[] args) throws ExecutionException, InterruptedException {

    ExecutorService executorService = Executors.newFixedThreadPool(3);

    List<Callable<String>> callable = new ArrayList<>();
    callable.add(newCallable("Task 1"));
    callable.add(newCallable("Task 2"));
    callable.add(newCallable("Task 3"));
    List<Future<String>> futures = executorService.invokeAll(callable);
    for (Future future: futures
    ) {
      System.out.println(future.get() +":"+Thread.currentThread().getName());

    }
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
