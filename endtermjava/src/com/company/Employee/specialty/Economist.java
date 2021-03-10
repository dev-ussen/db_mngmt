package com.company.Employee.specialty;

import com.company.Employee.Department.Administration;
import com.company.Employee.Employee;

public class Economist extends Employee implements Administration {

     public Economist() {
         this.setSpecialty("Economist");
     }

     @Override
     public String AdminWork() {
         return "In Administration department I work as Economist and i like my work in REYDI";
     }

     @Override
     public String SpecialtyInfo() {
         return "The economist plans financial and economic activities.";
     }
 }
