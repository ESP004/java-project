
package bankmanegmentsystem;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s1;
    Conn()
    {
        
        try
        {
            //add sql deiver
            //create connection
            c = DriverManager.getConnection("jdbc:mysql:///bankmanegmentsystem","root","Gre@tmind112002");
            //create statement
            s1 = c.createStatement();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
}
