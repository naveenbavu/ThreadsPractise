package executorsexp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Naveen Bavu
 */
public class TestExecutors {

  public static void main(String[] args) throws ExecutionException, InterruptedException {

   /* File file = new File("/Users/nbavu/Documents/mavenprojects/javasamples/mtb/new_users.txt");
    try {
      Scanner scanner = new Scanner(file);
      System.out.println(scanner.nextLine());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }*/

    ExecutorService executorService = Executors.newSingleThreadExecutor();
    List<String> users = getUsersFromFile(
        "/Users/nbavu/Documents/mavenprojects/javasamples/mtb/src/executorsexp/files/new_users.txt");
    UserDAO userDAO = new UserDAO();
    for (String user : users) {
      Future<Integer> future = executorService.submit(new UserProcessor(user, userDAO));
      System.out.println("Result of the operation is :" + future.get());
    }
    executorService.shutdown();
    System.out.println("Main execution over!!!");
  }


  public static List<String> getUsersFromFile(String fileName) {

    List<String> users = new ArrayList<>();

      try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
        System.out.println("---1");
        String line = null;
        while ((line = reader.readLine()) != null) {
          System.out.println("---2");
          users.add(line);
          // System.out.println(Thread.currentThread().getName() + " reading the line: " + line);
          System.out.println("---3");
        }
      } catch (FileNotFoundException ex) {
        Logger.getLogger(TestExecutors.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex) {
        Logger.getLogger(TestExecutors.class.getName()).log(Level.SEVERE, null, ex);
      }
    return users;
  }

}
