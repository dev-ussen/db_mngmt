package com.company.Employee.specialty;

import com.company.Employee.Department.TechnicalManagement;
import com.company.Employee.Employee;

public class HeadEngineer extends Employee implements TechnicalManagement {

    public HeadEngineer(int employee_id) {
        setEmployee_id(employee_id);
        setSpecialty("HeadEngineer");
    }
    public HeadEngineer() {

    }
    @Override
    public String TechWork() {
        return "In Technical department I work as HeadEngineer and i like my job in REYDI";

    }

    @Override
    public String SpecialtyInfo() {
        return "The head engineer is responsible for the technical condition of the television equipment.";
    }
}
