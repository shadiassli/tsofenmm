package DB;

import java.sql.*;
import com.mysql.jdbc.Driver;
public class MyConnection
{
	//connection to server 
   private static Connection connection;
   private final  static String DB_URL = "jdbc:mysql://libarab.crbu6i1ygais.eu-central-1.rds.amazonaws.com:3306/mmdb";
   private final  static String USER = "MasterDB";
   private final  static String PASS = "Master!!";
   /*
    * connection local
   private static Connection connection;
   private final  static String DB_URL = "jdbc:mysql://localhost:3306/mmdb";
   private final  static String USER = "root";
   private final  static String PASS = "root";*/

   
   
   public static Connection getConnection() throws SQLException
   {
       if(connection == null )
       {
           DriverManager.registerDriver(new Driver());
           connection = DriverManager.getConnection(DB_URL,USER,PASS);
           return connection;
       }
       else
       {
           return connection;
       }
   }
}