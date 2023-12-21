package employee.management.system;

import java.sql.Connection;
import java.sql.*;

public class Conn {
    Connection con;
    Statement stmt;

    public Conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeems","root","123456");
            stmt = con.createStatement();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
