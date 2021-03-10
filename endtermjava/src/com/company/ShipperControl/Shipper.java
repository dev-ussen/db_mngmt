package com.company.ShipperControl;


import java.util.ArrayList;

public class Shipper {//Single responsibility
    //responsible for information about shippers
    private int id;
    private int employee_id;
    private String Name_company;
    private String product;
    private String quality;
    private int price;
    private final ArrayList<String> dubbing = new ArrayList<>();//arraylist because it easier to save and get


    public Shipper(String Name_company) {
        this.Name_company = Name_company;
    }

    public Shipper(int id) {
        this.id = id;
    }
    public Shipper(String Name_company, String product) {
        this.Name_company = Name_company;
        this.product = product;
    }
    public Shipper(String Name_company, String product, String quality) {
        this.Name_company = Name_company;
        this.product = product;
        this.quality = quality;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getName_company() {
        return Name_company;
    }

    public void setName_company(String name_company) {
        Name_company = name_company;
    }

    public String getProducts() {
        return product;
    }

    public void setProducts(String product) {
        this.product = product;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<String> getDubbing() {
        return dubbing;
    }

    public void setDubbing(String dubbing) {
        this.dubbing.add(dubbing);
    }
}
