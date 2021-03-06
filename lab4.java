import java.util.Scanner;

public class Lab3 
{
    public static void main(String args[])
    {
        int choice, cont = 1;
        Scanner sc = new Scanner(System.in);
        while(cont == 1)
        {
            System.out.println("Press\n1.\tUser\n2.\tAdmin\nEnter your choice : ");
            choice = sc.nextInt();

            switch(choice)
            {
                case 1:
                    //multiple object of one type
                    User user1 = new User(),user2 = new User();
                    //array of objects
                    User users[] = new User[3];
                    User users[0] = new User()
                    user1.display();
                    
                    break;
                // case 2:
                //     Admin admin1 = new Admin();
                //     Admin admin2 = admin1;
                //     admin1.display();
                //     break;
                default:
                    System.out.println("Wrong choice!");
                    break;

            }

            System.out.println("Do you want to cont?(1/0)");
            cont = sc.nextInt();
        }

    }
}


class User
{
    Scanner sc = new Scanner(System.in);
    void display()
    {
        int choice;
        // Scanner sc = new Scanner(System.in);
        // System.out.println("This is display class for user");
        System.out.println("\n-----------------------------------------------------------------------------\n");
        System.out.println("Press \n1.\tEmployee\n2.\tCustomer");
        choice = sc.nextInt();
        switch(choice)
        {
            case 1:
            int c =1 ;
            while(c ==1 )
            {
                //reference object
                Employee emp = new Employee();
                //anonymous object
                new Employee().display();
                // emp.display();
                //anonymous class
                Employee emp1 = new Employee("Priya","1234"){
                    public void display(){
                        System.out.println("Employee name : "+emp1.empName);
                        System.out.println("Employee password : "+emp1.empPwd);
                    }
                }
                emp1.display();
                System.out.println("-------------------------------------------");
                System.out.println("Do you want to cont with Employee id (1/0)");
                c = sc.nextInt();
                System.out.println("Do you want to open account?(y/n) : ");
                String ch = sc.nextLine();
                if(ch == "y"){
                    User.openAccount();
                }
            }
            
            break;

            case 2:
            // Customer cust = new Customer();
            // cust.display();
                System.out.println("Do you want to open account?(y/n) : ");
                String ch = sc.nextLine();
                if(ch == "y"){
                    User.openAccount();
                }
            break;

            default:
            System.out.println("Wrong choice!");
            break;
        }
    }

    static void openAccount(){
        System.out.println("\nEnter name : ");
        String user = sc.nextLine();
        System.out.println("\nEnter date of birth : ");
        String dob = sc.nextLine();
        System.out.println("\nEnter pancard number : ");
        String pan = sc.nextLine();
        System.out.println("\nEnter aadhar card number : ");
        String aadhar = sc.nextLine();
        System.out.println("\nEnter address : ");
        String address = sc.nextLine();
        System.out.println(user+", your account has been created.");
    }
}



class Employee extends User
{
    //ststic variable
    static int uniqEmpId;
    Scanner sc = new Scanner(System.in);
    int choice,empId;
    String empName, empPwd;

    static{
        uniqEmpId=1;
    }

    //constructor overloading
    Employee(){}

    Employee(String name,String pswd){
        this.empId = uniqEmpId++;
        this.empName = name;
        this.empPwd = pswd;
    }

    void display()
    {
        System.out.println("Enter your name : ");
        empName = sc.nextLine();

        System.out.println("Enter your password : ");
        empPwd = sc.nextLine();

        // System.out.println(empName + " "+ empPwd);
        verify(empName, empPwd);
    }



    void verify(String name, String pwd)
    {
        System.out.println(name + " "+pwd);
        if(name.equals("employee") && pwd.equals("emp123"))
        {
            System.out.println("Verified employee "+name);
            System.out.println("--------------------Access granted!-------------------------------\n");
            System.out.println("\n1.\tAdd customer\n2.\tSearch customer\nEnter choice : ");
            choice = sc.nextInt();
            if(choice == 1)
            {
                addCustomer();
            }

            else if(choice == 2)
            {
                String uname, id;
                sc.nextLine();
                System.out.println("Enter name : ");
                uname = sc.nextLine();

                System.out.println("Enter id: ");
                id = sc.nextLine();

                displayCustomerDetails(uname, id);

            }
            else
            {
                System.out.println("Wrong choice!");
            }
            
        }
        else
        {
            System.out.println("Not verified yet!");
        }
    }

    void addCustomer()
    {
        String customerName, custId;

        sc.nextLine();
        System.out.println("Enter customer Name : ");
        customerName = sc.nextLine();
        this.empName = customerName;

        System.out.println("Enter customer Id : ");
        custId = sc.nextLine();
        this.empId = custId;

        System.out.println("\nCustomer added! with \nName : "+customerName+"\nId : "+custId);
        // displayCustomerDetails(customerName, custId);
    }

    void changeCustomer(String name,int id){
        this.empName = name;
        this.empId = id;
        System.out.println("Name and id updated");
    }

    void changeCustomer(String name){
        this.empName = name;
        System.out.println("Name updated");
    }

    void changeCustomer(int id){
        this.empId = id;
        System.out.println("Id updated");
    }


    void displayCustomerDetails(String name, String id)
    {
        String address = "", phoneNum;
        if(name.equals("customer1") && id.equals("1"))
        {
            System.out.println("Person found!");
            name = "Priya Gupta";
            phoneNum = "9068661548";
            address = "Delhi";
            System.out.println("Name : "+name+"\nId : "+id+"\nAddress : "+address+"\nContact : "+phoneNum);
        }
        else
        {
            System.out.println("Person not found with : ");
            System.out.println("Name : "+name+"\nId :"+id);
        }
    }

}