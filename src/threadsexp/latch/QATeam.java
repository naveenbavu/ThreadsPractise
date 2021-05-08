package threadsexp.latch;

import java.util.concurrent.CountDownLatch;

/**
 * @author Naveen Bavu
 */
public class QATeam extends Thread {

  public QATeam(String name) {
    super(name);
  }

  @Override
  public void run() {
    System.out.println("Task assigned to QA team : " + Thread.currentThread().getName());
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Task finished by QA team : " + Thread.currentThread().getName());

  }
}
