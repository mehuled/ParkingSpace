package com.company;

public class Car {

    String regNo ;

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    String color ;


    public Car(String regNo, String color)
    {
        this.regNo = regNo ;
        this.color = color ;
    }

}
