package View;
import java.util.*;
import Controller.LoginAndSignUp;
import Controller.Request;
import Model.AdminLogin;

public class Admin {

    public static void loginAdmin(int ui,String password)
    {

            boolean f= LoginAndSignUp.cloginA(ui,password);
            if(f)
            {
               Admin.funAdmin();
            }
            else
            {
                System.out.println("Try again");
            }
    }
    public static void funAdmin()
    {
        Scanner sc=new Scanner(System.in);
        int id;
        System.out.println("          < Employee Management Application >");
        do {
            System.out.println("____________________________________________________");
            System.out.println("|   1. Add Employee                                |");//
            System.out.println("|   2. Show All Employee                           |");
            System.out.println("|   3. Show Employee On Id                         |");
            System.out.println("|   4. Update The Employee name                    |");
            System.out.println("|   5. Delete The Employee                         |");
            System.out.println("|   6.Update the Working hours                     |");
            System.out.println("|   7.No of project done by EMP <UPDATE>           |");
            System.out.println("|   8 Update the age of the emp                    |");
            System.out.println("|   9.View the Current Stats of the Employee       |");
            System.out.println("|   10.Promotion and Demotion <CHANGE THE ROLE>    |");
            System.out.println("|   11.Show current Salary details of the Employee |");
            System.out.println("|   12.Increase the salary of Employee             |");
            System.out.println("|   13.Decrease the salary of Employee             |");
            System.out.println("|   14.Show employee contact details               |");
            System.out.println("|   15. Exit                                       |");
            System.out.println("|__________________________________________________|");
            System.out.println("| Enter the choice |");
            System.out.print(">");
            int choice = sc.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Enter the ID:");
                    id=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the Name:");
                    String name=sc.nextLine();
                    System.out.println("Enter the Salary:");
                    int salary=sc.nextInt();
                    System.out.println("Enter the Age:");
                    int age=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the Role:");
                    String role=sc.nextLine();
                    System.out.println("Enter the Phone Number:");
                    String number=sc.nextLine();
                    System.out.println("Enter the Address:");
                    String ad=sc.nextLine();
                    System.out.println("Year of Experience:");
                    int exp=sc.nextInt();
                    Request.insertEmp(id,name,salary,age,role,number,ad,exp);
                    break;
                case 2:
                    System.out.println("_____Employee Details_____");
                    Request.showAll();
                    break;
                case 3:
                    System.out.println("Enter the Employee's ID to retrieve data");
                    id=sc.nextInt();
                    Request.retrieveData(id);
                    break;
                case 4:
                    System.out.println("Enter the ID to change the Name of the Employee");
                    id=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the new name to change the exist name");
                    String newName=sc.nextLine();
                    Request.changeName(id,newName);
                    break;
                case 5:
                    System.out.println("Enter employee's Id to remove the Employee");
                    id=sc.nextInt();
                    Request.deleteEmp(id);
                    break;
                case 6:
                    System.out.print("Enter the employee ID:");
                    id=sc.nextInt();
                    System.out.print("Enter the working hours of the employee: ");
                    int hr=sc.nextInt();
                    Request.cworkhour(id,hr);
                    break;
                case 7:
                    System.out.println("Enter the ID:");
                    id=sc.nextInt();
                    System.out.println("Add no of projects");
                    int no=sc.nextInt();
                    Request.cProject(id,no);
                    break;
                case 8:
                     System.out.println("Enter the ID");
                     id=sc.nextInt();
                     System.out.println("Enter the new age to update");
                     age=sc.nextInt();
                     Request.cAge(id,age);
                     break;
                case 9:
                    System.out.println("Enter the ID Of the employee to view their stats");
                    id=sc.nextInt();
                    Request.cstats(id);
                    break;
                case 10:
                    System.out.println("Enter the ID");
                    id=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the new role of the employee");
                    role=sc.nextLine();
                    Request.cupdateRole(id,role);
                    break;
                case 11:
                    System.out.println("Enter the ID of employee for salary details");
                    id=sc.nextInt();
                    Request.csalarydetails(id);
                    break;
                case 12:
                    System.out.println("Enter the employee ID:");
                    id=sc.nextInt();
                    System.out.println("Enter the Amount to Increase");
                    salary=sc.nextInt();
                    Request.cIncDec(id,choice,salary);
                    break;
                case 13:
                    System.out.println("Enter the Employee ID:");
                    id=sc.nextInt();
                    System.out.println("Enter the Amount to Decrease");
                    salary=sc.nextInt();
                    Request.cIncDec(id,choice,salary);
                    break;
                case 14:
                    System.out.println("Enter the ID of the Employee");
                    id=sc.nextInt();
                    Request.ccontact(id);
                    break;
                case 15:
                    System.out.println("You are exited from application");
                    break;
                default:
                    System.out.println("Invalid choice");
                    System.out.println("Try again...");
            }
        }
        while(true);
    }
}
