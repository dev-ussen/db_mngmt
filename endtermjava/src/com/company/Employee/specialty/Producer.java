package com.company.Employee.specialty;

import com.company.Employee.Department.Media;
import com.company.Employee.Employee;

public class Producer extends Employee implements Media {

    public Producer() {
        this.setSpecialty("Producer");
    }

    @Override
    public String MediaWork() {
        return "In Media department I work as Producer and i like my work in REYDI";
    }

    @Override
    public String SpecialtyInfo() {
        return "Producer sponsors the production of the show.";
    }
}
