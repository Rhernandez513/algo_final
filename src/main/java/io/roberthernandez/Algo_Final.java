package io.roberthernandez;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Algo_Final {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello Algo Final!");
        String resource_file = "/home/robert/IdeaProjects/algo_final/src/main/resources/amazon-elec-data.txt";

        File file = new File(resource_file);
        Scanner inputfile = new Scanner(file);

        String oneLine = "";
        if (inputfile.hasNext()) {
            oneLine = inputfile.nextLine();
        }
        System.out.println(oneLine);
    }

}

