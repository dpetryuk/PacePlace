package com.example.daniel.paceplace;

import java.util.ArrayList;

public class CourseData {

    //public static String[] algoList = {"4|nice", "5|Learnt many new stuff", "2|very difficult"};
    //public static String[] aIList = {"5|wow","3|tough","4|okay"};
    //public static String[] mobList = {"5|Pretty easy coursework","4|learnt basics of android","3|hmm","2|edsf"};
    //public static String[] dmList = {"3|sdsfs","4|sefd","3|rdf"};

    public static ArrayList<String> algoList = new ArrayList<>();
    public static ArrayList<String> aIList = new ArrayList<>();
    public static ArrayList<String> mobList = new ArrayList<>();
    public static ArrayList<String> dmList = new ArrayList<>();

    public static void addAllData(){
        algoList.add("4|nice");
        algoList.add("5|Learnt many new stuff");
        algoList.add("2.5|very difficult");

        aIList.add("5|wow");
        aIList.add("3|tough");
        aIList.add("4|okay");

        mobList.add("5|Pretty easy coursework");
        mobList.add("4|learnt basics of android");
        mobList.add("3|hmm");
        mobList.add("2|edsf");

        dmList.add("3|sdsfs");
        dmList.add("4|sefd");
        dmList.add("3|rdf");
    }

}
