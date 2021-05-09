package executorsexp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Naveen Bavu
 */
public class DBConnection {

  public static Connection getConnection() throws ClassNotFoundException, SQLException {
    Connection connection = null;
    Class.forName("com.mysql.jdbc.Driver");
    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
    return connection;
  }

}
