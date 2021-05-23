package threadsexp;

/**
 * @author Naveen Bavu
 */
public class WatiNotifyExample {

  public static void main(String[] args) throws InterruptedException {

    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        WatiNotifyProcessor obj = new WatiNotifyProcessor();
        try {
          obj.producer();
          obj.consumer();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });


    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        WatiNotifyProcessor obj = new WatiNotifyProcessor();
        try {
          obj.consumer();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    t1.start();
//    t2.start();
  }
}
