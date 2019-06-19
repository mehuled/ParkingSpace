package com.company;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutputPresenter extends OutputPresenter{

    String filename ;

    FileOutputPresenter(String filename)
    {
        this.filename = filename ;
    }

    @Override
    public void writeOutput(String s) throws IOException {

        FileWriter fileWriter;
        fileWriter = new FileWriter(filename,true);
        fileWriter.write(s) ;
        fileWriter.write("\n");
        fileWriter.close();
    }

    }

