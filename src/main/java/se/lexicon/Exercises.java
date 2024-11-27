package se.lexicon;

import org.w3c.dom.ls.LSOutput;
import se.lexicon.data.DataStorage;
import se.lexicon.data.DataStorageImpl;
import se.lexicon.model.Gender;
import se.lexicon.model.Person;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;

public class Exercises {

    private final static DataStorage storage = DataStorage.INSTANCE;

    /*
       TODO:  1.	Find everyone that has firstName: “Erik” using findMany().
    */
    public static void exercise1(String message) {
        System.out.println(message);


        List<Person> persons = storage.findMany(person -> person.getFirstName().equalsIgnoreCase("Erik"));

        //System.out.println(persons.toString());


        System.out.println("----------------------");
    }

    /*
        TODO:  2.	Find all females in the collection using findMany().
     */
    public static void exercise2(String message) {
        System.out.println(message);
        List<Person> persons = storage.findMany(person -> person.getGender() == Gender.FEMALE);

        System.out.println(persons.toString());

        System.out.println("----------------------");
    }

    /*
        TODO:  3.	Find all who are born after (and including) 2000-01-01 using findMany().
     */
    public static void exercise3(String message) {
        System.out.println(message);

        LocalDate date = LocalDate.parse("2000-01-01");

        List<Person> persons = storage.findMany(person -> person.getBirthDate().isAfter(date) || person.getBirthDate().equals(date));

        persons.forEach(System.out::println);

        System.out.println("----------------------");

    }

    /*
        TODO: 4.	Find the Person that has an id of 123 using findOne().
     */
    public static void exercise4(String message) {
        System.out.println(message);
        Integer id = 123;

        Person person = storage.findOne(p -> p.getId() == id);

        System.out.println("And the person is: " + person.toString());

        System.out.println("----------------------");

    }

    /*
        TODO:  5.	Find the Person that has an id of 456 and convert to String with following content:
            “Name: Nisse Nilsson born 1999-09-09”. Use findOneAndMapToString().
     */
    public static void exercise5(String message) {
        System.out.println(message);

        Integer id = 456;

       String person = storage.findOneAndMapToString(p1 ->
                       p1.getId() == id, person1 ->
               "Name: " +person1.getFirstName() + " " + person1.getLastName() + " born " + person1.getBirthDate()
       );

        System.out.println(person);

        System.out.println("----------------------");
    }

    /*
        TODO:  6.	Find all male people whose names start with “E” and convert each to a String using findManyAndMapEachToString().
     */
    public static void exercise6(String message) {
        System.out.println(message);

        List<String> persons = storage.findManyAndMapEachToString(p1 ->
                p1.getFirstName().startsWith("E") && p1.getGender()==Gender.MALE, p2 ->
                "Name: " + p2.getFirstName() + " " + p2.getLastName() + " with id " + p2.getId() + "\n"
        );

        System.out.println(persons.toString());

        System.out.println("----------------------");
    }

    /*
        TODO:  7.	Find all people who are below age of 10 and convert them to a String like this:
            “Olle Svensson 9 years”. Use findManyAndMapEachToString() method.
     */
    public static void exercise7(String message) {
        System.out.println(message);

        LocalDate todayDate = LocalDate.now();

        List<String> persons = storage.findManyAndMapEachToString(p1 ->
                Period.between(p1.getBirthDate(), todayDate).getYears() < 10, p2 ->
                p2.getFirstName() + " " + p2.getLastName() + " " + Period.between(p2.getBirthDate(), todayDate).getYears() + " years \n"
        );

        System.out.println(persons.toString());

        System.out.println("----------------------");
    }

    /*
        TODO:  8.	Using findAndDo() print out all people with firstName “Ulf”.
     */
    public static void exercise8(String message) {
        System.out.println(message);

        storage.findAndDo(person -> person.getFirstName().equals("Ulf"), System.out::println);


        System.out.println("----------------------");
    }

    /*
        TODO:  9.	Using findAndDo() print out everyone who have their lastName contain their firstName.
     */
    public static void exercise9(String message) {
        System.out.println(message);

        storage.findAndDo(person -> person.getLastName().contains(person.getFirstName()),System.out::println);

        System.out.println("----------------------");
    }

    /*
        TODO:  10.	Using findAndDo() print out the firstName and lastName of everyone whose firstName is a palindrome.
     */

    // This method is used to solve exercise 10 - checking if a name is a palindrome returning a boolean
    public static boolean isPalindrome (Person person){

        char [] nameArray = person.getFirstName().toLowerCase().toCharArray();
        char [] reversedNameArray = new char[nameArray.length];
        int counter = 0;


        // reversing the name into reversedNameArray
        for (int i = nameArray.length-1; i >= 0; --i) {

            reversedNameArray[counter] = nameArray[i];
            counter ++;
        }
        if (Arrays.equals(reversedNameArray, nameArray)) {

            return true;
        }

        return false;
    }

    public static void exercise10(String message) {
        System.out.println(message);

        storage.findAndDo(person -> isPalindrome(person), p2 -> System.out.println(p2.getFirstName()+ " " + p2.getLastName())
        );

        System.out.println("----------------------");

    }


    /*
        TODO:  11.	Using findAndSort() find everyone whose firstName starts with A sorted by birthdate.
     */
    public static void exercise11(String message) {
        System.out.println(message);



        System.out.println("----------------------");
    }

    /*
        TODO:  12.	Using findAndSort() find everyone born before 1950 sorted reversed by lastest to earliest.
     */
    public static void exercise12(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        TODO:  13.	Using findAndSort() find everyone sorted in following order: lastName > firstName > birthDate.
     */
    public static void exercise13(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }
}
