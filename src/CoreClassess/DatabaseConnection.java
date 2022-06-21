
package CoreClassess;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class DatabaseConnection {
public Connection con;
    public DatabaseConnection() {
        String url = "jdbc:mysql://localhost:3306/dental_clinic";
      try {
            Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(url, "root","root");
      }
       
      catch(Exception e)
      {
          JOptionPane.showMessageDialog(null,"Failed to connect to Database "+e.getMessage());
      }
    }
  
    
}
