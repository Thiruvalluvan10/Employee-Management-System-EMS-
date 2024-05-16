package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Excute {
    static Connection con;
    public static void insertExcute(int id,String name,int salary,int age,String role,String number,String address,int exp)
    {
        con= DBConnectionEmp.connectEmp();
        String query="insert into employee values(?,?,?,?,?,?,?,?)";
        String query1="insert into authnemp values(?,?)";
        String query2="insert into empsalary values(?,?,?,?,?)";
        String query3="insert into stats values(?,?,?,?,?,?,?)";
        try
        {
            PreparedStatement pstm=con.prepareStatement(query);
            PreparedStatement pstm1=con.prepareStatement(query1);
            PreparedStatement pstm2=con.prepareStatement(query2);
            PreparedStatement pstm3=con.prepareStatement(query3);
            pstm1.setInt(1,id);
            pstm1.setString(2,"Pass");
            //************
            pstm2.setInt(1,id);
            pstm2.setInt(2,160);
            pstm2.setInt(3,0);
            pstm2.setDouble(4,0);
            pstm2.setInt(5,salary);
            //**************
            pstm3.setInt(1,id);
            pstm3.setString(2,name);
            pstm3.setInt(3,0);
            pstm3.setInt(4,salary);
            pstm3.setInt(5,exp);
            pstm3.setString(6,role);
            pstm3.setInt(7,0);
            //****************
            pstm.setInt(1,id);
            pstm.setString(2,name);
            pstm.setInt(3,salary);
            pstm.setInt(4,age);
            pstm.setString(5,role);
            pstm.setString(6,number);
            pstm.setString(7,address);
            pstm.setInt(8,exp);
            //****************************************************
            int val=pstm.executeUpdate();
            int val1=pstm1.executeUpdate();
            int val2=pstm2.executeUpdate();
            int val3=pstm3.executeUpdate();
            if(val!=0 && val2!=0 && val3!=0 && val1!=0)
            {
                System.out.println("Employee added successfully");
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public static void showAllExcute()
    {
        con=DBConnectionEmp.connectEmp();
        String query="select * from employee";
        try{
            Statement stmt=con.createStatement();
            ResultSet result=stmt.executeQuery(query);
            while(result.next())
            {
                System.out.println("| ID:> "+result.getInt(1)+" |");
                System.out.println("| Name:> "+result.getString(2)+" |");
                System.out.println("| Salary:> "+result.getInt(3)+" |");
                System.out.println("| Age:> "+result.getInt(4)+" |");
                System.out.println("| Role:> "+result.getString(5)+" |");
                System.out.println("| Number:> "+result.getString(6)+" |");
                System.out.println("| Address:> "+result.getString(7)+" |");
                System.out.println("____________________________________________________");
                System.out.println();
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public static void retrieve(int id)
    {
        con=DBConnectionEmp.connectEmp();
        String query="select * from employee where id="+id;
        try
        {
            Statement stmt=con.createStatement();
            ResultSet result=stmt.executeQuery(query);
            while(result.next())
            {
                System.out.println("| ID:> "+result.getInt(1)+" |");
                System.out.println("| Name:> "+result.getString(2)+" |");
                System.out.println("| Salary:> "+result.getInt(3)+" |");
                System.out.println("| Age:> "+result.getInt(4)+" |");
                System.out.println("| Role:> "+result.getString(5)+" |");
                System.out.println("| Number:> "+result.getString(6)+" |");
                System.out.println("| Address:> "+result.getString(7)+" |");
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public static void excuteChangeName(int id,String newName)
    {
        con=DBConnectionEmp.connectEmp();
        String query="update employee set name=? where id=?";
        String query1="update stats set name=? where id=?";
        try
        {
            PreparedStatement pstm=con.prepareStatement(query);
            PreparedStatement pstm2=con.prepareStatement(query1);
            pstm.setString(1,newName);
            pstm.setInt(2,id);
            pstm2.setString(1,newName);
            pstm2.setInt(2,id);
            int cnt=pstm.executeUpdate();
            int cnt2=pstm2.executeUpdate();
            if(cnt!=0 && cnt2!=0)
            {
                System.out.println("Employee details updated successfully");
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public static void delete(int id)
    {
        con=DBConnectionEmp.connectEmp();
        String query="delete from employee where id=?";
        String query1="delete from stats where id=?";
        String query2="delete from empsalary where id=?";
        String query3="delete from authnemp where id=?";
        try
        {
            PreparedStatement pstm=con.prepareStatement(query);
            PreparedStatement pstm1=con.prepareStatement(query1);
            PreparedStatement pstm2=con.prepareStatement(query2);
            PreparedStatement pstm3=con.prepareStatement(query3);
            pstm.setInt(1,id);
            pstm1.setInt(1,id);
            pstm2.setInt(1,id);
            pstm3.setInt(1,id);
            int cnt=pstm.executeUpdate();
            int cnt1=pstm.executeUpdate();
            int cnt2=pstm.executeUpdate();
            int cnt3=pstm.executeUpdate();
            if(cnt!=0 && cnt2!=0 && cnt3!=0 && cnt1!=0)
            {
                System.out.println("The Employee deleted successfully");
            }
            else
            {
                System.out.println("Enter the correct ID");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public static void eage(int id,int age)
    {
        con=DBConnectionEmp.connectEmp();
        String query="update employee set age=? where id=?";
        //"
        try
        {
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,age);
            pstm.setInt(2,id);
            int cnt=pstm.executeUpdate();
            if(cnt!=0)
            {
                System.out.println("Employee Age updated successfully");
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public static void eupdaterole(int id,String role)
    {
        con=DBConnectionEmp.connectEmp();
        String query="update employee set role=? where id=?";
        String query1="update stats set role=? where id=?";
        try
        {
            PreparedStatement pstm=con.prepareStatement(query);
            PreparedStatement pstm1=con.prepareStatement(query1);
            pstm.setString(1,role);
            pstm.setInt(2,id);
            pstm1.setString(1,role);
            pstm1.setInt(2,id);
            int cnt=pstm.executeUpdate();
            int cnt1=pstm1.executeUpdate();

            if(cnt!=0 && cnt1!=0)
            {
                System.out.println("Employee Role updated successfully");
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
    public static void econtact(int id)
    {

        con=DBConnectionEmp.connectEmp();
        String query="select name , number , address from employee where id=?";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            ResultSet result=pstm.executeQuery();
            if(result.next())
            {
                System.out.println("Contact detail of Employee:");
                System.out.println("--------------------------");
                System.out.println("| Name:> "+ result.getString(1)+" |");
                System.out.println();
                System.out.println("| Number:> "+result.getString(2)+" |");
                System.out.println();
                System.out.println("| Address:> "+result.getString(3)+" |");
                System.out.println();
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
