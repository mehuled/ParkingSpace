package com.company;

public class Slot {

    String id ;
    int distance ;
    boolean isEmpty ;
    Car parkedCar ;

    public int getDistance()
    {
        return distance ;
    }

    public String getId() {
        return id;
    }

    public Slot(String id, int distance)
    {
        this.id = id ;
        this.isEmpty = true ;
        this.distance = distance ;
    }

    public Car getParkedCar()
    {
        return parkedCar ;
    }

    public boolean parkCar(Car car)
    {
        if(parkedCar!=null)
        {
            return false ;
        }

        else
        {
            parkedCar = car ;
            isEmpty = false ;
            return true ;
        }
    }

    public void freeSlot()
    {
        parkedCar = null ;
        isEmpty = true ;
    }

}
