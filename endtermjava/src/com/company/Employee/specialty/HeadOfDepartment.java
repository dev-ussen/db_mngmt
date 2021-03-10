package com.company.Employee.specialty;

import com.company.Employee.Department.WorkerManagement;
import com.company.Employee.Employee;

public class HeadOfDepartment extends Employee implements WorkerManagement{
    @Override
    public String WorkM() {
        return "In Worker department I work as Head of Department and i like my job in REYDI";
    }


    @Override
    public String SpecialtyInfo() {
        return "the head of the department is responsible for economic affairs.";
    }
}
