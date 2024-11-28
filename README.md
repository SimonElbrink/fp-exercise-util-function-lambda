# Functional Interfaces & Lambda Exercise

#### Practicing `java.util.function`

Start by implementing the required methods in the `DataStorageImpl` class.  
To help you get started, I’ve left one example implementation there for reference. 😉

Once you’ve completed the implementations, move on to the exercises in the `Exercises` class.  
Use lambda expressions effectively to complete each task.

---

### **Exercises:**

1. Use `findMany()` to retrieve all individuals with `firstName` equal to "Erik".
2. Use `findMany()` to retrieve all females from the collection.
3. Use `findMany()` to retrieve all individuals born on or after **2000-01-01**.
4. Use `findOne()` to find the `Person` with an `id` of 123.
5. Use `findOneAndMapToString()` to find the `Person` with an `id` of 456,
   then convert them into a `String` with the following format:   
   **"Name: Nisse Nilsson born 1999-09-09"**
6. Use `findManyAndMapEachToString()` to retrieve all male individuals whose names start with "E"
   and convert each to a `String`.
7. Use `findManyAndMapEachToString()` to retrieve all individuals under 10 years old
   and convert them to a `String` with the format:   
   **"Olle Svensson 9 years"**
8. Use `findAndDo()` to print out all individuals whose `firstName` is "Ulf".
9. Use `findAndDo()` to print out all individuals whose `lastName` contains their `firstName`.
10. Use `findAndDo()` to print the `firstName` and `lastName` of all individuals whose `firstName` is a palindrome.
11. Use `findAndSort()` to retrieve all individuals whose `firstName` starts with "A" and sort them by birthdate.
12. Use `findAndSort()` to retrieve all individuals born before **1950**,
    sorted in reverse order from latest to earliest birthdate.
13. Use `findAndSort()` to retrieve all individuals sorted in the following order:  
    **`lastName` > `firstName` > `birthdate`.**