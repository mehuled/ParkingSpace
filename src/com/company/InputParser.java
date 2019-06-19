package com.company;

abstract public class InputParser {

    public void setProcessor(Processor processor) {
        this.processor = processor;
            }

    Processor processor ;

    abstract public void readInput() ;

    public void lineProcessor(String line)
    {

        String function = line.split(" ")[0] ;

        if(function.equals("createParkingLot"))
        {
            int numberOfSlots = Integer.parseInt(line.split(" ")[1]) ;


            processor.createParkingLot(numberOfSlots) ;

        }

        else if(function.equals("park"))
        {
            String regNo = line.split(" ")[1] ;
            String color = line.split(" ")[2] ;

            processor.park(regNo,color) ;


        }

        else if(function.equals("status"))
        {

            processor.status() ;

        }

        else if(function.equals("leave"))
        {
            String id = line.split(" ")[1] ;

            processor.leave(id) ;

        }

        else if(function.equals("getRegNumberForCarsWithColor"))
        {
            String color = line.split(" ")[1] ;

            processor.getRegNumberForCarsWithColor(color);

        }

        else if(function.equals("getSlotNumberOfCarWithRegNo"))
        {
            String regNo = line.split(" ")[1] ;

            processor.getSlotNumberOfCarWithRegNo(regNo) ;


            }

    }
}
