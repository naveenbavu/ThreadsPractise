package threadsexp;

/**
 * @author Naveen Bavu
 */
public class ExecutorWorkerThread implements Runnable {

  private final String message;

  public ExecutorWorkerThread(String message) {
    this.message = message;
  }


  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " (start) message " + message);
    waitTheWorkerThread();
    System.out.println(Thread.currentThread().getName() + " (end) message ");
  }

  private void waitTheWorkerThread() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
