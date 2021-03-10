package com.company.Employee.specialty;

import com.company.Employee.Department.WorkerManagement;
import com.company.Employee.Employee;

public class Fitter extends Employee implements WorkerManagement {
    @Override
    public String WorkM() {
        return "In Worker department I work as Fitter and i like my job in REYDI";
    }

    @Override
    public String SpecialtyInfo() {
        return "Fitter installs the lights in the studio";
    }
}
