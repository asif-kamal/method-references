package com.asifkamal;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

class PlainOld {
    private static int last_id = 1;
    private int id;

    public PlainOld() {
        this.id = last_id++;
        System.out.println("Plain Old Constructor id " + id);
    }
}

public class Main {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of("Anna", "Bob", "Chuck", "Dave"));
        list.forEach(System.out::println);

        //static method on a class, class type on the left
        calculator(Integer::sum, 5, 10);
        calculator(Integer::max, 5, 10);
        calculator(Integer::min, 5, 10);
        calculator(Double::sum, 5.4, 10.6);

        Supplier<PlainOld> reference1 = PlainOld::new;

        PlainOld reference2 = reference1.get();
    }

    private static <T> void calculator(BinaryOperator<T> function, T value1, T value2) {
        T result = function.apply(value1, value2);
        System.out.println("Result: " + result);

    }
}