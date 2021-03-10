package com.company.Employee.specialty;

import com.company.Employee.Department.TechnicalManagement;
import com.company.Employee.Employee;

public class EngineerOfServiceEquipment extends Employee implements TechnicalManagement {
    @Override
    public String TechWork() {
        return "In Technical department I work as Engineer of Service Equipment and i like my position in REYDI";
    }

    @Override
    public String SpecialtyInfo() {
        return "Engineer of service equipment responsible for service instructions in case of equipment breakdown.";
    }
}
