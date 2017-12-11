package io.roberthernandez;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Algo_Final {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello Algo Final!");

        String resource_file = "/home/robert/IdeaProjects/algo_final/src/main/resources/amazon-elec-data.txt";

        String[][] allData = readDataFromFile(resource_file);

        // Test Code

//        Should print
//
//        AO94DHGC771SJ
//        0528881469
//        amazdnu
//        [0, 0]
//        We got this GPS for my husband who is an (OTR) over the road trucker.  Very Impressed with the shipping time, it arrived a few days earlier than expected...  within a week of use however it started freezing up... could of just been a glitch in that unit.  Worked great when it worked!  Will work great for the normal person as well but does have the \trucker\ option. (the big truck routes - tells you when a scale is coming up ect...)  Love the bigger screen, the ease of use, the ease of putting addresses into memory.  Nothing really bad to say about the unit with the exception of it freezing which is probably one in a million and that's just my luck.  I contacted the seller and within minutes of my email I received a email back with instructions for an exchange! VERY impressed all the way around!
//        5.0
//        Gotta have GPS!
//        1370131200
//        06 2, 2013
//

        System.out.println(allData[0][0]);
        System.out.println(allData[0][1]);
        System.out.println(allData[0][2]);
        System.out.println(allData[0][3]);
        System.out.println(allData[0][4]);
        System.out.println(allData[0][5]);
        System.out.println(allData[0][6]);
        System.out.println(allData[0][7]);
        System.out.println(allData[0][8]);

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

    private static String[][] readDataFromFile(String filename) throws FileNotFoundException {

        // Retreived using the wc -l command on "resource_file"
        final int line_count = 1689188;
        final int fields_count = 9;

        final String delimiter = ":,;";


        File file = new File(filename);
        Scanner inputfile = new Scanner(file);

        String oneLine = "";

        String[][] allData = new String[line_count][fields_count];

        // Read file into 2 dimenstional array data struct
        for (int i = 0; inputfile.hasNext(); ++i) {
            oneLine = inputfile.nextLine();
            allData[i] = oneLine.split(delimiter);

//            // Remove extra whitespace
//            allData[i][8] = removeLastChar(allData[i][8]);
//            for (int j = 0; j < fields_count; ++j) {
//                allData[i][j] = removeFirstChar(allData[i][j]);
//            }

        }

        return allData;
    }

    // https://stackoverflow.com/questions/7438612/how-to-remove-the-last-character-from-a-string
//    private static String removeLastChar(String str) {
//        return str.substring(0, str.length() - 1);
//    }
//
//    // https://stackoverflow.com/questions/4503656/java-removing-first-character-of-a-string
//    private static String removeFirstChar(String s){
//        return s.substring(1);
//    }



}

