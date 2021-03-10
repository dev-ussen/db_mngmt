package com.company.Employee.specialty;

import com.company.Employee.Department.TechnicalManagement;
import com.company.Employee.Employee;

public class LeadEngineer extends Employee implements TechnicalManagement {
    @Override
    public String TechWork() {
        return "In Technical department I work as LeadEngineer and i like my work in REYDI";
    }

        @Override
    public String SpecialtyInfo() {
        return "Lead engineer deputy head engineer.";
    }
}
