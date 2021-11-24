package com.company;

import java.util.Scanner;

public class Person implements Comparable<Person>{

    private String firstName;
    private String lastName;
    private String birthday;
    private String job;

    Person(){

    }

    Person(int putData){
        setFirstName();
        setLastName();
        setBirthday();
        setJob();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthday() {
        return birthday;
    }

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
        this.birthday = sc.nextLine();
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

    @Override
    public int compareTo(Person p){
        return 1;
    }

}
