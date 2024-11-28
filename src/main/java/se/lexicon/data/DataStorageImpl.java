package se.lexicon.data;


import se.lexicon.model.Person;
import se.lexicon.util.PersonGenerator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


/**
 * Create implementations for all methods.
 * I have already provided an implementation for the first method.
 */
public class DataStorageImpl implements DataStorage {

    private static final DataStorage INSTANCE;

    static {
        INSTANCE = new DataStorageImpl();
    }

    private final List<Person> personList;

    private DataStorageImpl() {
        personList = PersonGenerator.getInstance().generate(1000);
    }

    static DataStorage getInstance() {
        return INSTANCE;
    }


    @Override
    public List<Person> findMany(Predicate<Person> filter) {
        List<Person> result = new ArrayList<>();
        for (Person person : personList) {
            if (filter.test(person)) {
                result.add(person);
            }
        }
        return result;
    }

    @Override
    public Person findOne(Predicate<Person> filter) {
        //todo: implement the method
        for (Person person : personList) {
            if (filter.test(person)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public String findOneAndMapToString(Predicate<Person> filter, Function<Person, String> personToString) {
        //todo: implement the method
        Person person = findOne(filter);
        return person == null ? null : personToString.apply(person);

    }

    @Override
    public List<String> findManyAndMapEachToString(Predicate<Person> filter, Function<Person, String> personToString) {
        //todo: implement the method
        List<Person> persons = findMany(filter);
        List<String> personsTostrings= new ArrayList<>();
        for(Person p: persons){
            personsTostrings.add(personToString.apply(p));
        }
        return personsTostrings;
    }

    @Override
    public void findAndDo(Predicate<Person> filter, Consumer<Person> consumer) {
        //todo: implement the method
        List<Person> persons = findMany(filter);
        //persons.forEach(consumer);

        for(Person person : persons) {
            consumer.accept(person);
        }
    }

    @Override
    public List<Person> findAndSort(Comparator<Person> comparator) {
        //todo: implement the method
        List<Person> sortedPersons = new ArrayList<>(personList);
        sortedPersons.sort(comparator);
        return sortedPersons;
    }

    @Override
    public List<Person> findAndSort(Predicate<Person> filter, Comparator<Person> comparator) {
        //todo: implement the method
        List<Person> sortedPersons = findMany(filter);
        sortedPersons.sort(comparator);
        return sortedPersons;
    }
}
