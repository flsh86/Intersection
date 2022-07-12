package com.company;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


class Main {

  public static String FindIntersection(String[] strArr) {
    HashSet<Integer> frequents = Arrays.stream(strArr)
      .flatMap(
        s-> Arrays.stream(s.replace(", ", " ").split(" "))
      )
      .map(Integer::parseInt)
      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
      .entrySet().stream()
      .filter(entry -> entry.getValue() > 1)
      .map(Map.Entry::getKey)
      .collect(Collectors.toCollection(HashSet::new));
    return frequents.isEmpty() ? "false" : String.join(" ", frequents.toString()).replace("[", "").replace("]", "").replace(" ", "");
  }

}