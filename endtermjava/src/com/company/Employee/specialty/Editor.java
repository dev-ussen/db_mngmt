package com.company.Employee.specialty;


import com.company.Employee.Department.Media;
import com.company.Employee.Employee;

public class Editor extends Employee implements Media {
    @Override
    public String MediaWork() {
        return "In Media department I work as Editor and i like my work in REYDI";
    }

    @Override
    public String SpecialtyInfo() {
        return "Editor prepares news items.";
    }
}
