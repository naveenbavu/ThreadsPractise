package threadsexp.latch;

import java.util.concurrent.CountDownLatch;

/**
 * @author Naveen Bavu
 */
public class DevTeam extends Thread {

  private CountDownLatch countDownLatch;

  public DevTeam(CountDownLatch countDownLatch, String name) {
    super(name);
    this.countDownLatch = countDownLatch;
  }

  @Override
  public void run() {
    System.out.println("Task assigned to dev team : " + Thread.currentThread().getName());
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Task finished by dev team : " + Thread.currentThread().getName());
    countDownLatch.countDown();

  }
}
