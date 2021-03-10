package com.company.Employee.specialty;


import com.company.Employee.Department.TechnicalManagement;
import com.company.Employee.Employee;

public class EnergyEngineer extends Employee implements TechnicalManagement {
    @Override
    public String TechWork() {
        return "In Technical department I work as Energy Engineer and i like my job in REYDI";
    }

    @Override
    public String SpecialtyInfo() {
        return "Energy engineer responsible for lighting equipment.";
    }
}
