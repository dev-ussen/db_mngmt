package com.company.Employee.specialty;


import com.company.Employee.Department.DepartmentOfReleaseAndAnalysis;
import com.company.Employee.Employee;

public class EngineerOfAirtime extends Employee implements DepartmentOfReleaseAndAnalysis {

    public EngineerOfAirtime(int employee_id) {
        this.setSpecialty("Engineer of airtime");
        this.setEmployee_id(employee_id);
    }

    public EngineerOfAirtime() {

    }

    @Override
    public String DepWork() {
        return "In Department of Release and Analysis department I work as Engineer of airtime and i like my job in REYDI";

    }

    @Override
    public String SpecialtyInfo() {
        return "The  engineer of airtime is responsible for showing the airwaves.";
    }
}
