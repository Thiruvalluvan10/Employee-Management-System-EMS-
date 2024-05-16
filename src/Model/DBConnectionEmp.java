package Model;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionEmp {
    static Connection cnt;
    public static Connection connectEmp()
    {
        try
        {
            String url="jdbc:mysql://localhost:3306/emp";
            String username="root";
            String password="";
            cnt= DriverManager.getConnection(url,username,password);

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return cnt;
    }
}