package threadsexp;

/**
 * @author Naveen Bavu
 */
public class SynchronnizedBlockExp {

  public static void main(String[] args) {

    CountDown countDown = new CountDown();

    Runnable r1 = () ->{
      synchronized (countDown) {
        countDown.print();
      }
    };


    Thread one = new Thread(r1,"one");
    Thread two = new Thread(r1,"two");
    one.start();
    two.start();

  }

}
