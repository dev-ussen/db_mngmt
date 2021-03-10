package com.company.Employee.specialty;


import com.company.Employee.Department.WorkerManagement;
import com.company.Employee.Employee;

public class Cleaner extends Employee implements WorkerManagement {
    @Override
    public String WorkM() {
        return "In Worker department I work as Cleaner";

    }

    @Override
    public String SpecialtyInfo() {
        return "The cleaner keeps the building clean.";
    }
}
