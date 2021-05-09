package threadsexp;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author Naveen Bavu
 */
class Customer {

  private String name;

  public Customer(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

public class GCCheck {

  public static void main(String[] args) {
    ArrayList<Customer> customers = new ArrayList<>();
    while (true) {
      Customer c = new Customer("Naveen");
      if (customers.size() > 100) {
        for (int i = 0; i < 10; i++) {
          customers.remove(0);
        }
      }
    }
  }
}
