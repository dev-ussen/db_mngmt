package com.company.Employee.Department;


//administration department, specialties from this department implements Administration
public interface Administration  {
    //in  all department interfaces we followed dependency inversion (from higher to lower)
    //also, interface segregation principle, so that there are not methods that aren't used
    static String AdminInfo() {
        return  "   The administration department concludes contracts with shippers, who are providing to " +
                "organization\n" + "products(movies) for special prices. Also, this department pays salaries " +
                "to employees and works on jurisprudence.\n";

    }

     String AdminWork();
}
