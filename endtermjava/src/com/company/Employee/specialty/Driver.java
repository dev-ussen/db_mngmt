package com.company.Employee.specialty;


import com.company.Employee.Department.WorkerManagement;
import com.company.Employee.Employee;

public class Driver extends Employee implements WorkerManagement {

    public Driver() {
        this.setSpecialty("Driver");
    }

    @Override
    public String WorkM() {
        return "In Worker department I work as Driver and i like my job in REYDI";

    }

    @Override
    public String SpecialtyInfo() {
        return "The driver is responsible for the transport.";
    }
}
