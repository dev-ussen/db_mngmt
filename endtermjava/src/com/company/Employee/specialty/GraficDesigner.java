package com.company.Employee.specialty;


import com.company.Employee.Department.Media;
import com.company.Employee.Employee;

public class GraficDesigner extends Employee implements Media {
    @Override
    public String MediaWork() {
        return "In Media department I work as Grafic Designer and i like my job in REYDI";
    }

    @Override
    public String SpecialtyInfo() {
        return "The graphic designer designs the ether picture, the colour scheme and the bars.";
    }
}
