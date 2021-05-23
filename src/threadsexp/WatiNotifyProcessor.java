package threadsexp;

import java.util.Scanner;

/**
 * @author Naveen Bavu
 */
public class WatiNotifyProcessor {

  public void producer() throws InterruptedException {
    synchronized (this){
      System.out.println("Producer thread running...");
      wait();
      System.out.println("Resumed.");
    }
  }

  public void consumer() throws InterruptedException {
    Thread.sleep(2000);
    Scanner scanner = new Scanner(System.in);
    synchronized (this){
      System.out.println("Waiting for the return key");
      scanner.nextLine();
      System.out.println("Return key pressed...");
      notify();
    }
  }




}
