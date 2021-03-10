package com.company.Employee.specialty;

import com.company.Employee.Department.Media;
import com.company.Employee.Employee;

public class HeadProducer extends Employee  implements Media {

    public HeadProducer(int employee_id) {
        setSpecialty("Head producer");
        setEmployee_id(employee_id);
    }
    public HeadProducer() {

    }



    @Override
    public String MediaWork() {
        return "In Media department I work as Head Producer and i like my work in REYDI";
    }

    @Override
    public String SpecialtyInfo() {
        return "The head producer organizes the filming of the shows.";
    }
}
