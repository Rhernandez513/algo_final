package io.roberthernandez;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Algo_Final {

    public static String[][] readDataFromFile(int lines_to_read) throws FileNotFoundException {
        String resource_file = "/home/robert/IdeaProjects/algo_final/src/main/resources/amazon-elec-data.txt";

        final int line_count = 1689188;
        final int fields_count = 9;

        if (lines_to_read == 0) {
            lines_to_read = line_count;
        }
        // Retreived using the wc -l command on "resource_file"


        final String delimiter = ":,;";


        File file = new File(resource_file);
        Scanner inputfile = new Scanner(file);

        String oneLine = "";
        String[][] allData = new String[line_count][fields_count];


        // Read file into 2 dimenstional array data struct
//        for (int i = 0; inputfile.hasNext(); ++i) {
        for (int i = 0; i < lines_to_read; ++i) {

            oneLine = inputfile.nextLine();
            String[] dataContents = oneLine.split(delimiter);

            for(int j = 0; j < dataContents.length; ++j) {
                int len = dataContents.length;
                dataContents[j] = dataContents[j].trim();
                if (j == (len - 1) ) {
                    dataContents[j] = removeLastChar(dataContents[j]);
                }
            }
            allData[i] = dataContents;
        }
        return allData;
    }

    private static String removeLastChar(String str) {
        return str.substring(0, str.length() - 1);
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Hello Algo Final!");
        final int line_count = 1689188;

        String[][] allData =  readDataFromFile(line_count);





            // How many unique products and unique reviewers are there?

//        ArrayList<String> all_reviewer_IDs = new ArrayList<String>();
//
//        for (int i = 0; i < alldata.size(); ++i) {
//            String reviewerID = alldata.get(i).get(0);
//            if (!all_reviewer_IDs.contains(reviewerID)) {
//                all_reviewer_IDs.add(reviewerID);
//            }
//        }
//
//        int unique_reviewer_count = all_reviewer_IDs.size();
//        System.out.println("Unique Reviewers: " + unique_reviewer_count);

        }
}

