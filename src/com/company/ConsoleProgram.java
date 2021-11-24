package com.company;

import java.util.*;
import java.util.Set;

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

    public void messageFirst(){
        System.out.println("PROGRAM PREZENTUJĄCY DZIAŁANIE KOLEKCJI");
        System.out.println("Jaką kolekcję utworzyć?");
        System.out.println("1. HashSet");
        System.out.println("2. TreeSet");
        System.out.println("3. HashMap");
        System.out.println("4. TreeMap");
        System.out.println("5. ArrayList");
        System.out.println("6. LinkedList");
        System.out.println("Program zakończy się wpisując cokolwiek innego\n");
    }
    public void messageSecond(){
        System.out.println("Co chcesz zrobić?");
        System.out.println("1. Dodać nową osobę");
        System.out.println("2. Dodać już istniejącą osobę");
    }

    public void runMainLoop(){

        Scanner sc = new Scanner(System.in);

        while(true){
            messageFirst();

            //Jaki rodzaj kolekcji chcemy stworzyć:
            switch(sc.nextInt()){
                case 1:
                    peopleHashSet = new HashSet<>();
                    Loop(peopleHashSet, 1);
                    break;
                case 2:
                    peopleTreeSet = new TreeSet<>();
                    Loop(peopleTreeSet, 2);
                    break;
                case 3:
                    peopleHashMap = new HashMap<>();
                    Loop(peopleHashMap, 3);
                    break;
                case 4:
                    peopleTreeMap = new TreeMap<>();
                    Loop(peopleTreeMap, 4);
                    break;
                case 5:
                    peopleArrayList = new ArrayList<>();
                    Loop(peopleArrayList, 5);
                    break;
                case 6:
                    peopleLinkedList = new LinkedList<>();
                    Loop(peopleLinkedList, 6);
                    break;

            }
        }
    }

    public void Loop(Object people, int info){
        Scanner sc = new Scanner(System.in);
        int rozkaz = 1;

        while(rozkaz == 1){

            messageSecond();

            // Co chcemy zrobić z kolekcją
            try{
                switch(sc.nextInt()){
                    case 1:
                        addNewPerson(people, info);
                        System.out.print("Pracujemy dalej na tej kolekcji? <1 - tak>: ");
                        rozkaz = sc.nextInt();
                        break;
                    case 2:
//                        addNewPerson(peopleTreeSet, 2);
//                        System.out.print("Pracujemy dalej na tej kolekcji? <1 - tak>: ");
//                        rozkaz = sc.nextInt();
//                        break;

                }
            }
            catch (InputMismatchException exception){
                System.out.println("Wpisz liczbę!");
                Loop(people, info);
            }
        }
    }

    public void addNewPerson(Object e, int info){
        Scanner sc = new Scanner(System.in);
        Person person = new Person(1);
        int iterator = -1;


        // info informuje o rodzaju kolekcji

        //HashSet
        if (info == 1) {
            System.out.println("JESTEM");
            do {
                iterator++;
                ((HashSet<Person>) e).add(person);
                System.out.println("Czy chcesz dodać tę samą osobę? <Wpisz 1 i zatwierdź>");
            } while (sc.nextInt() == 1);

            Person comparator = new Person();

            // iteracja w HashSet
            System.out.println("Iteracja: ");
            for (Person x: peopleHashSet){
                System.out.println(x);
                comparator = x;
            }

            System.out.println("\n");

            if (comparator != person){
                System.out.println("No co? To jest HashSet a nie TreeSet i nie muszę, to co wpisałeś, dodawać kolejno do listy!");
            }

            ifAddMore(iterator, person, peopleHashSet);

            System.out.println("Kolekcja wygląda tak: ");
            System.out.println(e);
        }

        //TreeSet
        else if (info == 2){
            do {
                iterator++;
                ((TreeSet<Person>) e).add(person);
                System.out.println("Czy chcesz dodać tę samą osobę? <Wpisz 1 i zatwierdź>");
            } while (sc.nextInt() == 1);

            // iteracja w TreeSet
            System.out.println("Iteracja: ");
            for (Person x: peopleTreeSet){
                System.out.println(x);
            }

            System.out.println("\n");

            ifAddMore(iterator, person, peopleTreeSet);

            System.out.println("Kolekcja wygląda tak: ");
            System.out.println(e);
            System.out.println("Elementy dodawane kolejno :) ");
        }
        else if (info == 3){
            System.out.println("Z czym skojarzyć: ");
            String key = sc.nextLine();

            if(key.equals("firstName")) key = person.getFirstName();
            else if (key.equals("lastName")) key = person.getLastName();

            ((HashMap<String,Person>) e).put(key,person);

            //Kojarzenie kluczy z wartościami
            System.out.println("Wartość odnaleziona do skojarzonej wartości: " + peopleHashMap.get(key)+"\n");

            Person comparator = new Person();

            // iteracja w HashMap po kluczach
            System.out.println("Iteracja po kluczach: ");
            for (String x: peopleHashMap.keySet()){
                System.out.println(x);
            }

            // iteracja w HashMap po wartościach
            System.out.println("Iteracja po wartościach: ");
            for(Person x : peopleHashMap.values()) {
                System.out.println(x);
                comparator = x;
            }

            if (comparator != person){
                System.out.println("No co? To jest HashMap a nie TreeMap i nie muszę, to co wpisałeś, dodawać kolejno do listy!");
            }

            System.out.println("\n");

            System.out.println("Kolekcja wygląda tak: ");
            System.out.println(e);
        }
}

    public void erasePerson(){

    }

    private void ifAddMore(int iterator, Person person, Set<Person> lista) {

        if (iterator > 0) {

            System.out.println("Kolekcja wygląda tak: ");
            System.out.println(peopleHashSet);
            System.out.println("No i po co chciałeś dodawać osoby? Pracujesz na kolekcji Hashset lub TreeSet i to jest bez sensu!");

            System.out.println("Jeśli jednak stoisz przy swoim, to wpisz jeszcze raz TE SAME dane poprzedniej osoby");
            Person person2 = new Person(1);

            while (!(person2.getFirstName().equals(person.getFirstName())) ||
                    !(person2.getLastName().equals(person.getLastName())) ||
                    !(person2.getBirthday().equals(person.getBirthday())) ||
                    !(person2.getJob().equals(person.getJob()))) {

                System.out.println("To nie ta sama osoba! Wpisz jeszcze raz");

                person2.setFirstName();
                person2.setLastName();
                person2.setBirthday();
                person2.setJob();
            }

            lista.add(person2);
            System.out.println("Aha! Tym razem się dodało!");
        }
    }
}
