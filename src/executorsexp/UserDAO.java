package executorsexp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Naveen Bavu
 */
public class UserDAO {

  public int saveUser(User user) throws SQLException, ClassNotFoundException {

    int rows = 0;
    Connection connection = DBConnection.getConnection();
    PreparedStatement ps = connection.prepareStatement("insert into user values(?,?,?)");
    ps.setInt(1, user.getId());
    ps.setString(2, user.getName());
    ps.setString(3, user.getEmailAddress());
    rows = ps.executeUpdate();
    System.out.println("Inserted rows : " + rows);
    return rows;
  }

}
