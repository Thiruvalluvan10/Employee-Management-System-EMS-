package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class stats {

    static Connection con;
    public static void ecount(int id,int c)
    {
        con=DBConnectionEmp.connectEmp();
        String query="update stats set project=? where id=?";
        try
        {
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,c);
            pstm.setInt(2,id);
            int val=pstm.executeUpdate();
            if(val!=0)
            {
                System.out.println("Project count added successfully");
            }
           else
            {
                System.out.println("Enter the proper id");
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public static void retrieveStats(int id)
    {
        con=DBConnectionEmp.connectEmp();
        String query="select * from stats where id="+id;
        try
        {
            Statement stmt=con.createStatement();
            ResultSet result=stmt.executeQuery(query);
            while(result.next())
            {
                System.out.println("ID:> "+result.getInt(1)+" |");
                System.out.println("Name:> "+result.getString(2)+" |");
                System.out.println("No of projects worked:> "+result.getInt(3)+" |");
                System.out.println("Salary:> "+result.getInt(4)+" |");
                System.out.println("Year of Exp:> "+result.getInt(5)+" |");
                System.out.println("Role:> "+result.getString(6));
                System.out.println("Working hour percentage:> "+result.getInt(7)+" |");
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
