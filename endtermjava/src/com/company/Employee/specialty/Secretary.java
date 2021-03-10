package com.company.Employee.specialty;

import com.company.Employee.Department.CommercialService;
import com.company.Employee.Employee;

import java.sql.Date;

public class Secretary extends Employee implements CommercialService {

    public Secretary() {

    }
    public Secretary(int employee_id, String First_name, String Last_name, String specialty, Date hire_date) {
        setEmployee_id(employee_id);
        setFirst_Name(First_name);
        setLast_Name(Last_name);
        setSpecialty(specialty);
        setHire_date(hire_date);
    }



    @Override
    public String CommWork(){
        return "In Commercial Service I work as Secretary and i like my work in REYDI";
    }


    @Override
    public String SpecialtyInfo() {
        return "The secretary answers the telephone, receives and dispatches correspondence " +
                "and takes minutes of production meetings.";
    }

    @Override
    public String toString() {
        return "Employee " + employee_id + ". " + First_Name +
                " " + Last_Name + ", " + specialty + ", hire_date: " + Hire_date + "\n";
    }
}
