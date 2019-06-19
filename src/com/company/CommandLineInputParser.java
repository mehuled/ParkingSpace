package com.company;

import java.util.Scanner;

public class CommandLineInputParser extends InputParser {

    public void readInput()
    {

        Scanner sc = new Scanner(System.in) ;
        String line = sc.nextLine() ;

        while (line!=null && !line.equals("exit"))
        {
            System.out.println(line);
            lineProcessor(line);
            line = sc.nextLine();
        }

    }
}
