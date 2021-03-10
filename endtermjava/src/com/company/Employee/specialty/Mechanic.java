package com.company.Employee.specialty;

import com.company.Employee.Department.WorkerManagement;
import com.company.Employee.Employee;

public class Mechanic extends Employee implements WorkerManagement {
    @Override
    public String WorkM() {
        return "In Worker department I work as Mechanic and i like my job in REYDI";
    }

    @Override
    public String SpecialtyInfo() {
        return "A mechanic carries out minor repairs to the building.";
    }
}
