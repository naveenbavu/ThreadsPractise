package threadsexp;

/**
 * @author Naveen Bavu
 */
public class ThreadSampleJoinImpl {

  public static void main(String[] args) {
    ThreadSample t1= new ThreadSample("t1");
    ThreadSample t2= new ThreadSample("t2");
    ThreadSample t3= new ThreadSample("t3");
    t1.start();
    t2.start();

    try {
      t2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    t3.start();
  }

}
