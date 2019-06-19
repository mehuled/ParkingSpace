package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileInputParser extends InputParser{


    String filename ;


    FileInputParser(String filename)
    {
        this.filename = filename ;
    }

    public void readInput()
    {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null && !line.equals("exit")) {
                lineProcessor(line) ;
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
