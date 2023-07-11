package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> list.stream().allMatch(s -> s.matches("[A-Z].*"));
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {

        return list -> {

            var evens = list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
            list.addAll(evens);

        };
    }


    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values.stream().filter(str -> str.matches("[A-Z].*\\.") && str.split("\\s+").length > 3).collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> list.stream().collect(Collectors.toMap(s -> s, s -> s.length()));
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            var result = new ArrayList<>(list1);
            result.addAll(list2);
            return result;
        };
    }
}
