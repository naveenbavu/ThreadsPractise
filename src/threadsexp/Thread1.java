package threadsexp;

/**
 * @author Naveen Bavu
 */
public class Thread1 extends Thread {

  @Override
  public void run() {

    System.out.println("In thread 1 "+Thread.currentThread().getName());
  }
}
