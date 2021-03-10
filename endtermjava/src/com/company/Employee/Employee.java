package com.company.Employee;

import java.sql.Date;

public abstract class Employee { //abstract class to get access to data easier,
    //class makes saving and getting information about employee easier

    //We followed Single Responsibility principle (class responsible for information about employees)
    //also liskov's substitution principle with specialties classes which extend Employee
    //they don't use anything that is not needed or that doesn't concern them
    //and dependency inversion principle: specialties extend Employee (low-level module depends on high-level module)
    protected int employee_id;
    protected String First_Name;
    protected String Last_Name;
    protected String Gender;
    protected String specialty;
    protected int Salary;
    protected Date Hire_date;
    protected Date Quit_date;

    public abstract String SpecialtyInfo();


    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public Date getHire_date() {
        return Hire_date;
    }

    public void setHire_date(Date hire_date) {
        Hire_date = hire_date;
    }

    public Date getQuit_date() {
        return Quit_date;
    }

    public void setQuit_date(Date quit_date) {
        Quit_date = quit_date;
    }


}
