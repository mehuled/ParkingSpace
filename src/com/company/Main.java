package com.company;

public class Main {

    public static void main(String[] args) {


        Context context = new Context();
        String inputFilename = "/home/i0656/IdeaProjects/ParkingSpace/src/com/company/input.txt" ;
        String outputFilename = "/home/i0656/IdeaProjects/ParkingSpace/src/com/company/output.txt" ;
        context.setInputParser(new FileInputParser(inputFilename));
//      context.setOutputPresenter(new FileOutputPresenter(outputFilename));
        context.setOutputPresenter(new CommandLineOutputPresenter());

        runProcessor(context);

    }

    public static void runProcessor(Context context)
    {
        Processor processor = new Processor(context) ;
        processor.start();
    }

}
