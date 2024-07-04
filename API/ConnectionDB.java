
package API;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionDB {
    
    Connection connection;
    
    public void connectionToDb()
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            this.connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system" ,"Douha2022");
            System.out.println("connexion to DB ok");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
    

    
}
