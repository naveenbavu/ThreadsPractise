package threadsexp;

/**
 * @author Naveen Bavu
 */

public class CountDown {

  public void print() {
    try {
      for (int i = 0; i < 10; i++) {
        System.out.println("-------" + i);
      }
      System.out.println("Blastoff!");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
