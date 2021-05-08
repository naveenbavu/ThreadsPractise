package threadsexp;

/**
 * @author Naveen Bavu
 */
public class ThreadRaceExample {

  static double a = 10;
  static double b;

  public static void main(String[] args) {

    Runnable r1 = () -> {
      if (a == 10) {
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        b = a / 2.0;
        System.out.println(Thread.currentThread().getName() + " b is : " + b);
      }
    };

    Runnable r2 = () -> a = 12;

    Thread t1 = new Thread(r1, "Thread A");
    Thread t2 = new Thread(r2, "Thread B");
    t1.start();
    t2.start();

  }

}
