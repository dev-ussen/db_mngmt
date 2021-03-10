package com.company.Employee.specialty;

import com.company.Employee.Department.Media;
import com.company.Employee.Employee;

public class HeadEditor extends Employee implements Media {
    @Override
    public String MediaWork() {
        return "In Media department I work as Head Editor and i like my work in REYDI";
    }

    @Override
    public String SpecialtyInfo() {
        return "The head editor manages the creative processes of the editors.";
    }
}
