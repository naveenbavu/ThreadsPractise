package threadsexp;

/**
 * @author Naveen Bavu
 */
public class WaitAndNotify {

  public static void main(String[] args) {

    ThreadB threadB = new ThreadB();
    threadB.start();
    synchronized (threadB){
      try {
        System.out.println("Waiting for second thread to complete");
     //   threadB.wait(3000);

      }catch (Exception e){
        e.printStackTrace();
      }
      System.out.println("Total is : "+ threadB.total);
    }

  }

}

class ThreadB extends Thread{
  int total;
  @Override
  public void run() {
    synchronized (this){
      for(int i=0;i<100;i++){
        total += i;
      }
      notify();
    }
  }
}
