package com.company.project;

//importing from packages classes and interfaces to get access
import com.company.Employee.Department.Administration;
import com.company.Employee.Department.DepartmentOfReleaseAndAnalysis;
import com.company.Employee.Department.Media;
import com.company.Employee.Department.TechnicalManagement;
import com.company.Employee.Employee;
import com.company.Employee.specialty.*;
import com.company.database.IDB;

import java.sql.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class ProjectControl { //class that controls all actions with project
    private IDB db;//way to database
    private Scanner scan;//scanner to input
    public ProjectControl(IDB db) {//giving values
        this.db = db;
        scan = new Scanner(System.in);
    }

    //method to create Project with its description that is entered by user, throws exceptions
    public boolean CreateProject(String discription) throws SQLException, ClassNotFoundException {
        Connection con = db.getConnection();//getting connection to database
        System.out.println();
        System.out.println("Please, choose employees that will work with project: ");
        ArrayList<Employee> employees = new ArrayList<>();//arraylist of employees
        System.out.println("    Do you need employees from media department for project? (y/n)");
        String c = scan.next();//user's answer,
        if (c.equals("yes") || c.equals("y") || c.equals("Yes") || c.equals("Y")) {//if yes
            System.out.println("Choose by id:");
            String sel = "select * from employee where specialty = 'Producer' and busy = 0 or specialty = 'Editor' and busy = 0 or specialty = 'Decorator' and busy = 0\n" +
                    "or specialty = 'Grafic designer' and busy = 0 or specialty = 'Video maker' and busy = 0 or specialty = 'Projectionist' and busy = 0 \n" +
                    "or specialty = 'Head producer' and busy = 0 or specialty = 'Head Editor' and busy = 0;";
            //query to select employees from Media department and which are not busy (doesn't work on any project)
            Statement st = con.createStatement();//statement to execute query
            ResultSet rs = st.executeQuery(sel);//execution of query / selection
            while (rs.next()) {
                //while there are fields with values outputs employees
                System.out.println("Employee " + rs.getInt("employee_id") + " " +
                        rs.getString("first_name") + " " + rs.getString("last_name") +
                        " " + rs.getString("specialty") );
            }
            int ID = scan.nextInt();//inputting ID of employee
            while (ID != 0)  {//while user doesn't input 0
                int cnt = 0;//it's used to check if user inputted correct id
                String emp = "select employee_id from employee where specialty = 'Producer' and busy = 0 or specialty = 'Editor' and busy = 0 or specialty = 'Decorator' and busy = 0\n" +
                        "or specialty = 'Grafic designer' and busy = 0 or specialty = 'Video maker' and busy = 0 or specialty = 'Projectionist' and busy = 0 \n" +
                        "or specialty = 'Head producer' and busy = 0 or specialty = 'Head Editor' and busy = 0;";
                //query to select employee's id from Media department and which are not busy (doesn't work on any project)
                Statement emps = con.createStatement();//statement to execute query
                ResultSet empr = emps.executeQuery(emp);//execution of query / selection
                while(empr.next()) {//while there are fields with values
                    if (ID == empr.getInt("employee_id")) { //if inputted id equals to any employee id
                        Media media = new HeadProducer(ID);//it is saved in object of head specialty of department
                        employees.add((Employee) media);//and adding to arraylist with casting
                        cnt++;//cnt increases so that shows that id is correct
                    }
                }
                if (cnt == 0)//if id is not correct cnt doesn't increase and prints about it
                    System.out.println("Please, text right id of employee: ");

                ID = scan.nextInt();//to input id again
            }
        }
        System.out.println("    Do you need employees from technical department?(y/n)");
        c = scan.next();//answer
        if (c.equals("yes") || c.equals("y") || c.equals("Yes") || c.equals("Y")) {//if yes
            System.out.println("Choose by id:");
            String sel = "SELECT * FROM employee where specialty = 'Lead engineer' and busy = 0 or specialty = 'Energy-engineer' and busy = 0\n" +
                    "or specialty = 'Engineer of repairing' and busy = 0 or specialty = 'Engineer for service equipment' and busy = 0\n" +
                    "or specialty = 'System-engineer' and busy = 0 or specialty = 'Video engineer' and busy = 0;";
            //query to select employees from technical department and which don't work on any project
            Statement st = con.createStatement();//statement to execute
            ResultSet rs = st.executeQuery(sel);//execution of query /selection
            while (rs.next()) {//while there are fields with values outputs employees
                System.out.println("Employee " + rs.getInt("employee_id") + " " +
                        rs.getString("first_name") + " " + rs.getString("last_name") +
                        " " + rs.getString("specialty") );
            }
            int ID = scan.nextInt();//inputting ID
            while (ID != 0)  {//while user does not input 0
                int cnt = 0;//to check correctness of id
                String emp = "SELECT employee_id FROM employee where specialty = 'Lead engineer' and busy = 0 or specialty = 'Energy-engineer' and busy = 0\n" +
                        "or specialty = 'Engineer of repairing' and busy = 0 or specialty = 'Engineer for service equipment' and busy = 0\n" +
                        "or specialty = 'System-engineer' and busy = 0 or specialty = 'Video engineer' and busy = 0;";
                //query to select employees' id from technical department and which don't work on any project
                Statement emps = con.createStatement();//statement to execute
                ResultSet empr = emps.executeQuery(emp);//execution of query / select
                while(empr.next()) {//while there are fields with values
                    if (ID == empr.getInt("employee_id") ) {//if inputted id equals to any employee id
                        TechnicalManagement engineer = new HeadEngineer(ID);//saving id in head specialty of department
                        employees.add((Employee)engineer);//adding it in arraylist with casting
                        cnt++;//increases to show that id is correct
                    }
                }
                if (cnt == 0)//if id is not correct prints about it
                    System.out.println("Please, text right id of employee: ");
                ID = scan.nextInt();// to input id again
            }
        }
        System.out.println("    Do you need employees of Department of Release and Analysis?(y/n)");
        c = scan.next();//asnwer
        if (c.equals("yes") || c.equals("y") || c.equals("Yes") || c.equals("Y")) {//if yes
            System.out.println("Choose by id:");
            String sel = "select * from employee where specialty = 'Engineer of airtime' and busy = 0;";
            //query to select employees from Department of Release and Analysis
            // and which don't work on any project
            Statement st = con.createStatement();//statement ot execute
            ResultSet rs = st.executeQuery(sel);//execution of query /selection
            while (rs.next()) { //while there are fields with values, outputs  employees
                System.out.println("Employee " + rs.getInt("employee_id") + " " +
                        rs.getString("first_name") + " " + rs.getString("last_name") +
                        " " + rs.getString("specialty") );
            }
            int ID = scan.nextInt();//inputting ID
            while (ID != 0)  {//until user inputs 0
                int cnt = 0;//to check correctness of id
                String emp = "select employee_id from employee where specialty = 'Engineer of airtime' and busy = 0;";
                //query to select employees' id from Department of Release and Analysis
                // and which don't work on any project
                Statement emps = con.createStatement();//statement to execute query
                ResultSet empr = emps.executeQuery(emp);//execution of query
                while(empr.next()) { //while there are fields with values
                    if (ID == empr.getInt("employee_id")) {//if id equals to any employee id
                        DepartmentOfReleaseAndAnalysis engineer = new EngineerOfAirtime(ID);
                        //saving it in object of head specialty in department
                        employees.add((Employee)engineer);//adding into arraylist with casting
                        cnt++;//cnt increases when id is correct
                    }
                }
                if (cnt == 0)//iff id is not correct prints message about it
                    System.out.println("Please, text right id of employee: ");
                ID = scan.nextInt();//inputting again
            }
        }
        System.out.println("    Do you need employees of Administration?(y/n)");
        c = scan.next();//answer
        if (c.equals("yes") || c.equals("y") || c.equals("Yes") || c.equals("Y")) {//if yes
            System.out.println("Choose by id:");
            String sel = "select * from employee where specialty = 'Accountant' and busy = 0 or " +
                    "specialty = 'Bookkeeper' and busy = 0 or  specialty = 'Axeman' and busy = 0 " +
                    "or specialty = 'Economist' and busy = 0 or specialty = 'Lawyer' and busy = 0;";
            //query to select employees from Administration and which don't work on any project
            Statement st = con.createStatement();//Statement ot execute query
            ResultSet rs = st.executeQuery(sel);//execution of query /selection
            while (rs.next()) {//while there are fields with values
                System.out.println("Employee " + rs.getInt("employee_id") + " " +
                        rs.getString("first_name") + " " + rs.getString("last_name") +
                        " " + rs.getString("specialty") );
            }
            int ID = scan.nextInt();//inputting ID
            while (ID != 0)  { //until id is 0
                int cnt = 0;//to check correctness of ID
                String emp = "select employee_id from employee where specialty = 'Accountant' and busy = 0 or " +
                        "specialty = 'Bookkeeper' and busy = 0 or  specialty = 'Axeman' and busy = 0 " +
                        "or specialty = 'Economist' and busy = 0 or specialty = 'Lawyer' and busy = 0;";
                //query to select employees' id from Administration and which don't work on any project
                Statement emps = con.createStatement();//statement to execute query
                ResultSet empr = emps.executeQuery(emp);//execution of query
                while(empr.next()) {//while there are fields with values
                    if (ID == empr.getInt("employee_id")) {
                        //if id equals to any employee_id
                        Administration admin = new Bookkeeper(ID);//saving it in head specialty of department
                        employees.add((Employee)admin);//adding into arraylist with casting
                        cnt++;//cnt increases when id is correct
                    }
                }
                if (cnt == 0)//if id is not correct then prints message about it
                    System.out.println("Please, text right id of employee: ");
                ID = scan.nextInt();//input again
            }
        }
        System.out.println("===========================");
        System.out.println("Enter deadline of project (year-month-day): ");
        Date deadline = Date.valueOf(scan.next()); //inputting deadline and converting from string to date
        System.out.println("Do you want to finish creation?(y/n)");
        c = scan.next();//answer
        if (c.equals("yes") || c.equals("y") || c.equals("Yes") || c.equals("Y")) {//if yes
            String ins = "INSERT INTO work (discription, deadline) values(?, ?)";
            //query to insert values
            PreparedStatement pr = con.prepareStatement(ins);//prepared statement ot insert with sets
            pr.setString(1,discription);//setting to first '?' description
            pr.setDate(2,deadline);//setting to second '?' deadline
            pr.execute();//execution of query
            for (Employee a : employees) { //foreach with arraylist that contains employee ids
                String ins1 = "INSERT INTO work_details (employee_id, work_id) values(?, ?)";
                //query to insert values
                PreparedStatement pr1 = con.prepareStatement(ins1);
                //prepared statement to insert with sets
                String sel = "select work_id from work where discription = ?;";
                //selecting id of project by its description
                PreparedStatement pr2 = con.prepareStatement(sel);
                //prepared statement to execute with sets
                pr2.setString(1,discription); //setting to '?' description
                ResultSet rs = pr2.executeQuery();//to select work_id
                while (rs.next()) {//while there are fields with values
                    pr1.setInt(1,a.getEmployee_id());//setting to first '?' id from array
                    pr1.setInt(2,rs.getInt("work_id"));//setting to second '?' work_id
                }
                pr1.execute();//execution of query / insert
                String upd = "update employee \n" + "set busy = 1 where employee_id = ?; ";
                //query to update a value of busy, so that will show that employee work on project
                PreparedStatement pr3 = con.prepareStatement(upd);//prepared statement ot execute with set
                pr3.setInt(1, a.getEmployee_id());//setting to '?' employee_id
                pr3.execute();//execution of query

            }

            con.close();//closing connection to database
            return true;//returns false, shows that project is created
        }
        else if(c.equals("No") || c.equals("no") || c.equals("NO") || c.equals("n") || c.equals("N"))
            return false;//if no, return false
        else {
            System.out.println("Wrong input!");
            return false;//if wrong input, returns false too
        }
    }
    public void AllProjects() { //method that shows all projects
        Connection con = null;//connection
        try {
            con = db.getConnection();//getting connection to database
            ArrayList<Project> projects = new ArrayList<>();//arraylist of Project
            String id = "select work_id from work";
            //query to select work_id (project_id)
            Statement stt = con.createStatement();//statement to execute
            ResultSet rss = stt.executeQuery(id);//execution of query / selection
            while (rss.next()) {//while there are fields with values
                Project project = new Project(rss.getInt("work_id")); // saving it in object of Project
                projects.add(project);//adding it in array
            }
            for (Project p: projects) {// with foreach using arraylist
                String sel = "select work.work_id, work.discription, work.deadline, employee.employee_id, " +
                        "employee.first_name, employee.last_name, employee.specialty from work " +
                        "INNER JOIN work_details ON work.work_id = work_details.work_id " +
                        "INNER JOIN employee ON work_details.employee_id = employee.employee_id " +
                        "where work.work_id = '" + p.getProject_id() + "'; ";
                //query to select all needed information (project_id, employee information, description, deadline)
                Statement st = con.createStatement();//Statement to execute
                ResultSet rs = st.executeQuery(sel);//execution of query (selection)
                int cnt = 0;//to print some information only once
                while (rs.next()) {//while there are fields with values
                    if (cnt == 0) {//to print once
                        System.out.println("Project <<" + rs.getString("discription")  +
                                ">> its deadline: " + rs.getString("deadline") + ";" );
                        cnt++;//increases so that condition is true once
                    } //output of employees
                    System.out.println("Employee " + rs.getString("employee_id") + ". " +
                            rs.getString("first_name") + " " + rs.getString("last_name") +
                            ", " + rs.getString("specialty") );
                }
                System.out.println(" ");
            }
        } catch (SQLException throwables) {//catching exceptions to continue program
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();//closing connection
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public ArrayList<Employee> GetProject(String discription) { //method to get concrete project
        Connection con = null;//connection
        try {
            con = db.getConnection();//getting connection to database
            String sel = "select work.work_id, work.discription, work.deadline, employee.employee_id, " +
                    "employee.first_name, employee.last_name, employee.specialty from work " +
                    "INNER JOIN work_details ON work.work_id = work_details.work_id " +
                    "INNER JOIN employee ON work_details.employee_id = employee.employee_id " +
                    "where work.discription = '" + discription + "'; ";
            //query to select all needed information
            Statement st = con.createStatement();//statement to execute
            ResultSet rs = st.executeQuery(sel);//execution of query / selection
            boolean cnt = true;//to output once some info
            ArrayList<Employee> employees = new ArrayList<>(); //arraylist of Employees
            while (rs.next()) {//while there are fields with values
                if (cnt) {//to output once
                    System.out.println("Project <<" + rs.getString("discription")  +
                            ">> its deadline: " + rs.getString("deadline") + "; \nOn this Project works: ");
                    cnt = false;//it becomes false so that condition works once
                } //(down casting)
                Employee employee = new Director(rs.getInt("employee_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("specialty") );//saving values into object of Director
                employees.add(employee);//adding in arraylist
            }
            return employees;//returns array list of Employees
        } catch (SQLException throwables) { //in cate of exception/error
            throwables.printStackTrace();
            return  null;//will return null
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                con.close();//closing connection
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}