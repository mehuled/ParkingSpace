package com.company;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ParkingLot {

    int numberOfSlots ;
    ArrayList<Slot> slots ;
    PriorityQueue<Slot> availableSlots ;
    ArrayList<Car> parkedCars ;


    public ParkingLot(int numberOfSlots)
    {
        this.numberOfSlots = numberOfSlots ;
        availableSlots = new PriorityQueue<>(new SlotComparator()) ;
        slots = new ArrayList<Slot>() ;
        parkedCars = new ArrayList<Car>() ;
        for(int i = 1 ; i<= numberOfSlots ; i++ )
        {
            Slot slot = new Slot(Integer.toString(i),i) ;
            slots.add(slot) ;
            availableSlots.add(slot) ;
        }
    }


    public int getNumberOfAvailableSlots()
    {
        return availableSlots.size() ;
    }

    public Slot getBestParkingSlot()
    {
        if(getNumberOfAvailableSlots()<1)
        {
            return null ;
        }

        else
        return availableSlots.poll() ;
    }

    public void addSlot()
    {
        numberOfSlots++ ;
        Slot slot = new Slot(Integer.toString(numberOfSlots),numberOfSlots) ;
        slots.add(slot) ;
        availableSlots.add(slot) ;
    }

    private void removeSlot(String id)
    {
        Slot slot ;
        for(int i = 0 ; i<numberOfSlots ; i++)
        {
            slot = slots.get(i) ;
            if(slot.getId()==id)
            {
                slots.remove(i) ;
                numberOfSlots-- ;
                makeSlotUnavailable(slot) ;
            }
        }
    }

    private void makeSlotUnavailable(Slot slot)
    {
        availableSlots.remove(slot) ;
    }

    public String park(Car car) throws NoSlotAvailableException {
        Slot slot = getBestParkingSlot();

        if(slot == null)
        {
            throw new NoSlotAvailableException("") ;
//            System.out.println("ERROR! Could not find a parking slot for the car.");
        }

        parkedCars.add(car) ;
        slot.parkCar(car) ;

        return slot.getId() ;
    }

    public void leave(String id) throws NoSuchSlotIDException {
        Car car ;
        for(int i = 0 ; i<numberOfSlots ; i++)
        {
            if(slots.get(i).getId().equals(id))
            {
                car = slots.get(i).getParkedCar() ;
                slots.get(i).freeSlot();
                removeParkedCar(car) ;
                availableSlots.add(slots.get(i)) ;
                return;
            }
        }

        throw new NoSuchSlotIDException("") ;

//        System.out.println("System does not have the provided parking slot id.");
    }

    private void removeParkedCar(Car car)
    {
        for(int i = 0 ; i<parkedCars.size() ; i++)
        {
            if(parkedCars.get(i).getRegNo().equals(car.getRegNo()))
            {
                parkedCars.remove(i) ;
                return;
            }
        }
    }

    public String status()
    {
        Slot slot ;
        String response = "" ;
        response += "SlotNo." + "\t" + "RegNo." + "\t" + "Color" + "\n" ;
        for(int i = 0 ; i<numberOfSlots ; i++)
        {
            if (!slots.get(i).isEmpty)
            {
                slot = slots.get(i) ;
                response += slot.getId() + "\t" + slot.getParkedCar().getRegNo() + "\t" + slot.getParkedCar().getColor() +"\n" ;

            }
        }

        return response ;
    }

    public ArrayList<String> getRegNumberForCarsWithColor(String color)
    {
        ArrayList<String> regNos = new ArrayList<>() ;
        for(int i = 0 ; i<parkedCars.size() ; i++)
        {
            if (parkedCars.get(i).getColor().equals(color))
            {
                regNos.add(parkedCars.get(i).getRegNo()) ;
            }
        }

        return regNos ;
    }

    public String getSlotNumberOfCarWithRegNo(String regNo) throws CarWithRegistrationNumberNotFoundException {

        if(!isCarWithRegNo(regNo))
        {
            throw new CarWithRegistrationNumberNotFoundException("") ;
        }

            String id = "" ;

            for (int i = 0; i < numberOfSlots; i++) {
                if (!slots.get(i).isEmpty) {
                    if (slots.get(i).getParkedCar().getRegNo().equals(regNo)) {
                        id = slots.get(i).getId() ;
                    }
                }
            }

            return id;


    }

    private boolean isCarWithRegNo(String regNo)
    {
        for(int i = 0 ; i<parkedCars.size() ; i++)
        {
            if(parkedCars.get(i).getRegNo().equals(regNo))
                return true ;
        }

        return false ;
    }

}
