package executorsexp;

import java.util.StringTokenizer;
import java.util.concurrent.Callable;

/**
 * @author Naveen Bavu
 */
public class UserProcessor implements Callable<Integer> {

  private String userRecord;
  private UserDAO userDAO;

  public UserProcessor(String userRecord, UserDAO userDAO) {
    this.userRecord = userRecord;
    this.userDAO = userDAO;
  }

  @Override
  public Integer call() throws Exception {

    int rows = 0;
    System.out.println(Thread.currentThread().getName() + "Processing record for " + userRecord);
    StringTokenizer st = new StringTokenizer(userRecord, ",");
    User user = null;
    while (st.hasMoreTokens()) {
      user = new User();
      user.setEmailAddress(st.nextToken());
      user.setName(st.nextToken());
      user.setId(Integer.valueOf(st.nextToken()));
      rows = userDAO.saveUser(user);
    }
    return rows;
  }
}
