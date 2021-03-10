package com.company.Employee.specialty;

import com.company.Employee.Department.Media;
import com.company.Employee.Employee;

public class Projectionist extends Employee implements Media {
    @Override
    public String MediaWork() {
        return "In Media department I work as Projectionist and i like my job in REYDI";
    }

        @Override
    public String SpecialtyInfo() {
        return "The projectionist takes the footage.";
    }
}
