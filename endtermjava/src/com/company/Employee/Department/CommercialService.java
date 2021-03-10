package com.company.Employee.Department;


//Commercial Service, specialties from this department implements Commercial Service (Secretary)
public interface CommercialService{

    static String CommercialInfo() {
        return "    The secretary helps director with answering calls, taking messages and handling " +
                "correspondence, \n" + "maintaining diaries and arranging appointments, typing, preparing and collating " +
                "reports.\n";
    }

     String CommWork();
}
