package com.company;

import java.io.IOException;
import java.util.ArrayList;

public class Processor {

    Context context ;
    ParkingLot parkingLot ;


    Processor(Context context)
    {
        this.context = context ;
        context.getInputParser().setProcessor(this);
    }

    public void start()
    {

        context.getInputParser().readInput();
    }




    public void createParkingLot(int numberOfSlots)
    {

        this.parkingLot = new ParkingLot(numberOfSlots) ;
        try {
            context.getOutputPresenter().writeOutput("Successfully created the Parking Slot with slots : " +numberOfSlots);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void park(String regNo, String color)
    {
        Car car = new Car(regNo,color) ;

        try {
            String id = parkingLot.park(car) ;
            context.getOutputPresenter().writeOutput("Successfully parked the car at Slot ID : " + id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void status()
    {
        try {
            context.getOutputPresenter().writeOutput(parkingLot.status()) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leave(String id)
    {

        try {
            parkingLot.leave(id);
            context.getOutputPresenter().writeOutput("Slot ID : " + id + " is free now." );
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
    }

    public void getRegNumberForCarsWithColor(String color)
    {
        String output = "";
        ArrayList<String> regNos = parkingLot.getRegNumberForCarsWithColor(color) ;

            for (int i = 0 ; i<regNos.size(); i++)
            {
                if(i==0)
                    output+= regNos.get(i);

                else
                    output += "," + regNos.get(i);
            }
            output+="\n";

        try {
            context.getOutputPresenter().writeOutput(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getSlotNumberOfCarWithRegNo(String regNo)
    {


        try {

            String id = parkingLot.getSlotNumberOfCarWithRegNo(regNo);
            context.getOutputPresenter().writeOutput("The slot number of car with registration number : " + regNo + " is : " + id);
        }
        catch (Exception e)
        {
//            System.out.println("Cannot find matching reg No.");
            e.printStackTrace();
        }



    }






}
