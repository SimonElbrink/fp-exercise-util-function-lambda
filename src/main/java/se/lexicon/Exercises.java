package se.lexicon;

import se.lexicon.data.DataStorage;
import se.lexicon.model.Gender;
import se.lexicon.model.Person;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Exercises {

    private final static DataStorage storage = DataStorage.INSTANCE;

    /*
       TODO:  1.	Find everyone that has firstName: “Erik” using findMany().
    */
    public static void exercise1(String message) {
        System.out.println(message);
        //Write your code here
        for(Person p : storage.findMany(person -> person.getFirstName().equalsIgnoreCase("Erik"))){
            System.out.println(p.toString());
        }
        System.out.println("----------------------");
    }

    /*
        TODO:  2.	Find all females in the collection using findMany().
     */
    public static void exercise2(String message) {
        System.out.println(message);
        //Write your code here
        for(Person p : storage.findMany(person -> person.getGender().equals(Gender.FEMALE))){
            System.out.println(p.toString());
        }
        System.out.println("----------------------");
    }

    /*
        TODO:  3.	Find all who are born after (and including) 2000-01-01 using findMany().
     */
    public static void exercise3(String message) {
        System.out.println(message);
        //Write your code here
        Predicate<Person> isbornBefore = person -> person.getBirthDate().isBefore(LocalDate.of(2000,01,01));
        for(Person p:storage.findMany(isbornBefore.negate())){
        //for(Person p : storage.findMany(person -> person.getBirthDate().isBefore(LocalDate.of(2000,01,01)))){
            System.out.println(p.toString());
        }
        System.out.println("----------------------");
    }

    /*
        TODO: 4.	Find the Person that has an id of 123 using findOne().
     */
    public static void exercise4(String message) {
        System.out.println(message);
        //Write your code here
        Person p = storage.findOne(person -> person.getId() == 123);
        System.out.println(p.toString());
        System.out.println("----------------------");

    }

    /*
        TODO:  5.	Find the Person that has an id of 456 and convert to String with following content:
            “Name: Nisse Nilsson born 1999-09-09”. Use findOneAndMapToString().
     */
    public static void exercise5(String message) {
        System.out.println(message);
        //Write your code here
        Predicate<Person> filter = person -> person.getId() == 456;
        Function<Person, String> personToString = person -> "Name: "+person.getFirstName()+" "+person.getLastName()+ " born "+person.getBirthDate();
        System.out.println(storage.findOneAndMapToString(filter,personToString));
        System.out.println("----------------------");
    }

    /*
        TODO:  6.	Find all male people whose names start with “E” and convert each to a String using findManyAndMapEachToString().
     */
    public static void exercise6(String message) {
        System.out.println(message);
        //Write your code here
        Predicate<Person> filter = person -> person.getGender().equals(Gender.MALE) && person.getFirstName().toUpperCase().startsWith("E");
        Function<Person, String> personToString = person -> "Name: "+person.getFirstName()+" "+person.getLastName()+ " born "+person.getBirthDate();
        storage.findManyAndMapEachToString(filter,personToString).forEach(System.out::println);
        System.out.println("----------------------");
    }

    /*
        TODO:  7.	Find all people who are below age of 10 and convert them to a String like this:
            “Olle Svensson 9 years”. Use findManyAndMapEachToString() method.
     */
    public static void exercise7(String message) {
        System.out.println(message);
        //Write your code here
        Predicate<Person> filter = person -> ChronoUnit.YEARS.between(person.getBirthDate(),LocalDate.now()) < 10;
        Function<Person, String> personToString = person -> person.getFirstName()+" "+person.getLastName()+ " "+ ChronoUnit.YEARS.between(person.getBirthDate(),LocalDate.now())+ " years";
        storage.findManyAndMapEachToString(filter,personToString).forEach(System.out::println);
        System.out.println("----------------------");
    }

    /*
        TODO:  8.	Using findAndDo() print out all people with firstName “Ulf”.
     */
    public static void exercise8(String message) {
        System.out.println(message);
        //Write your code here
        Predicate<Person> filter = person -> person.getFirstName().equalsIgnoreCase("Ulf");
        Consumer<Person> consumer = person -> System.out.println(person);
        storage.findAndDo(filter,consumer);
        System.out.println("----------------------");
    }

    /*
        TODO:  9.	Using findAndDo() print out everyone who have their lastName contain their firstName.
     */
    public static void exercise9(String message) {
        System.out.println(message);
        //Write your code here
        Predicate<Person> filter = person -> {
            return person.getLastName().toUpperCase().contains(person.getFirstName().toUpperCase());
        };
        Consumer<Person> consumer = person -> System.out.println(person.toString());
        storage.findAndDo(filter,consumer);
        System.out.println("----------------------");
    }

    /*
        TODO:  10.	Using findAndDo() print out the firstName and lastName of everyone whose firstName is a palindrome.
     */
    public static void exercise10(String message) {
        System.out.println(message);
        //Write your code here
        Predicate<Person> filter = person -> {
            StringBuilder name = new StringBuilder(person.getFirstName());
            return person.getFirstName().equalsIgnoreCase(name.reverse().toString());
        };
        storage.findAndDo(filter,person -> System.out.println(person));

        System.out.println("----------------------");
    }

    /*
        TODO:  11.	Using findAndSort() find everyone whose firstName starts with A sorted by birthdate.
     */
    public static void exercise11(String message) {
        System.out.println(message);
        //Write your code here
        Predicate<Person> filter = person -> person.getFirstName().startsWith("A");
        for(Person p : storage.findAndSort(filter,Comparator.comparing(Person::getBirthDate))){
            System.out.println(p.toString());
        }

        System.out.println("----------------------");
    }

    /*
        TODO:  12.	Using findAndSort() find everyone born before 1950 sorted reversed by latest to earliest.
     */
    public static void exercise12(String message) {
        System.out.println(message);
        //Write your code here
        Predicate<Person> filter = person -> person.getBirthDate().getYear() < 1950;
        for(Person p : storage.findAndSort(filter,Comparator.comparing(Person::getBirthDate).reversed())){
            System.out.println(p.toString());
        }

        System.out.println("----------------------");
    }

    /*
        TODO:  13.	Using findAndSort() find everyone sorted in following order: lastName > firstName > birthDate.
     */
    public static void exercise13(String message) {
        System.out.println(message);
        //Write your code here
        Comparator<Person> comparator = Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName).thenComparing(Person::getBirthDate);
        for(Person p : storage.findAndSort(comparator)){
            System.out.println(p.toString());
        }

        System.out.println("----------------------");
    }
}
