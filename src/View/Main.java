package View;
import Controller.Request;
import Model.Employee;
import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int num;
        do {
            System.out.println(" _____________________");
            System.out.println("|  <Select the Role>  |");
            System.out.println("|_____________________|");
            System.out.println("|       Admin:1       |");
            System.out.println("|      Employee:2     |");
            System.out.println("|_____________________|");
            int ch=sc.nextInt();
           switch (ch)
           {
//*****************************************************|   ADMIN  login |**************************************************************************************
               case 1:
                      do{

                          System.out.println("<|   Admin   |>");
                          System.out.println();
                          System.out.println("    Login:1");
                          int ch1=sc.nextInt();
                          switch (ch1)
                          {
                              case 1:

                                      System.out.println("Enter the ID");
                                      int ui=sc.nextInt();
                                      sc.nextLine();
                                      System.out.println("Enter the password");
                                      String password=sc.nextLine();
                                      Admin.loginAdmin(ui,password);
                                  break;
                              default:
                                  System.out.println("Don't enter any other inputs");
                          }
                      }while (true);
//***********************************************| EMPLOYEE login and signup |************************************************************************
               case 2:
                    do
                    {
                        System.out.println("<|   Employee   |>");
                        System.out.println();
                        System.out.println("     Login:1");
                        int ch2=sc.nextInt();
                        switch (ch2)
                        {
                            case 1:
                                System.out.println("Enter the ID:");
                                int ui=sc.nextInt();
                                sc.nextLine();
                                System.out.println("Enter the password");
                                String password=sc.nextLine();
                                Emp.loginEmp(ui,password); // SubView:(emp)-> Controller:LoginAndSignUp ->Model:Employee->retrun con->retrun to sub view(emp)--->Main
                                break;
                            default:
                                System.out.println("Don't enter any other inputs");
                        }
                    } while (true);
//****************************************************************************************************************************************
           }

        }while(true);
    }
}