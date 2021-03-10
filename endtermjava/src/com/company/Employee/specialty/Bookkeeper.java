package com.company.Employee.specialty;


import com.company.Employee.Department.Administration;
import com.company.Employee.Employee;

public class Bookkeeper extends Employee implements Administration {

    public Bookkeeper(int employee_id) {
        this.setEmployee_id(employee_id);
        this.setSpecialty("Bookkeeper");
    }

    public Bookkeeper() {

    }

    @Override
    public String AdminWork() {
        return "In Administration department I work as Bookkeeper and i like my work in REYDI";
    }

    @Override
    public String SpecialtyInfo() {
        return "The bookkeeper carries out the process of procuring goods, works and services.";
    }
}
