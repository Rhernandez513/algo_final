package io.roberthernandez;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;


public class Algo_Final {
    //https://stackoverflow.com/questions/34532431/how-to-read-json-using-gson-in-java

    public void readAndPrintJSON() {
        Gson gson = new Gson();
        try {
            BufferedReader br = new BufferedReader(new FileReader("/home/robert/IdeaProjects/algo_final/src/main/resources/reviews_Electronics_5.json"));
            JsonReader buffered_reader = gson.newJsonReader(br);
            buffered_reader.setLenient(true);

            //convert the json string back to object
            Object obj = gson.fromJson(buffered_reader, Object.class);

            System.out.println(obj);

        } catch(Throwable e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello Algo Final!");
        Algo_Final class_instance = new Algo_Final();
        class_instance.readAndPrintJSON();
    }

}

