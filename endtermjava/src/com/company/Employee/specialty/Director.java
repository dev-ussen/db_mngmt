package com.company.Employee.specialty;

import com.company.Employee.Employee;

public class Director extends Employee {

    public Director(){
        this.setSpecialty("Director");
    }
    public Director(int employee_id, String First_name, String Last_name, String specialty) {
        this.employee_id = employee_id;
        this.First_Name = First_name;
        this.Last_Name = Last_name;
        this.specialty = specialty;
    }

    public static void Connection(String Name_company){
        System.out.println("Director collaborates with " +  Name_company);
    }


    @Override
    public String SpecialtyInfo() {
        return "The director directs the production process";
    }

    @Override
    public String toString() {
        return "Employee " + employee_id + ". " + First_Name +
                " " + Last_Name + ", " + specialty + "\n";
    }
}
