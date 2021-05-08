package threadsexp;

/**
 * @author Naveen Bavu
 */
public class Thread2 implements Runnable {

  @Override
  public void run() {
    System.out.println("In thread 2 " + Thread.currentThread().getName());

  }
}
