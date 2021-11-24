package com.company;

import java.util.Scanner;

public class Person implements Comparable{

    protected String firstName;
    protected String lastName;
    protected int birthday;
    protected String job;

    //--------------------------------------------------------------------------------------------------------------------------

    Person(){

    }

    //--------------------------------------------------------------------------------------------------------------------------

    Person(int putData){
        setFirstName();
        setLastName();
        setBirthday();
        setJob();
    }

    //--------------------------------------------------------------------------------------------------------------------------

    public String getFirstName() {
        return firstName;
    }

    //--------------------------------------------------------------------------------------------------------------------------

    public String getLastName() {
        return lastName;
    }

    //--------------------------------------------------------------------------------------------------------------------------

    public int getBirthday() {
        return birthday;
    }

    //--------------------------------------------------------------------------------------------------------------------------

    public String getJob() {
        return job;
    }

    public void setFirstName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj imię: ");
        this.firstName = sc.nextLine();
    }
    public void setLastName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj nazwisko: ");
        this.lastName = sc.nextLine();
    }
    public void setBirthday(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj datę urodzenia: ");
        this.birthday = sc.nextInt();
    }
    public void setJob(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj pracę: ");
        this.job = sc.nextLine();
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    // Uporządkowanie zgodne z kolejnością dodawania (TreeSet)
    // Jeśli chcielibyśmy aby uporządkowanie w kolekcji Treeset było inne np. alfabetycznie dla
    // nazwiska, możemy zamiast "return 1;", użyć "return getLastName().compareTo(((Person)p).getLastName());"
    @Override
    public int compareTo(Object p){
        return getLastName().compareTo(((Person)p).getLastName());
    }

}
