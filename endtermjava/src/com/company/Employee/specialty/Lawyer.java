package com.company.Employee.specialty;

import com.company.Employee.Department.Administration;
import com.company.Employee.Employee;

public class Lawyer extends Employee implements Administration {
    @Override
    public String AdminWork() {
        return "In Administration department I work as Lawyer and i like my work in REYDI";

    }

    @Override
    public String SpecialtyInfo() {
        return "A lawyer deals with claims work and provides legal advice.";
    }
}
