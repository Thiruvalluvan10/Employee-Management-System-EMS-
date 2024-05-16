package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class empSalary {
    static Connection con;
    public static void Eworkhour(int id,int hr)
    {
        con=DBConnectionEmp.connectEmp();
        int salary=0;
        String query="select salary from employee where id=?";
        try
        {
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,id);
            ResultSet result=pstm.executeQuery();
            if(result.next())
            {
                salary=result.getInt(1);
            }
            else
            {
                System.out.println("Id not found");
                System.exit(0);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        double total=160;
        double empWorkHour=(double)hr;
        double h=100;
        double per=(empWorkHour/total)*h;
        double per1=per/100;
        double csalary=(double)(per1)*salary;
        String query1="update empsalary set csalary=? where id=?";
        String query2="update stats set whper=? where id=?";
        String query3="update empsalary set workhour=? where id=?";
        try
        {
            PreparedStatement pstm=con.prepareStatement(query1);
            PreparedStatement pstm1=con.prepareStatement(query2);
            PreparedStatement pstm2=con.prepareStatement(query3);
            pstm.setDouble(1,csalary);
            pstm.setInt(2,id);
            pstm1.setInt(1,(int)per);
            pstm1.setInt(2,id);
            pstm2.setInt(1,hr);
            pstm2.setInt(2,id);
            int val3=pstm2.executeUpdate();
            int val=pstm.executeUpdate();
            int val2=pstm1.executeUpdate();
            if(val!=0 && val2!=0 && val3!=0)
            {
                System.out.println("Emp's salary and Work hours are updated");
            }
            else
            {
                System.out.println("Enter the Proper ID");
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public static void esalarydetails(int id)
    {

        con=DBConnectionEmp.connectEmp();
        String query="select * from empsalary where id=?";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            ResultSet result=pstm.executeQuery();
            if(result.next())
            {
                System.out.println("Salary detail of Employee:");
                System.out.println("--------------------------");
                System.out.println("| ID:> "+result.getInt(1)+" |");
                System.out.println();
                System.out.println("| Total working hours:> "+result.getInt(2)+" |");
                System.out.println();
                System.out.println("| Employee's working hours:> "+result.getInt(3)+" |");
                System.out.println();
                System.out.println("| Salary based on working hours:> "+result.getInt(4)+" |");
                System.out.println();
                System.out.println("| Actual Salary of Employee:> "+result.getInt(5)+" |");
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }
    public static void eIncDec(int id,int num,int salary)
    {
        con=DBConnectionEmp.connectEmp();
        int s=0;
        String query="select asalary from empsalary where id=?";
        try
        {
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,id);
            ResultSet result=pstm.executeQuery();
            if(result.next())
            {
                s=result.getInt(1);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        if(num==13)
        {
            salary=(salary)*(-1);
        }
        s=s+salary;
        String query1="update empsalary set asalary=? where id=?";
        String query2="update stats set salary=? where id=?";
        String query3="update employee set salary=? where id=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query1);
            PreparedStatement pstm1=con.prepareStatement(query2);
            PreparedStatement pstm2=con.prepareStatement(query3);
            pstm.setInt(1,s);
            pstm.setInt(2,id);
            pstm1.setInt(1,s);
            pstm1.setInt(2,id);
            pstm2.setInt(1,s);
            pstm2.setInt(2,id);
            int c=pstm.executeUpdate();
            int c2=pstm1.executeUpdate();
            int c3=pstm2.executeUpdate();
            if(c!=0 && c2!=0 && c3!=0)
            {
                System.out.println("Salary of the Employee Updated Successfully..!");
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
