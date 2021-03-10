package com.company.Employee.specialty;


import com.company.Employee.Department.Media;
import com.company.Employee.Employee;

public class Decorater extends Employee implements Media {
    @Override
    public String MediaWork() {
        return "In Media department I work as Decorator and i like my work in REYDI";
    }

    @Override
    public String SpecialtyInfo() {
        return "A decorator decorates the studio for a reenactment show.";
    }
}
