package com.company.Employee.specialty;


import com.company.Employee.Department.Media;
import com.company.Employee.Employee;

public class Subhead extends Employee implements Media {
    @Override
    public String MediaWork() {
        return "In Media department I work as Subhead and i like my position in REYDI";
    }

    public Subhead(){
        this.setSpecialty("Subhead");
    }

    @Override
    public String SpecialtyInfo() {
        return "Subhead manages the creative process of the media department.";
    }
}
