package io.javabrains.reactiveworkshop.predicates;


import java.util.function.Predicate;

/**
 * @author Bl4kee
 * @since 05-07-2022
 */
public class ExercisePredicates {

  public static Predicate<Integer> isLessThan5() {
    return number -> number < 5;
  }

  public static Predicate<Integer> isGreaterThan5() {
    return number -> number > 5;
  }
}
