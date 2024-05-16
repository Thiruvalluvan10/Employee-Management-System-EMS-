package Controller;

import Model.AdminLogin;
import Model.EmployeeLogin;

public class LoginAndSignUp {

    public static boolean cloginA(int id,String password)
    {
        AdminLogin admin = new AdminLogin(id,password);
        boolean f=AdminLogin.excuteAdminLogin(admin.getUniqueId(),admin.getPassword());
        return f;
    }
    public static boolean csigninA(int id,String password)
    {
        AdminLogin admin=new AdminLogin(id,password);
        boolean f=AdminLogin.excuteAdminSignIn(admin.getUniqueId(),admin.getPassword());
        return f;
    }
    public static boolean cloginE(int id,String password)
    {
        EmployeeLogin emp = new EmployeeLogin(id,password);
        boolean f=EmployeeLogin.excuteEmpLogin(emp.getUniqueId(), emp.getPassword());
        return f;
    }
    public static void cpasswordch(int id,String newpass)
    {
        EmployeeLogin.epasswordch(id,newpass);
    }
}
