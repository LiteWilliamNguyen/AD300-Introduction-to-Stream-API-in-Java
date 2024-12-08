import java.util.*;
import java.util.stream.*;

public class StreamExample {
    public static void main(String[] args) {
        // Initialize a list of integers from 1 to 10
        List<Integer> numbers = IntStream.rangeClosed(1,10).boxed().collect(Collectors.toList());

        //Task 5: Advanced Stream Operations
        //Use the flatMap method to flatten a list of lists into a single list.
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );
        List<Integer> flattenedList = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("\nFlattened List: " + flattenedList);

        //Use the groupingBy collector to group numbers by even and odd.
        Map<String, List<Integer>> groupedNumbers = numbers.stream()
                .collect(Collectors.groupingBy(num -> num % 2 == 0 ? "Even" : "Odd"));
        System.out.println("\nGrouped Numbers: " + groupedNumbers);

        //Task 6: Stream with Custom Objects
        //Create a Person class with fields name and age.
        //Create a list of Person objects.
        List<Person> people = Arrays.asList(
                new Person("Harry Potter", 26),
                new Person("Hermione Granger", 26),
                new Person("Ron Weasley", 26),
                new Person("Ginny Weasley",24)
        );
        //Use the Stream API to filter out people older than 25 and print their names.
        // Filter people older than 25 and print their names
        System.out.println("\nPeople Older Than 25:");
        people.stream()
                .filter(person -> person.getAge() > 25)
                .map(Person::getName)
                .forEach(System.out::println);

        //Use the Stream API to find the oldest person in the list.
        Optional<Person> oldestPerson = people.stream()
                .max(Comparator.comparingInt(Person::getAge));
        oldestPerson.ifPresent(person ->
                System.out.println("\nOldest Person: " + person.getName() + ", Age: " + person.getAge())
        );
    }

    //Task 3: Intermediate Operations
    //Use the Stream API to filter out even numbers and print them.
    public static List<Integer> filterEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
    }

    //Use the Stream API to map the list of numbers to their squares and print the squared values.
    public static List<Integer> mapToSquares(List<Integer> numbers) {
        return numbers.stream().map(num -> num * num).collect(Collectors.toList());
    }

    //Combine filtering and mapping: Filter out odd numbers and then map them to their cubes.
    public static List<Integer> filterOddAndMapToCubes(List<Integer> numbers){
        return numbers.stream().
                filter(num -> num % 2 != 0).
                map(num -> num * num * num).
                collect(Collectors.toList());
    }

    //Task 4: Terminal Operations
    //Use the reduce method to sum all the numbers in the list.
    public static int sumNumbers(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);

    }
    //Use the collect method to gather all even numbers into a new list.
    public static List<Integer> gatherNumbers(List<Integer> evenNumbers){
        return evenNumbers.stream().filter(num -> num%2 == 0).collect(Collectors.toList());
    }

}



// Define the Person class for Task 6
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}