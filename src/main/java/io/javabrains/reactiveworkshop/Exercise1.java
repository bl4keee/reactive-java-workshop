package io.javabrains.reactiveworkshop;

import java.util.List;

import static io.javabrains.reactiveworkshop.predicates.ExercisePredicates.isGreaterThan5;
import static io.javabrains.reactiveworkshop.predicates.ExercisePredicates.isLessThan5;
import static java.util.stream.Collectors.toList;

public class Exercise1 {

  public static void main(String[] args) {

    // Use StreamSources.intNumbersStream() and StreamSources.userStream()

    // 1. Print all numbers in the intNumbersStream stream
    StreamSources.intNumbersStream().forEach(System.out::println);

    // 2. Print numbers from intNumbersStream that are less than 5
    StreamSources.intNumbersStream()
        .filter(isLessThan5())
        .forEach(System.out::println);

    // 3. Print the second and third numbers in intNumbersStream that's greater than 5
    StreamSources.intNumbersStream()
        .filter(isGreaterThan5())
        .skip(1)
        .limit(2)
        .forEach(System.out::println);

    //  4. Print the first number in intNumbersStream that's greater than 5.
    //    If nothing is found, print -1
    Integer result = StreamSources.intNumbersStream()
        .filter(isGreaterThan5())
        .findFirst()
        .orElse(-1);

    System.out.println(result);

    // 5. Print first names of all users in userStream
    StreamSources.userStream()
        .map(User::getFirstName)
        .forEach(System.out::println);

    // 6. Print first names in userStream for users that have IDs from number stream

    // a) first solution
    List<Integer> userIds = StreamSources.intNumbersStream().collect(toList());
    StreamSources.userStream()
        .filter(user -> userIds.contains(user.getId()))
        .map(User::getFirstName)
        .forEach(System.out::println);

    // b) second solution
    StreamSources.intNumbersStream()
        .flatMap(userId -> StreamSources.userStream().filter(user -> user.getId() == userId))
        .map(User::getFirstName)
        .forEachOrdered(System.out::println);

  }

}
