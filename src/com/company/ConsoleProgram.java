package com.company;

import java.util.*;
import java.util.Set;

public class ConsoleProgram {

    private HashSet<Person> peopleHashSet;
    private HashSet<Person> peopleHashSet2;
    private TreeSet<Person> peopleTreeSet;
    private HashMap<String,Person> peopleHashMap;
    private TreeMap<String,Person> peopleTreeMap;
    private ArrayList<Person> peopleArrayList;
    private LinkedList<Person> peopleLinkedList;

    //--------------------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        ConsoleProgram app = new ConsoleProgram();
        app.runMainLoop();
    }

    //--------------------------------------------------------------------------------------------------------------------------

    public void messageFirst(){
        System.out.println("\nPROGRAM PREZENTUJĄCY DZIAŁANIE KOLEKCJI");
        System.out.println("Jaką kolekcję utworzyć?");
        System.out.println("1. HashSet");
        System.out.println("2. TreeSet");
        System.out.println("3. HashMap");
        System.out.println("4. TreeMap");
        System.out.println("5. ArrayList");
        System.out.println("6. LinkedList");
        System.out.println("Program zakończy się wpisując cokolwiek innego\n");
    }

    //--------------------------------------------------------------------------------------------------------------------------

    public void runMainLoop(){

        Scanner sc = new Scanner(System.in);

        while(true){
            messageFirst();

            //Jaki rodzaj kolekcji chcemy stworzyć:
            switch(sc.nextInt()){
                case 1:

                    peopleHashSet = new HashSet<>();
                    peopleHashSet2 = new HashSet<>();
                    System.out.println("Ze zdefiniowanymi metodami equals() i hashcode()? Jeśli tak wpisz 1");
                    if(sc.nextInt()!=1) Loop(peopleHashSet, 1);
                    else Loop(peopleHashSet2, 7);
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
                default:
                    System.out.println("Program zakończył pracę");
                    System.exit(0);

            }
        }
    }

    //--------------------------------------------------------------------------------------------------------------------------

    public void Loop(Object people, int info){
        Scanner sc = new Scanner(System.in);
        int rozkaz = 1;

        System.out.println("Podaj dane aby je dodać do kolekcji: \n");

        while(rozkaz == 1){

            // Co chcemy zrobić z kolekcją
            try{
                addNewPerson(people, info);
                System.out.print("Pracujemy dalej na tej kolekcji? <1 - tak>: ");
                rozkaz = sc.nextInt();
            }
            catch (InputMismatchException exception){
                System.out.println("Wpisz liczbę!");
                Loop(people, info);
            }
        }
    }

//--------------------------------------------------------------------------------------------------------------------------

    public void addNewPerson(Object e, int info){
        Scanner sc = new Scanner(System.in);
        int iterator = -1;


        // "info" informuje o rodzaju kolekcji


        //HashSet
        if (info == 1) {
            Person person = new Person(1);
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
            System.out.println(peopleHashSet);
        }

        if (info == 7) {

                System.out.println("Witaj w odświeżonej wersji kolekcji HashSet. Teraz jeśli wpiszesz dwie takie same osoby(to samo imie, nazwisko i data urodzenia), to nie ma " +
                        "mowy,\n żeby znalazły się one w tej samej kolekcji\n");

                BetterPerson betterperson= new BetterPerson();
                do {
                    peopleHashSet2.add(betterperson);
                    System.out.println("Czy chcesz dodać tę samą osobę? <Wpisz 1 i zatwierdź>");
                } while (sc.nextInt() == 1);

                System.out.println("Iteracja: ");
                for (Person x: peopleHashSet2){
                    System.out.println(x);
                }

                System.out.println("\n");

                System.out.println("Kolekcja wygląda tak: ");
                System.out.println(peopleHashSet2);
        }



        //TreeSet
        else if (info == 2){
            Person person= new Person(1);
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
            System.out.println(peopleTreeSet);
            System.out.println("Elementy dodawane kolejno :) ");
        }


        ////HashMap
        else if (info == 3){
            Person person= new Person(1);
            System.out.println("Z czym skojarzyć: ");
            String key = sc.nextLine();

            //Każda wartość ma swój unikalny klucz
            for (String x: peopleHashMap.keySet()){
                while(key.equals(x)) {
                    System.out.println("Ten klucz był już podany! Wymyśl inny aby nie nadpisać danych z kolekcji: ");
                    key = sc.nextLine();
                }
            }

//            if(key.equals("firstName")) key = person.getFirstName();
//            else if (key.equals("lastName")) key = person.getLastName();

            ((HashMap<String,Person>) e).put(key,person);

            //Kojarzenie kluczy z wartościami
            String associate;
            System.out.println("Podaj klucz a ja odnajdę wartość: ");
            associate = sc.nextLine();
            System.out.println("Wartość odnaleziona do skojarzonej wartości: " + peopleHashMap.get(associate)+"\n");

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
            System.out.println(peopleHashMap);
        }


        ////TreeMap
        else if (info == 4){
            Person person= new Person(1);
            System.out.println("Z czym skojarzyć: ");
            String key = sc.nextLine();

            //Każda wartość ma swój unikalny klucz
            for (String x: peopleTreeMap.keySet()){
                while(key.equals(x)) {
                    System.out.println("Ten klucz był już podany! Wymyśl inny aby nie nadpisać danych z kolekcji: ");
                    key = sc.nextLine();
                }
            }

            //Klucz przyporządkowany do imienia lub nazwiska (np. w celu alfabetycznego porządku)
            //Jeśli jako klucz podamy "firstName"/"lastName" to automatycznie przyjmie on wartość pierwszej
            //Litery imienia/nazwiska
            if(key.equals("firstName")) key = person.getFirstName().substring(0, 1);
            else if (key.equals("lastName")) key = person.getLastName().substring(0, 1);

            ((TreeMap<String,Person>) e).put(key,person);

            //Kojarzenie kluczy z wartościami
            String associate;
            System.out.println("Podaj klucz a ja odnajdę wartość: ");
            associate = sc.nextLine();
            System.out.println("Wartość odnaleziona do skojarzonej wartości: " + peopleTreeMap.get(associate)+"\n");

            // iteracja w TreeMap po kluczach
            System.out.println("Iteracja po kluczach: ");
            for (String x: peopleTreeMap.keySet()){
                System.out.println(x);
            }

            // iteracja w TreeMap po wartościach
            System.out.println("Iteracja po wartościach: ");
            for(Person x : peopleTreeMap.values()) {
                System.out.println(x);
            }

            System.out.println("\n");

            System.out.println("Kolekcja wygląda tak (): ");
            System.out.println(peopleTreeMap);
        }


        ////ArrayList
        else if (info == 5){
            Person person= new Person(1);
            peopleArrayList.add(person);


            //mierzenie czasu wykonania operacji
            //różnica między szybkością działania ArrayList i LinkedList

            System.out.println("Czy chcesz dodać tę samą osobę 1000000 razy? <Wpisz 1 i zatwierdź>: ");
            if(sc.nextLine().equals("1")){
                long millisActualTime = System.currentTimeMillis();
                for(int i=0; i<1000000; i++){
                    peopleArrayList.add(person);
                }
                long executionTime = System.currentTimeMillis();
                long time = executionTime - millisActualTime;

                System.out.println("Czas wykonania operacji: " + time);
            }

            if(peopleArrayList.size()<999999) {
                System.out.println("Iteracja: ");
                for (Person x : peopleArrayList) {
                    System.out.println(x);
                }
                System.out.println("\n");

                System.out.println("Kolekcja wygląda tak: ");
                System.out.println(peopleArrayList);
                System.out.println("Elementy dodawane kolejno :) ");
            }
        }



        ////LinkedList
        else if (info == 6){
            Person person= new Person(1);
            peopleArrayList.add(person);

            //mierzenie czasu wykonania operacji
            //różnica między szybkością działania ArrayList i LinkedList

            System.out.println("Czy chcesz dodać tę samą osobę 1000000 razy? <Wpisz 1 i zatwierdź>: ");
            if(sc.nextLine().equals("1")){
                long millisActualTime = System.currentTimeMillis();
                for(int i=0; i<1000000; i++){
                    peopleLinkedList.add(person);
                }
                long executionTime = System.currentTimeMillis();
                long time = executionTime - millisActualTime;

                System.out.println("Czas wykonania operacji: " + time);
            }

            // iteracja w LinkedList
            if(peopleLinkedList.size()<999999){
                System.out.println("Iteracja: ");
                for (Person x: peopleLinkedList){
                    System.out.println(x);
                }
                System.out.println("\n");

                System.out.println("Kolekcja wygląda tak: ");
                System.out.println(peopleLinkedList);
                System.out.println("Elementy dodawane kolejno :) ");
            }

            System.out.println(peopleLinkedList.size());
        }
}

    //--------------------------------------------------------------------------------------------------------------------------

    private void ifAddMore(int iterator, Person person, Set<Person> lista) {

        if (iterator > 0) {

            System.out.println("Kolekcja wygląda tak: ");
            System.out.println(peopleHashSet);
            System.out.println("\nNo i po co chciałeś dodawać osoby? Pracujesz na kolekcji Hashset lub TreeSet i to jest bez sensu!");

            System.out.println("Jeśli jednak stoisz przy swoim, to wpisz jeszcze raz TE SAME dane poprzedniej osoby\n");
            Person person2 = new Person(1);

            while (!(person2.getFirstName().equals(person.getFirstName())) ||
                    !(person2.getLastName().equals(person.getLastName())) ||
                    !(person2.getBirthday() == person.getBirthday()) ||
                    !(person2.getJob().equals(person.getJob()))) {

                System.out.println("To nie ta sama osoba! Wpisz jeszcze raz");

                person2.setFirstName();
                person2.setLastName();
                person2.setBirthday();
                person2.setJob();
            }

            lista.add(person2);
            System.out.println("Aha! Tym razem się dodało pomimo tych samych wartości! Jeśli nie chcesz takiego dziwnego" +
                    "\n efektu, użyj obiektów klasy ze zdefiniowanymi metodami equals() i hashcode() do" +
                    "\n przechowywania je w kolekcji HashSet\n");
        }
    }
}
