package threadsexp.latch;

import java.util.concurrent.CountDownLatch;

/**
 * @author Naveen Bavu
 */
public class Worker extends Thread {

  private final CountDownLatch start;
  private final CountDownLatch end;

  public Worker(CountDownLatch start, CountDownLatch end) {
    this.start = start;
    this.end = end;
  }

  @Override
  public void run() {

    try {
      printInfo("Thread enter run");
      start.await();
      printInfo(" doing work");
      Thread.sleep(3000);
      end.countDown();
    } catch (InterruptedException e) {
      System.err.println(e);
    }
  }

  void printInfo(String s) {
    System.out
        .println(System.currentTimeMillis() + " :" + Thread.currentThread().getName() + " :" + s);
  }
}
