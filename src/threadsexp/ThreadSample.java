package threadsexp;

/**
 * @author Naveen Bavu
 */
public class ThreadSample extends Thread {

  public ThreadSample(String name) {
    super((name));
  }

  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Thread is : " + Thread.currentThread().getName() + " i= " + i);

    }
  }


}
