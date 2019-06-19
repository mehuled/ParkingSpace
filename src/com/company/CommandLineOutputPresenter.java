package com.company;

import java.io.IOException;

public class CommandLineOutputPresenter extends OutputPresenter{

    @Override
    public void writeOutput(String s) throws IOException {

        System.out.println(s);

    }
}
