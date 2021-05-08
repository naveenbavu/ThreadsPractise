package threadsexp;

/**
 * @author Naveen Bavu
 */
public class Thread_1_2 {

  public static void main(String[] args) {
    Thread one = new Thread1();
    one.start();

    Thread two = new Thread(new Thread2());
    two.start();

    Runnable r1 = new Runnable() {
      @Override
      public void run() {
        System.out.println("Without Lambda " + Thread.currentThread().getName());
      }
    };

    Runnable r2 = () -> System.out.println("Hello from Lambda" + Thread.currentThread().getName());

    Thread t2 = new Thread((r2));
    t2.start();

    Thread t1 = new Thread(r1, "Thread t1");
    t1.start();

  }

}
