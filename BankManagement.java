import java.util.Scanner;

public class BankManagement 
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
                    User user = new User();
                    user.display();
                    break;
                // case 2:
                //     Admin admin = new Admin();
                //     admin.display();
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
                Employee emp = new Employee();
                emp.display();
                System.out.println("-------------------------------------------");
                System.out.println("Do you want to cont with Employee id (1/0)");
                c = sc.nextInt();
            }
            
            break;

            // case 2:
            // Customer cust = new Customer();
            // cust.display();
            // break;

            default:
            System.out.println("Wrong choice!");
            break;
        }
    }
}



class Employee extends User
{
    Scanner sc = new Scanner(System.in);
    int choice;
    String empName, empPwd;
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

        System.out.println("Enter customer Id : ");
        custId = sc.nextLine();

        System.out.println("\nCustomer added! with \nName : "+customerName+"\nId : "+custId);
        // displayCustomerDetails(customerName, custId);
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