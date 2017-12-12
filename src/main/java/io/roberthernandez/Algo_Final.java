package io.roberthernandez;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Algo_Final {

    public static String[][] readDataFromFile(int lines_to_read) throws FileNotFoundException {
        String resource_file = "/home/robert/IdeaProjects/algo_final/src/main/resources/amazon-elec-data.txt";

        final int line_count = 1689188;
        final int fields_count = 9;

        if (lines_to_read >= line_count) {
            lines_to_read = line_count;
        }
        // Retreived using the wc -l command on "resource_file"


        final String delimiter = ":,;";


        File file = new File(resource_file);
        Scanner inputfile = new Scanner(file);

        String oneLine = "";
        String[][] allData = new String[lines_to_read][fields_count];


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

    public static String[][] sortDataByASIN(String[][] data) {

        Arrays.sort(data, new Comparator<String[]>() {
            @Override
            public int compare(final String[] entry1, final String[] entry2) {
                final String time1 = entry1[1];
                final String time2 = entry2[1];
                return time1.compareTo(time2);
            }
        });
        return data;
    }

    public static String[] searchForASIN(String[][] data, String ASIN) {
        ArrayList<String> reduction = new ArrayList<String>();
        String workingString = "";

        for (int i = 0; i < data.length; ++i) {
            if (data[i][1] == ASIN) {
                // reviewerID
                if (i == 0) {
                    workingString += "ReviewerID: ";
                    workingString += data[i][0];
                }
                workingString += ", ";
                workingString += "ReviewText: ";
                workingString += data[i][4];
            }
            reduction.add(workingString);
        }
        String [] result = reduction.toArray(new String[reduction.size()]);
        return result;
    }




    // Question 4
//    public static void givenASINOutputReviewText(Graph graph, String asin, String[][] data) {
//
//        ArrayList<Vertex> reduction_list = new ArrayList<>();
//
//        for(int i = 0; i < graph.numVertices(); ++i) {
//            Iterable<Vertex> result =  graph.adjacentTo(data[i][1]);
//            reduction_list.add(result);
//        }
//
//        Iterable<Vertex> result =  graph.adjacentTo(data[0][1]);
//
//
//        System.out.println("Adjacency: " + result.toString());
//    }

    // Question 5
//    public static void givenReviewerIDOutputReviewText() { }

    public static void main(String[] args) throws IOException {
        System.out.println("Hello Algo Final!");
        // final int line_count = 1689188;
        final int line_count = 1689188;
        final int lines_to_read = 1000;
        String[][] allData =  readDataFromFile(lines_to_read);

//       String[] result = searchForASIN(allData, "0528881469");

//       System.out.println(result[1]);


        Graph graph = new Graph();

        // Add reviewerID's as vertex's
        for (int i = 0; i < lines_to_read; ++i) {
            graph.addVertex(allData[i][0]);
        }
        // Add ASIN's as vertex's
        for (int i = 0; i < lines_to_read; ++i) {
            graph.addVertex(allData[i][1]);
        }

        // Create edges
        for (int i = 0; i < lines_to_read; ++i) {
            String reviewerID = allData[i][0];
            String asin = allData[i][1];

            if(!graph.hasEdge(reviewerID, asin)) {
                graph.addEdge(reviewerID, asin);
            }
        }


        int numEdges = graph.numEdges();

        System.out.println(graph);


        System.out.println(numEdges);








        // Question 7
        String[][] asin_sort_result = sortDataByASIN(allData);

//        String[] specific_record = searchForASIN(allData, 100);
//        for (String value : specific_record
//                ) { System.out.println(value);
//
//        }


        // Question 1 How many unique products and unique reviewers are there?

        HashSet<String> all_reviewer_IDs = new HashSet<String>();

        for (int i = 0; i < allData.length; ++i) {
            String reviewerID = allData[i][0];
            if (!all_reviewer_IDs.contains(reviewerID)) {
                all_reviewer_IDs.add(reviewerID);
            }
        }

        int unique_reviewer_count = all_reviewer_IDs.size();
        System.out.println("Unique Reviewers: " + unique_reviewer_count);

        }
}

