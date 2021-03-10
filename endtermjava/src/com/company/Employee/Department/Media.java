package com.company.Employee.Department;

//Media department, specialties from this department implements Media
public interface Media {

     static String MediaInfo() {


         return "   A workers of media department responsible for the equipment that projects movies onto a screen,\n" +
                 "editing recorded raw material into a finished product, developing concepts and layouts for " +
                "project \n" + "illustrations, planning, coordinating, and revising material for publication. As each " +
                "department has\n" + "a principal, media is controlled by head producer and subhead.\n";
    }

    String MediaWork();
}
