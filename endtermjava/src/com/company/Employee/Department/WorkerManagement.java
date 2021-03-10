package com.company.Employee.Department;

//Worker department, specialties from this department implements WorkerManagement
public interface WorkerManagement{

    static String WorkerInfo() {
        return "    A department of economic support (worker management) consists cleaners, drivers, mechanic, " +
                "locksmith\n" + "and fitter, who are in charge of office. They are clean the room, inspect and repair machinery,\n" +
                "responsible for security systems and mechanical systems. \n";
    }


    String WorkM();
}
