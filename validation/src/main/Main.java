package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        final String input = readFromInput();
        final char[] inputChars = input.toCharArray();
        final List<Character> parentheses = new ArrayList<>();

        final Set<Character> searchableSymbols = Set.of('(', ')', '[', ']', '{', '}', '<', '>');

        for (char letter : inputChars) {
            if (searchableSymbols.contains(letter)) {
                parentheses.add(letter);
            }
        }
        if (parentheses.size() % 2 != 0) {
            System.out.println("One of parentheses is missing.");
        } else {
            System.out.println("Looking good!");
        }
    }

    private static String readFromInput() {
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
