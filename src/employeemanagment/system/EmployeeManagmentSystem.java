
package employeemanagment.system;

import java.util.*;

class Employee{
    private int empno;
    private String ename;
    private int salary;

    Employee (int empno, String ename, int salary){
        this.empno = empno;
        this.ename = ename;                           //  whenever we call this constructor we initialize
        this.salary = salary;                         // these variable.
    }

    public int getEmpno(){
        return empno;
    }    // to print employee number.
    public int getSalary(){
        return salary;
    }  // to print salary.
    public String getEname(){return ename;}    // to print employee name.

    // whenever we print Employee, we print employee number, name, salary.
    public String toString(){
        return empno+ " || " + ename + " || " + salary;
    }
}
// class for displaying the menu and executing the code.
class MANAGEMENT {
    public static void main(String[] args) {
        System.out.println("----- Welcome to Employee Management application! -----\n");
        List<Employee> c = new ArrayList<Employee>();
        Scanner s = new Scanner(System.in);         // this scanner is used for integers
        Scanner s1 = new Scanner(System.in);        // this scanner is used for Strings
        int ch;  // choice variable

        do {

            System.out.println("-----------------------Main Menu-----------------------");
            System.out.println("- Please select a number from the options available !\n");
            System.out.println("1 - To add a new Employee.");   // Create
            System.out.println("2 - To list all Employees.");  // Read
            System.out.println("3 - To delete an Employee.");   // Delete
            System.out.println("4 - To update Employee's info.");   // Update
            System.out.println("5 - to exit!");  // exit
            ch = s.nextInt();


            switch (ch){

                case 1:
                    System.out.print("Enter employee number: ");
                    int eno = s.nextInt();

                    System.out.print("Enter employee's name: ");
                    String ename = s1.nextLine();

                    System.out.print("Enter employee's salary: ");
                    int salary = s.nextInt();

                    c.add(new Employee (eno,ename,salary));   // adding the data collected from user

                    System.out.println("New employee added successfully!");
                break;
                case 2:
                    System.out.println("-----------------------------------");
                    System.out.println("List of all Employees: ");
                    Iterator<Employee> i = c.iterator();

                    while (i.hasNext()){
                        Employee e = i.next();
                        System.out.println(e);
                    }
                break;

                case 3:
                    boolean found = false;
                    System.out.print("Please enter number of the employee you want to remove: ");
                    int empno = s.nextInt();
                    System.out.println("-----------------------------------");
                    i = c.iterator();
                    while (i.hasNext()){
                        Employee e = i.next();
                        if (e.getEmpno() == empno){
                            i.remove();
                            found = true;
                        }
                    }

                    if (!found){
                        System.out.println("Sorry, we cant find any employee with this number!");
                    }else {
                        System.out.println("Employee was deleted successfully! ");
                    }
                    System.out.println("----------------------------");
                    break;
                case 4:
                    found = false;
                    System.out.print("Please enter number of the employee you want to update: ");
                    empno = s.nextInt();

                    ListIterator<Employee>li = c.listIterator();
                    while (li.hasNext()){
                        Employee e = li.next();
                        if (e.getEmpno() == empno){
                            System.out.print("Enter a new name: ");
                            ename = s1.nextLine();

                            System.out.print("Enter a new salary: ");
                            salary = s.nextInt();

                            li.set(new Employee(empno,ename,salary));
                            found = true;
                        }
                    }

                    if (!found){
                        System.out.println("Sorry, we cant find any employee with this number!");
                    }else {
                        System.out.println("Employee was updated successfully! ");
                    }
                    System.out.println("----------------------------");
                    break;
                case 5:
                    System.out.println("---- Good bye! ----");
                    return;
            }
        }
        while (true);
    }
}