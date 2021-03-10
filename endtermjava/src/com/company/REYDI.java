package com.company;

//importing classes from other packages to get access
import com.company.Employee.Employee;
import com.company.Employee.EmployeeControl;
import com.company.ShipperControl.ShipperControl;
import com.company.project.ProjectControl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class REYDI {

    Scanner scan;//scanner to input
    ShipperControl control;//object of ShipperControl to use its methods
    ProjectControl pcontrol;//object of ProjectControl to use its methods
    EmployeeControl mcontrol;//object of EmployeeControl to use its methods

    public REYDI(ShipperControl control, ProjectControl pcontrol, EmployeeControl mcontrol) {
        //giving value to fields by constructor
        scan = new Scanner(System.in);//input
        this.control = control;
        this.pcontrol =  pcontrol;
        this.mcontrol = mcontrol;
    }

    public void startREYDI() {//start of application to take action (Realization of Company REYDI)
        while (true) { // while it is true loop will work
            System.out.println(); // space (user-friendly)
            System.out.println("Welcome to REYDI"); //options
            System.out.println("Select option:");
            System.out.println("1 – Create relation with Shipper");
            System.out.println("2 – Create new project");
            System.out.println("3 - Show all projects");
            System.out.println("4 – Show all relation with Shippers");
            System.out.println("5 – Employee information");
            System.out.println("6 - Hire Dates");
            System.out.println("7 – Quitting employee");
            System.out.println("8 – Specialty information");
            System.out.println("9 - Update the information about employees");
            System.out.println("0 – Goodbye");

            try {//try catch to catch exceptions
                int option = scan.nextInt(); //to input option

                if (option == 1) {//in case 1, user creates relation with Shipper
                    System.out.println(CreateRelation());
                } else if (option == 2) { //in 2 user creates Project
                    System.out.println(CreateProject()); // get order by customer
                } else if (option == 3) {//in case 3 user can see projects
                    Getprojects();
                }
                else if (option == 4) {//in case 4 user can see Relations
                    GetAllRelations();
                } else if (option == 5) {//in case 5 user can see information about employees
                    EmployeeInfo();
                }
                else if (option == 6) {//in case 6 user will see employees and their hired dates by ascending order
                    System.out.println(Hired_dates());
                } else if (option == 7) {//in case7 user can enter when employee's contract will end or fire them
                    Quit();
                }
                else if (option == 8) { //in case 8 user can see information about specialties
                    SpecialtyInfo();
                }
                else if(option == 9) {
                    UpdateInfo();
                }
                else if (option == 0){//in case 0 it close a program
                    break;
                }

            } catch (InputMismatchException e) { // option which our input must be int, if it is not, java prints this
                System.out.println("Input must be integer");
                scan.nextLine(); // to ignore incorrect input
            }
            catch (Exception e) { // if we have some errors, java prints this (does not close program)
                System.out.println(e.getMessage());
            }

        }

    }


    public String CreateRelation() {    //method to create Relation with shipper
        System.out.println("Please, enter which company you want to work with: ");
        String company = scan.next();

        boolean create = control.CreateRelation(company);//boolean method of ShipperControl that creates
        // and returns status of creation of Relation (true or false)

        //method will return message depending on relation was created(true) or not(false)
        return (create ?  "You have created successfully new Relation!" : "Relation was not created.");
    }

    public void GetAllRelations() {//method to show all relations
        System.out.println("All Shipper Relations");
        control.GetAllRelation(); //method of ShipperControl to get all relations(their information)
    }

    public String CreateProject() throws SQLException, ClassNotFoundException {//method to create Project
        // throws exceptions because uses method of ShipperControl
        // where connection to database is used

        System.out.println("Please, enter description of Project");
        scan.nextLine();//it used to be able to input a sentence (inputting end only by "enter")
        boolean create = pcontrol.CreateProject( scan.nextLine() ); //method of ProjectControl
        //creates project and returns status that created or not (true false)

        //depending on that status this method
        return (create ? "Project has been successfully created!" : "Project was not created.");
    }

    public void Getprojects() {//method to get information about projects

        System.out.println("You want to see:\n" + "1. All projects of Company / 2. Concrete project");
        int s = scan.nextInt();
        if (s == 1) //in case 1, by calling method of ProjectControl "AllPRrojects",
            // user will get information about all projects
            pcontrol.AllProjects();

        else if (s == 2) {//in case two, user will see information about concrete Project by its description
            System.out.println("Please, enter description of project");
            scan.nextLine();//to be able to input a line(sentence) not only one word
            String description = scan.nextLine();//inputting description(it can be several words)
            if (pcontrol.GetProject(description) != null) //if there is a project with such description
                System.out.println(pcontrol.GetProject(description));//then outputs return of GetProject of ProjectControl

            else //if there's not project with such description in database, then will output message about it
                System.out.println("There's no project with such description");
        }
    }



    public String Hired_dates() throws SQLException, ClassNotFoundException {
        //method to see employees and their hired dates by ascending order

        ArrayList<Employee> employees;//arraylist of Employee, because Hired_dates from EmployeeControl return arraylist
        employees = mcontrol.Hiredates();//giving value of object(arraylist) that returned
        //depending on are there employees or not this method will return string
        //if there are not employees in company, than will return about it, and if there are,
        // than will return information about employees in string
        return (employees == null ? "There are not employees in company." : employees.toString());

    }

    public void EmployeeInfo() { //method that shows information about company's employees

        System.out.println("Please, choose which information you want to know: ");
        System.out.println("1. Information about Employee. ");
        System.out.println("2. Max salary in Company");
        System.out.println("3. Max salary in specialties");
        int c = scan.nextInt(); //to input option
        if (c == 1) {//in case 1, user can see all information about employee, whose name will input
            System.out.println("Please, enter first and last name of employee");
            String first_name = scan.next();//inputting
            String last_name = scan.next();
            mcontrol.EmployeeInfo(first_name, last_name);//outputting information by method of EmployeeControl
        }
        else if( c == 2) {//in case 2 will show max salary in company instead of director
            mcontrol.MaxSalary();//method of EmployeeControl that outputs employee(s) with max salary
        }
        else if (c == 3) { //in case 3 will show max salary of concrete specialty
            System.out.println("Please, enter specialty");
            scan.nextLine();//to be able to input several words
            String specialty = scan.nextLine();//inputting specialty (it could be several words)
            mcontrol.MaxSalarySpec(specialty);//method of EmployeeControl
            // that will output employee(s) with max salary in specialty
        }
    }

    public void Quit() {//method to give end of contract of employee or fire them
        System.out.println("Please, choose option: ");
        System.out.println("1. to enter end of contract with employee");
        System.out.println("2. to fire employee");
        int c = scan.nextInt();
        if (c == 1) {//in case 1 user will enter end of contract of employee that was inputted
            System.out.println("Please, enter employee's first and last name: ");
            String first_name = scan.next();//inputting
            String last_name = scan.next();
            mcontrol.Quit_Date(first_name, last_name);//Method of EmployeeControl
            // that inserts a quit_date into database

        }
        else  if(c == 2) {//in case 2 user can fire employee
            System.out.println("Please, enter employee's first and last name: ");
            String first_name = scan.next();//inputting name
            String last_name = scan.next();
            mcontrol.Fire(first_name, last_name);//method of EmployeeControl that deletes from database employee

        }

    }

    public void SpecialtyInfo() { //method to get information about specialties

        System.out.println("Choose which specialty you want to know about?");
        mcontrol.InputSpecialty();//method of EmployeeControl where prints all specialties
        // and user chooses which one is needed
    }

    public void UpdateInfo() {
        System.out.println("Choose what you want to update:\n" +
                "1. Update the salary of all employees\n" +
                "2. Update the salary of concrete employee\n" +
                "3. Update the last name of employee\n" +
                "4. Update the gender of employee");
        int choice = scan.nextInt();
        if (choice == 1) {
            System.out.println("Please, enter the percentage by which you want to increase the salary of employees:");
            int salary = scan.nextInt();
            mcontrol.AllEmployeesSalary(salary);
        }
        else if (choice == 2) {
            System.out.println("Please, enter employee's first name and last name, whose salary you want to update:");
            String first_name = scan.next();
            String last_name = scan.next();
            System.out.println("Please, enter the salary, which you want to set:");
            int salary = scan.nextInt();
            mcontrol.UpdateSalary(salary, first_name, last_name);
        }
        else if(choice == 3) {
            System.out.println("Please, enter employee's first name and last name, whose last name you want to update:");
            String first_name = scan.next();
            String last_name = scan.next();
            System.out.println("Please, enter the last name, which you want to set:");
            String new_last_name = scan.next();
            mcontrol.UpdateLastName(first_name, last_name, new_last_name);
        }
        else if(choice == 4) {
            System.out.println("Please, enter employee's first name and last name, whose gender you want to update:");
            String first_name = scan.next();
            String last_name = scan.next();
            System.out.println("Please, enter the gender, which you want to set:");
            String new_gender = scan.next();
            mcontrol.UpdateGender(first_name, last_name, new_gender);
        }
    }

}
