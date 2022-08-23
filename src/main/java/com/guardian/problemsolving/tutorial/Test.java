package com.guardian.problemsolving.tutorial;

public class Test {
    public static void main(String[] args) {
        Person sonali = new Person();
        sonali.name = "Sonali";
        sonali.age = 26;
        sonali.gender = "F";

        Person rahul = new Person();
        rahul.name = "Rahul";
        rahul.age = 30;
        rahul.gender = "M";

        sonali.laugh();
        rahul.laugh();

        sonali.die();

        Person.born();

        String val = sonali.laugh("x");
        System.out.println(val);

        rahul.age = 31;
        sonali.printAge();
        rahul.printAge();


        for(String arg : args){
            System.out.println(arg);
        }
        System.out.println(Integer.parseInt(args[0])+Integer.parseInt(args[1])+Integer.parseInt(args[2]));
    }
}

class Person{
    String name;
    int age;
    String gender;

    static boolean hasNose = true;

    public void laugh(){
        if(gender.equalsIgnoreCase("M"))
            System.out.println("Haha");
        else
            System.out.println("Hihi");
    }

    public String laugh(String x){
        if(gender.equalsIgnoreCase("M"))
            return "Haha";
        else
            return "Hihi";
    }

    public void printAge(){
        System.out.println(age);
    }

    public void die(){
        System.out.println("Dead");
    }

    public static void born(){
        System.out.println(hasNose);
        System.out.println("Born");
    }
}




