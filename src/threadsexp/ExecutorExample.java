package threadsexp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Naveen Bavu
 */
public class ExecutorExample {

  public static void main(String[] args) {

    ExecutorService executorService = Executors.newFixedThreadPool(5);
    for(int i=0;i<10;i++){
      Runnable worker = new ExecutorWorkerThread("I am Thread "+i);
      executorService.execute(worker);
    }
    executorService.shutdown();
    while ((!executorService.isTerminated())){

    }
    System.out.println("finished all threads!!");

  }



}
