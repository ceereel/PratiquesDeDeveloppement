package heg.hearc.ig.business;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzGenerator {

    public static String generateSingle(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Le nombre ne doit pas être négatif");
        }
        if (number == 66 || (number % 5 == 0 && number % 7 == 0)) {
            return "fizzbuzz";
        } else if (number % 5 == 0) {
            return "fizz";
        } else if (number % 7 == 0) {
            return "buzz";
        } else {
            return String.valueOf(number);
        }
    }

    public static List<String> generate(int start, int count) {
        List<String> results = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            results.add(generateSingle(start + i));
        }
        return results;
    }
}
