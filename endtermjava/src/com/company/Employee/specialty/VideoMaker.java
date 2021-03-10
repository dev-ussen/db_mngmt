package com.company.Employee.specialty;


import com.company.Employee.Department.Media;
import com.company.Employee.Employee;

public class VideoMaker extends Employee implements Media {
    @Override
    public String MediaWork() {
        return "In Media department I work as Video Maker and i like my work in REYDI";
    }

        @Override
    public String SpecialtyInfo() {
        return "A video maker edits the filming process.";
    }
}
