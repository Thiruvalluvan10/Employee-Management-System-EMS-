package View;

import Controller.LoginAndSignUp;
import Controller.Request;
import Model.stats;

import java.util.Scanner;

public class Emp {

    public static void loginEmp(int ui,String pass)
    {
        boolean f= LoginAndSignUp.cloginE(ui,pass);
        if(f)
        {
            Emp.funEmp();
        }
        else
        {
            System.out.println("Try again");
        }
    }
    public static void funEmp()
    {
        Scanner sc=new Scanner(System.in);

        do{
            System.out.println(" Enter you choice :");
            System.out.println("___________________");
            System.out.println("| To know your details-Press(1) |");
            System.out.println("| To know your stats detail-Press(2) |");
            System.out.println("| To Change your password-Press(3) |");
            System.out.println("| To know your current salary details-Press(4) |");
            System.out.println("| To EXIT-Press(5) |");
            int ch=sc.nextInt();
            switch (ch)
            {
                case 1:
                    System.out.println("Again enter your ID and password:");
                    System.out.print("ID: ");
                    int id=sc.nextInt();
                    sc.nextLine();
                    System.out.print("Password: ");
                    String pass=sc.nextLine();
                    if(LoginAndSignUp.cloginE(id,pass))
                    {
                        Request.retrieveData(id);
                    }
                    else
                    {
                        System.out.println("Try again");
                    }
                    break;
                case 2:
                    System.out.print("Again enter your ID and password");
                    System.out.print("ID: ");
                    id=sc.nextInt();
                    sc.nextLine();
                    System.out.print("Password: ");
                    pass=sc.nextLine();
                    if(LoginAndSignUp.cloginE(id,pass))
                    {
                        stats.retrieveStats(id);
                    }
                    else
                    {
                        System.out.println("Try again");
                    }
                    break;
                case 3:
                    System.out.println("Enter ID");
                    id=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Password");
                    pass=sc.nextLine();
                    if(LoginAndSignUp.cloginE(id,pass))
                    {
                        System.out.println("Enter the new password");
                        String newPass=sc.nextLine();
                        LoginAndSignUp.cpasswordch(id,newPass);

                    }
                    else
                    {
                        System.out.println("Try again:(");
                    }
                    break;
                case 4:
                    System.out.println("Enter ID");
                    id=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Password");
                    pass=sc.nextLine();
                    if(LoginAndSignUp.cloginE(id,pass))
                    {
                        Request.csalarydetails(id);
                    }
                    else
                    {
                        System.out.println("Try again:(");
                    }
                    break;
                case 5:
                    System.out.println("You are exited..!");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while (true);

    }
}
