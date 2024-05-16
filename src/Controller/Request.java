package Controller;

import Model.Employee;
import Model.Excute;
import Model.empSalary;
import Model.stats;

public class Request {

    public static void insertEmp(int id,String name,int salary,int age,String role,String number,String address,int exp)
    {
        Employee emp=new Employee();
        emp.setId(id);
        emp.setName(name);
        emp.setSalary(salary);
        emp.setAge(age);
        emp.setRole(role);
        emp.setAddress(address);
        emp.setNumber(number);
        emp.setExp(exp);
        Excute.insertExcute(emp.getId(),emp.getName(),emp.getSalary(), emp.getAge(),emp.getRole(),emp.getNumber(),emp.getAddress(), emp.getExp());
    }
    public static void showAll()
    {
        Excute.showAllExcute();
    }
    public static void retrieveData(int id)
    {
        Excute.retrieve(id);
    }
    public static void changeName(int id,String newName)
    {
        Excute.excuteChangeName(id,newName);
    }
    public static void deleteEmp(int id)
    {
        Excute.delete(id);
    }
    public static void cworkhour(int id,int hr)
    {
        empSalary.Eworkhour(id,hr);
    }
    public static void cProject(int id,int c)
    {
        stats.ecount(id,c);
    }
    public static void cAge(int id,int c)
    {
        Excute.eage(id,c);
    }
    public static void cstats(int id)
    {
        stats.retrieveStats(id);
    }
    public static void cupdateRole(int id,String role)
    {
        Excute.eupdaterole(id,role);
    }
    public static void csalarydetails(int id)
    {
        empSalary.esalarydetails(id);
    }
    public static void cIncDec(int id,int num,int salary)
    {
        empSalary.eIncDec(id,num,salary);
    }
    public static void ccontact(int id)
    {
        Excute.econtact(id);
    }
}
