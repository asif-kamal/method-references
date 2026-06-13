package com.asifkamal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

public class MainTwo {

    private static Random random = new Random();

    public static void main(String[] args) {
        String[] arr = {"HaRRy", "PoTTEr", "Ronald", "weasley", "HERMIONE", "gRAINger"};

        List<UnaryOperator<String>> list = new ArrayList<>(List.of(
                String::toUpperCase
        ));

        applyChanges(arr, list);
    }

    private static void applyChanges(String[] names, List<UnaryOperator<String>> changes) {
        List<String> backedByArray = Arrays.asList(names); // create list backed by array, names
        for (var function : changes) { // looping through functions
            backedByArray.replaceAll(s -> s.transform(function)); // operate on each name by function
            System.out.println(Arrays.toString(names));
        }
    }
}
