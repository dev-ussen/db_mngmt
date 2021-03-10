package com.company.Employee.specialty;


import com.company.Employee.Department.WorkerManagement;
import com.company.Employee.Employee;

public class Locksmith extends Employee implements WorkerManagement {
    @Override
    public String WorkM() {
        return "In Worker department I work as Locksmith and i like my work in REYDI";
    }

    @Override
    public String SpecialtyInfo() {
        return "The locksmith is responsible for the technical condition of the building.";
    }
}
