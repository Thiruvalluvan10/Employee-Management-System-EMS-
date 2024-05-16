package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;

public class EmployeeLogin
{
    static Connection con;
    private int uniqueId;
    private String password;

    public EmployeeLogin(int uniqueId,String password)
    {
        this.uniqueId = uniqueId;
        this.password=password;
    }
    public int getUniqueId()
    {
        return uniqueId;
    }
    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public static boolean excuteEmpLogin(int uniqueId,String password)
    {
        con=DBConnectionEmp.connectEmp();
        String query="select password from authnemp where uniqueid=?";
        try
        {
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,uniqueId);
            ResultSet result=pstm.executeQuery();

            if(result.next())
            {

                String validate = result.getString(1);
                if (password.equals(validate)) {
                    return true;
                } else
                {
                    System.out.println("Enter the correct password");
                    return false;
                }
            }
            System.out.println("ID not found :(");
            return false;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

   /* public static boolean excuteEmpSignIn(int id,String password)
    {

        con=DBConnectionEmp.connectEmp();
        String query="select password from authnemp where uniqueid=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,id);
            ResultSet result=pstm.executeQuery();
            if(result.next())
            {
                System.out.println("You already have an account");
                return true;
            }
            else
            {
                String query2="insert into authnemp values(?,?)";
                pstm=con.prepareStatement(query2);
                pstm.setInt(1,id);
                pstm.setString(2,password);
                int val=pstm.executeUpdate();
                if(val!=0)
                {
                    System.out.println("Your user id added successfully..!");
                    return false;
                }
            }

        }
        catch (Exception ex)
        {
            ex.printStackTrace();;
        }
        return true;
    }*/
    public static void epasswordch(int id,String password)
    {
        con= DBConnectionEmp.connectEmp();
        String query="update authnemp set password=? where uniqueId=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,password);
            pstm.setInt(2,id);
            int cnt=pstm.executeUpdate();
            if(cnt!=0)
            {
                System.out.println("Password updated successfully");
            }
            else
            {
                System.out.println("Enter the proper ID");
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
