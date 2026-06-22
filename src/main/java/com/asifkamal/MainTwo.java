package com.asifkamal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

public class MainTwo {

    private static Random random = new Random();

    private record Person(String firstName) {
        public String lastName(String s) {
            return firstName + " " + s.substring(0, s.indexOf(" "));
        }
    }

    public static void main(String[] args) {

        Person person1 = new Person("John");

        String[] arr = {"HaRRy", "PoTTEr", "Ronald", "weasley", "HERMIONE", "gRAINger"};

        List<UnaryOperator<String>> list = new ArrayList<>(List.of(
                String::toUpperCase, //instance method unbounded receiver
                s -> s += " " + getRandomChar('A', 'Z') + ".",
                s -> s += " " + reverse(s, 0, s.indexOf(" ")),
                MainTwo::reverse, //static method reference
                String::new, //String constructor method reference
                String::valueOf,
                person1::lastName // instance method called on an instance using a bounded receiver
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

    private static char getRandomChar(char start, char end) {
        return (char) random.nextInt((int) start, (int) end + 1);

    }

    private static String reverse(String s) {
        return reverse(s, 0, s.length());
    }

    private static String reverse(String s, int start, int end) {
        return new StringBuilder(s.substring(start, end)).reverse().toString();
    }
}
