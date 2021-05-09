package threadsexp.latch;

import java.util.concurrent.CountDownLatch;

/**
 * @author Naveen Bavu
 */
public class WorkerLatch {

  public static void main(String[] args) {
    CountDownLatch start = new CountDownLatch(1);
    CountDownLatch end = new CountDownLatch(4);
    for (int i = 0; i < 5; i++) {
      new Thread(new Worker(start, end)).start();
      try {
        System.out.println("Main thread doing something");
        Thread.sleep(1000);
        start.countDown();
        System.out.println("main thread diong something else");
        end.await();
      } catch (InterruptedException e) {
        System.err.println(e) ;
      }
    }
  }

}
