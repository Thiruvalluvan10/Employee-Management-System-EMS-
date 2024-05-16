package Model;

public class Employee {
    private int id;
    private String name;
    private String role;
    private int salary;
    private int age;
    private String number;
    private String address;
    private int exp;
    public Employee()
    {

    }
    public Employee(int id,String name,String role,int salary,int age, String number,String address,int exp)
    {
        this.id=id;
        this.name=name;
        this.salary=salary;
        this.age=age;
        this.number=number;
        this.address=address;
        this.exp=exp;
        this.role=role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddress()
    {
        return address;
    }
    public int getExp()
    {
        return exp;
    }
    public void setExp(int exp)
    {
        this.exp = exp;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary)
    {
        this.salary = salary;
    }

    public String display() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", number='" + number + '\'' +
                ", address='" + address + '\'' +
                ", exp=" + exp +
                '}';
    }
}
