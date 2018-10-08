import java.sql.*;
import java.util.Properties;

public class connection
{
  private static final String dbClassName = "com.mysql.jdbc.Driver";

  private static final String CONNECTION =
                          "jdbc:mysql://127.0.0.1/cpremier";

  public static void main(String[] args) throws
  ClassNotFoundException,SQLException
  {
    System.out.println(dbClassName);
  
    Class.forName(dbClassName);

    Properties p = new Properties();
    p.put("user","root");
    p.put("password","12345678");

    Connection c = DriverManager.getConnection(CONNECTION,p);

    System.out.println("It works !");
    c.close();
    }
}