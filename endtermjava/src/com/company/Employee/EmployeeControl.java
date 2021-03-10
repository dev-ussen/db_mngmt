package com.company.Employee;

//imports to packages to get access to classes/interface
import com.company.Employee.specialty.*;
import com.company.Employee.specialty.Driver;
import com.company.database.IDB;


import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


//class that controls actions with employees
public class EmployeeControl {

    private final IDB db;//way of connection to database
    private final Scanner scan;//scanner to input

    public EmployeeControl(IDB db ) {//giving values
        this.scan = new Scanner(System.in);
        this.db = db;
    }

    public <T> void Specialties (T object) {
        //method that prints information about specialty depending which specialty by generics and instanceof
        //generics allows to put in parameters any object (specialty)
        if (object instanceof Employee) { // and if it is object of Employee (specialties extend Employee)
            System.out.println(((Employee) object).SpecialtyInfo());
            //by casting, will be printed method SpecialtyInfo() that returns description of specialty
        }

    }

    public void InputSpecialty() {
        //method to input specialty and by putting to parameters chosen specialty, calls method Specialties

        System.out.println("1. Director    2. Secretary    3. Accountant    4. Bookkeeper   5. Energy Engineer" +
                "   6. Editor   7. Engineer of Repairing");
        System.out.println("8. Driver    9. Decorator    10. Economist    11. Fitter   12. Head Editor" +
                "   13. Lawyer   14. Engineer Of Airtime");
        System.out.println("15. SubHead    16. Locksmith    17. Head Producer    18. Graphic Designer   19. Projectionist" +
                "   20. Head Engineer   21. Head of Department");
        System.out.println("22. Mechanic    23. Video Maker    24. Video Engineer    25. System Engineer   26. Lead Engineer" +
                "   27. Producer   28. Engineer of Service Equipment");

        int c = scan.nextInt();//to choose specialty by its number

        //depending on which specialty is chosen, Specialties will be called

       if (c == 1) {
           Director director = new Director();
           Specialties(director);
       }
       else if (c == 2) {
           Secretary secretary = new Secretary();
           Specialties(secretary);
       }
       else if (c == 3) {
           Accountant accountant = new Accountant();
           Specialties(accountant);
       }
       else if (c == 4) {
           Bookkeeper bookkeeper = new Bookkeeper();
           Specialties(bookkeeper);
       }
       else if (c == 5) {
           EnergyEngineer energy = new EnergyEngineer();
           Specialties(energy);
       }
       else if (c == 6) {
           Editor editor = new Editor();
           Specialties(editor);
       }
       else if (c == 7) {
           EngineerOfRepairing repairing = new EngineerOfRepairing();
           Specialties(repairing);
       }
       else if(c == 8) {
           Driver driver = new Driver();
           Specialties(driver);
       }
       else if (c == 9) {
           Decorater decorater = new Decorater();
           Specialties(decorater);
       }
       else if(c == 10) {
           Economist economist = new Economist();
           Specialties(economist);
       }
       else if(c == 11) {
           Fitter fitter = new Fitter();
           Specialties(fitter);
       }
       else if (c == 12) {
           HeadEditor headEditor = new HeadEditor();
           Specialties(headEditor);
       }
       else  if(c == 13) {
           Lawyer lawyer = new Lawyer();
           Specialties(lawyer);
       }
       else if (c == 14) {
           EngineerOfAirtime airtime = new EngineerOfAirtime();
           Specialties(airtime);
       }
       else if (c == 15) {
           Subhead subhead = new Subhead();
           Specialties(subhead);
       }
       else if (c == 16) {
           Locksmith locksmith = new Locksmith();
           Specialties(locksmith);
       }
       else if(c == 17) {
           HeadProducer headProducer = new HeadProducer();
           Specialties(headProducer);
       }
       else if(c == 18) {
           GraficDesigner designer = new GraficDesigner();
           Specialties(designer);
       }
       else if(c == 19) {
           Projectionist projectionist = new Projectionist();
           Specialties(projectionist);
       }
       else if(c == 20) {
           HeadEngineer headEngineer = new HeadEngineer();
           Specialties(headEngineer);
       }
       else if (c == 21) {
           HeadOfDepartment department = new HeadOfDepartment();
           Specialties(department);
       }
       else if (c == 22) {
           Mechanic mechanic = new Mechanic();
           Specialties(mechanic);
       }
       else if(c == 23 ) {
           VideoMaker videoMaker = new VideoMaker();
           Specialties(videoMaker);
       }
       else if (c == 24) {
           VideoEngineer videoEngineer = new VideoEngineer();
           Specialties(videoEngineer);
       }
       else if (c == 25) {
           SystemEngineer systemEngineer = new SystemEngineer();
           Specialties(systemEngineer);
       }
       else if (c == 26) {
           LeadEngineer leadEngineer = new LeadEngineer();
           Specialties(leadEngineer);
       }
       else if(c == 27) {
           Producer producer = new Producer();
           Specialties(producer);
       }
       else if (c == 28) {
           EngineerOfServiceEquipment equipment = new EngineerOfServiceEquipment();
           Specialties(equipment);
       }


    }

    public ArrayList<Employee> Hiredates()  {
        //Method that returns arraylist of Employee which contain information about employee,
        // and all employees placed by ascending order of their hired_date
            Connection con = null; //connection to database
        try {
            con = db.getConnection(); //getting connection to database

            ArrayList<Employee>  employees = new ArrayList<>();//arraylist of employee that will be returned

            String sql = "select * from employee order by hire_date asc";
            //query to select from employee bby ascending order of hire_dates
            Statement st = con.createStatement();//statement to execute query
            ResultSet rs = st.executeQuery(sql);//execution of query / selection

            while(rs.next()) {//while there are fields in table
                //saving in object of Employee values (down casting)
                Employee employee = new Secretary(rs.getInt("employee_id"),
                        rs.getString("first_name"),
                        rs.getString("Last_name"),
                        rs.getString("specialty"),
                        rs.getDate("hire_date") );

                employees.add(employee);//adding it in array

            }

            return employees;//returns arraylist

        } catch (SQLException throwables) { //and if catches exception returns null
            throwables.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            try { //closing connection
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    public void EmployeeInfo(String First_name, String Last_name) {
        //method that prints information about employee which first and last name were inputted
        Connection con = null;//connection to database
        try {
            con = db.getConnection(); //getting connection to database

            String sel = "select * from employee where first_name = '" +
                    First_name + "' and last_name = '" + Last_name + "'; ";
            //query to select from employee with such first and last names
            Statement st = con.createStatement();//statement to execute query
            ResultSet rs = st.executeQuery(sel);//execution of query /selection

            if (rs.next()) {//while there are fields with values
                if (rs.getString("quit_date") != null)
                    //if employee have quit date then prints with quit_date
                System.out.println(First_name + " " + Last_name  +" is " + rs.getString("specialty") +
                        ", gender: " + rs.getString("gender") +
                        ", works in REYDI from " + rs.getString("hire_date") +
                        " until " + rs.getDate("quit_date") +
                        ", and gets " + rs.getString("salary") + "tg." );

                else //if employee doesn't have quit date then prints without it
                    System.out.println(First_name + " " + Last_name + " is " + rs.getString("specialty") +
                            ", gender: " + rs.getString("gender") +
                            ", works in REYDI from " + rs.getString("hire_date") +
                            ", and gets " + rs.getString("salary") + "tg." );

                System.out.println();
                System.out.println(rs.getString("first_name") + ":");
                //depending on specialty of employee, will call method from department interfaces
                if (rs.getString("specialty").equals("Accountant")) {
                    Accountant accountant = new Accountant();
                    System.out.println(accountant.AdminWork());
                }
                if (rs.getString("specialty").equals("Axeman")) {
                    Axeman axeman = new Axeman();
                    System.out.println(axeman.AdminWork());
                }
                if (rs.getString("specialty").equals("Bookkeeper")) {
                    Bookkeeper bookkeeper = new Bookkeeper();
                    System.out.println(bookkeeper.AdminWork());
                }
                if (rs.getString("specialty").equals("Cleaner")) {
                    Cleaner cleaner = new Cleaner();
                    System.out.println(cleaner.WorkM());
                }
                if (rs.getString("specialty").equals("Decorator")) {
                    Decorater decorater = new Decorater();
                    System.out.println(decorater.MediaWork());
                }

                if (rs.getString("specialty").equals("Driver")) {
                    Driver driver = new Driver();
                    System.out.println(driver.WorkM());
                }
                if (rs.getString("specialty").equals("Economist")) {
                    Economist economist = new Economist();
                    System.out.println(economist.AdminWork());
                }
                if (rs.getString("specialty").equals("Editor")) {
                    Editor editor = new Editor();
                    System.out.println(editor.MediaWork());
                }
                if (rs.getString("specialty").equals("Energy-Engineer")) {
                    EnergyEngineer engineer = new EnergyEngineer();
                    System.out.println(engineer.TechWork());
                }
                if (rs.getString("specialty").equals("Engineer of airtime")) {
                    EngineerOfAirtime airtime = new EngineerOfAirtime();
                    System.out.println(airtime.DepWork());
                }
                if (rs.getString("specialty").equals("Engineer of repairing")) {
                    EngineerOfRepairing repairing = new EngineerOfRepairing();
                    System.out.println(repairing.TechWork());
                }
                if (rs.getString("specialty").equals("Engineer for service equipment")) {
                    EngineerOfServiceEquipment serviceEquipment = new EngineerOfServiceEquipment();
                    System.out.println(serviceEquipment.TechWork());
                }
                if (rs.getString("specialty").equals("Fitter")) {
                    Fitter fitter = new Fitter();
                    System.out.println(fitter.WorkM());
                }
                if (rs.getString("specialty").equals("Grafic Designer")) {
                    GraficDesigner graficDesigner = new GraficDesigner();
                    System.out.println(graficDesigner.MediaWork());
                }
                if (rs.getString("specialty").equals("Head editor")) {
                    HeadEditor editor = new HeadEditor();
                    System.out.println(editor.MediaWork());
                }
                if (rs.getString("specialty").equals("Head engineer")) {
                    HeadEngineer engineer = new HeadEngineer();
                    System.out.println(engineer.TechWork());
                }
                if (rs.getString("specialty").equals("Head of department")) {
                    HeadOfDepartment department = new HeadOfDepartment();
                    System.out.println(department.WorkM());
                }
                if (rs.getString("specialty").equals("Head producer")) {
                    HeadProducer producer = new HeadProducer();
                    System.out.println(producer.MediaWork());
                }
                if (rs.getString("specialty").equals("Lawyer")) {
                    Lawyer lawyer = new Lawyer();
                    System.out.println(lawyer.AdminWork());
                }
                if (rs.getString("specialty").equals("Lead engineer")) {
                    LeadEngineer engineer = new LeadEngineer();
                    System.out.println(engineer.TechWork());
                }
                if (rs.getString("specialty").equals("Locksmith")) {
                    Locksmith locksmith = new Locksmith();
                    System.out.println(locksmith.WorkM());
                }
                if (rs.getString("specialty").equals("Mechanic")) {
                    Mechanic mechanic = new Mechanic();
                    System.out.println(mechanic.WorkM());
                }
                if (rs.getString("specialty").equals("Producer")) {
                    Producer producer = new Producer();
                    System.out.println(producer.MediaWork());
                }
                if (rs.getString("specialty").equals("Projectionist")) {
                    Projectionist projectionist = new Projectionist();
                    System.out.println(projectionist.MediaWork());
                }
                if (rs.getString("specialty").equals("Secretary")) {
                    Secretary secretary = new Secretary();
                    System.out.println(secretary.CommWork());
                }
                if (rs.getString("specialty").equals("Subhead")) {
                    Subhead subhead = new Subhead();
                    System.out.println(subhead.MediaWork());
                }
                if (rs.getString("specialty").equals("System-engineer")) {
                    SystemEngineer engineer = new SystemEngineer();
                    System.out.println(engineer.TechWork());
                }
                if (rs.getString("specialty").equals("Video-engineer")) {
                    VideoEngineer videoEngineer = new VideoEngineer();
                    System.out.println(videoEngineer.TechWork());
                }
                if (rs.getString("specialty").equals("Videomaker")) {
                    VideoMaker videoMaker = new VideoMaker();
                    System.out.println(videoMaker.MediaWork());
                }

            }
            else { //if there are not employee with such name (rs.next()==false) prints about it
                System.out.println("There isn't employee with such name in company");
            }

            String sql = "select employee.employee_id, employee.specialty, work.work_id, work.discription, work.deadline from employee " +
                    "INNER JOIN work_details ON employee.employee_id = work_details.employee_id " +
                    "INNER JOIN work ON work_details.work_id = work.work_id " +
                    "Where employee.first_name = '" + First_name + "' and employee.last_name = '" + Last_name + "'; ";

            //query to select from employee, work(project), work_details values where work employee with inputted name
            Statement stt = con.createStatement();//statement to execute query
            ResultSet rss = stt.executeQuery(sql);//execution of query / selection

            if (rss.next()) {//if there are field with value, then outputs information about project

                System.out.println(rss.getInt("employee_id") + ". " + First_name + " " +
                        Last_name + " works on Project: " + rss.getString("work_id") + ". " +
                        rss.getString("discription") + " with deadline: " +
                        rss.getDate("deadline")   );

            }


        } catch (SQLException throwables) { //catching exceptions
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close(); //closing connection
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void MaxSalary() { //method that prints employees with max salary

        Connection con = null; //connection to database
        try {
            con = db.getConnection();//getting connection to database

            String max = "select MAX(salary) as maxsalary from employee where specialty != 'Director';";
            //query to get max from column salary in employee table and instead of Director(he earns more then others)
            Statement st = con.createStatement();//statement tot execute
            ResultSet rs = st.executeQuery(max);//execution of query / selection
            int max_salary = 0;//variable that will take value of maxsalary
            if(rs.next()) {//if there is value maxsalary
                max_salary = rs.getInt("maxsalary");//giving values of maxsalary to variable
            }

            String sel = "select * from employee where salary = " + max_salary;
            //query to select employees that have max salary
            Statement stt = con.createStatement();//statement to execute query
            ResultSet rss = stt.executeQuery(sel);//execution of query / selection

            while (rss.next()) {
                //while there are fields with values (employee with max salary) outputs information of this employees
                System.out.println( rss.getInt("employee_id") + ". " + rss.getString("specialty") + " " +
                        rss.getString("first_name") + " " + rss.getString("last_name") + " earns " + max_salary );
            }


        } catch (SQLException throwables) { //catching exceptions
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

    public void MaxSalarySpec(String specialty) {
        //method that prints employee with max salary in his specialty

        Connection con = null; //connection to database
        try {
            con = db.getConnection();//getting connection to database

            String max = "select MAX(salary) as maxsalary from employee where specialty = '" + specialty + "'; ";
            //query to select max salary in inputted specialty
            Statement st = con.createStatement();//statement to execute query
            ResultSet rs = st.executeQuery(max);//execution of query /selection
            int max_salary = 0; //to save value of maxsalary
            while (rs.next()) {//while there are value of maxsalary
                max_salary = rs.getInt("maxsalary");//giving value of maxsalary
            }

            String sel = "select * from employee where salary = " + max_salary + " and specialty = '" + specialty + "'; ";
            //query to select employees with max_salary and in inputted specialty
            Statement stt = con.createStatement();//statement tot execute query
            ResultSet rss = stt.executeQuery(sel);//execution / selection

            while (rss.next()) {
                //while there are fields with values (employees) will print employees
                System.out.println( "Employee " + rss.getInt("employee_id") + ". " + rss.getString("first_name") +
                        " " + rss.getString("last_name") + " earns " + max_salary );
            }


        } catch (SQLException throwables) {//catching exceptions
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

    public void Quit_Date(String First_name, String Last_name) {
        //Method to input end of contract with employee
        Connection con = null; //connection
        try {
            con = db.getConnection(); //getting connection to database

            System.out.println("Please, enter when contract will end: (year-month-day) ");

            Date quit_date = Date.valueOf(scan.next());
            //converting inputted string into Date to be able to setDate

            String sql = "Update employee \n set quit_date = ? where first_name = '" + First_name + "' and last_name  = '" + Last_name +"'; ";
            //query to update values of quit_date of employee which name is inputted
            PreparedStatement ps = con.prepareStatement(sql);//Prepared statement to execute with setting
            ps.setDate(1,quit_date); //setting to '?' inputted quit_date (end of contract)
            ps.execute();//execution of query

            System.out.println("The date placed!");

        } catch (SQLException throwables) {//catching exceptions
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

    public void Fire(String First_name, String Last_name) { //method to fire employee with inputted name

        Connection con = null; //connection

        try {
            con = db.getConnection();//getting connection to database

            String sql = "Delete from employee where first_name = ? and last_name = ?";
            //query to delete employee with inputted first and last name
            PreparedStatement pr = con.prepareStatement(sql);//Prepared statement to execute query by setting

            pr.setString(1,First_name);//setting to first '?' first_name
            pr.setString(2,Last_name);//setting to second '?' last_name
            pr.execute();//execution of query
            System.out.println("Employee was fired!");

        } catch (SQLException throwables) {//catching acceptions
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close(); //closing connection to database
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    public void AllEmployeesSalary(int salary)  { //method that changes salary by percent
        Connection con = null;//connection
        try {
            con = db.getConnection();//getting connection to database
            String sql = "UPDATE employee SET salary = salary + (salary * ?/100)";
            //query to update employees' salary
            PreparedStatement pr = con.prepareStatement(sql);//prepared statement to execute query with sets
            pr.setInt(1, salary); //setting to '?' salary that inputted
            pr.execute();//execution of query
            System.out.println("Employees' salaries was updated!");
        } catch (SQLException throwables) {//catching exceptions
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close(); //closing connection
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void UpdateSalary(int salary, String First_name, String Last_name) {
        Connection con = null;//connection
        try {
            con = db.getConnection();//getting connection to database
            String sql = "UPDATE employee SET salary = ? where first_name = ? and last_name = ? ";
            //query to update salary of employee which name is inputted
            PreparedStatement pr = con.prepareStatement(sql); //Prepared Statement to execute with sets
            pr.setInt(1, salary);//setting to first '?' salary that inputted
            pr.setString(2, First_name); //setting to second '?' first_name
            pr.setString(3, Last_name);//setting to third '?' last_name
            pr.execute();//execution of query
            System.out.println("Employee's salary was updated!");
        } catch (SQLException throwables) {//catching exception
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close(); //closing connection to database
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void UpdateLastName(String First_name, String Last_name, String new_Last_name) {
        //method that updates Last name of inputted employee
        Connection con = null;//connection
        try {
            con = db.getConnection();//getting connection to database
            String sql = "UPDATE employee SET last_name = ? where first_name = ? and last_name = ? ";
            //query to update last name of inputted employee
            PreparedStatement pr = con.prepareStatement(sql);//prepared statement ot execute with sets
            pr.setString(1, new_Last_name);//setting to first '?' changed last_name
            pr.setString(2, First_name);//setting to second '?' first_name of employee
            pr.setString(3, Last_name);//setting to third '?' past last name
            pr.execute();//execution of query
            System.out.println("Employee's last name was updated!");
        } catch (SQLException throwables) {//catching exceptions
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

    public void UpdateGender(String First_name, String Last_name, String new_gender) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE employee SET gender = ? where first_name = ? and last_name = ? ";
            //query to update gender of employee
            PreparedStatement pr = con.prepareStatement(sql);//prepared statement to execute with sets
            pr.setString(1, new_gender);//setting to first '?' new gender
            pr.setString(2, First_name);//setting to second '?' First name
            pr.setString(3, Last_name);//setting to third '?' last name
            pr.execute();//execution of query
            System.out.println("Employee's gender was updated!");
        } catch (SQLException throwables) {//catching exceptions
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

}
