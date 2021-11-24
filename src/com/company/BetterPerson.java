package com.company;

public class BetterPerson extends Person{

    BetterPerson(){
        super(1);
    }

    @Override
    public boolean equals(Object obj) {

        if (this==obj) return true;
        if(obj==null || getClass() != obj.getClass()) return false;


        Person person = (Person)obj;

        if(!(getBirthday() == person.getBirthday())) return false;
        if(getFirstName() != null ? !getFirstName().equals(person.getFirstName()) : person.getFirstName() != null)
            return false;
        return getLastName().equals(person.getLastName());
    }

    //--------------------------------------------------------------------------------------------------------------------------

    @Override
    public int hashCode(){
        int result = getFirstName() != null ? getFirstName().hashCode() : 0;
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getBirthday();
        return result;
    }

}
