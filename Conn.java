
package bankmanagementsystem;
import java.sql.*;
//import java.util.*;
public class Conn {
    Connection c;
    Statement s;
    Conn()
    {
        try
        {
            Class.forName(com.mysql.cj.jdbc.Driver);
            c=DriverManager.getConnection("jdbc:mysql://localhost3306:bankmanagementsystem","root","root");
            s=c.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
