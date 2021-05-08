package threadsexp;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Naveen Bavu
 */
public class ExecutorServiceDeepExp1 {

  public static void main(String[] args) {

    int corePoolSize = 10;
    int maxPoolSize = 20;
    int keepAliveTime = 3000;

    ExecutorService executorService = new ThreadPoolExecutor(corePoolSize, maxPoolSize,
        keepAliveTime,
        TimeUnit.MILLISECONDS,
        new ArrayBlockingQueue<>(128));


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
