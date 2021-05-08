package threadsexp;

/**
 * @author Naveen Bavu
 */
public class ThreadRaceIssue {

  public static int counter = 1;

  public static void main(String[] args) {

    Runnable r1 = () -> System.out.println("Id values is : " + getId());

    Thread t1 = new Thread(r1, "TA");
    Thread t2 = new Thread(r1, "TB");
    t1.start();
    t2.start();

  }

  private synchronized static int getId() {

    return counter++;
  }

}
