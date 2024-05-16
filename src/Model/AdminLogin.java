package Model;

import Controller.LoginAndSignUp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Queue;

public class AdminLogin
{
    static Connection con;
    private int uniqueId;
    private String password;
    public AdminLogin(int uniqueId,String password)
    {
        this.uniqueId=uniqueId;
        this.password=password;
    }
    public void setUniqueId(int uniqueId)
    {
        this.uniqueId = uniqueId;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }
    public int getUniqueId()
    {
        return uniqueId;
    }
    public static boolean excuteAdminLogin(int uniqueId,String password)
    {
        con=DBConnectionEmp.connectEmp();
        String query="select password from authnadmin where uniqueid=?";
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
                } else {
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
    public static boolean excuteAdminSignIn(int id,String password)
    {

        con=DBConnectionEmp.connectEmp();
        String query="select password from authnadmin where uniqueid=?";
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
                    String query2="insert into authnadmin values(?,?)";
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
    }
}