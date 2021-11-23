package com.company;

import java.util.*;

public class ConsoleProgram {

    private HashSet<Person> peopleHashSet;
    private TreeSet<Person> peopleTreeSet;
    private HashMap<String,Person> peopleHashMap;
    private TreeMap<String,Person> peopleTreeMap;
    private ArrayList<Person> peopleArrayList;
    private LinkedList<Person> peopleLinkedList;


    public static void main(String[] args) {
        ConsoleProgram app = new ConsoleProgram();
        app.runMainLoop();
    }

    public void runMainLoop(){

        Scanner sc = new Scanner(System.in);

        message();
        switch(sc.nextInt()){
            case 1:
                System.out.println("działa");
        }
    }

    public static void message(){
        System.out.println("PROGRAM PREZENTUJĄCY DZIAŁANIE KOLEKCJI");
        System.out.println("Jaką kolekcję utworzyć?");
        System.out.println("1. HashSet");
        System.out.println("2. TreeSet");
        System.out.println("3. HashMap");
        System.out.println("4. TreeMap");
        System.out.println("5. ArrayList");
        System.out.println("6. LinkedList");
    }

    public void addNewPerson(){

    }

    public void erasePerson(){

    }
}
