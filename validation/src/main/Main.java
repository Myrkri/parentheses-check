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
            if (checkParenthesesOrder(letter, parentheses)) {
                parentheses.remove(parentheses.size() - 1);
            } else if (searchableSymbols.contains(letter)) {
                parentheses.add(letter);
            }
        }
        if (parentheses.size() != 0) {
            System.out.println("Parentheses are missing or placed incorrectly");
        } else {
            System.out.println("Sentence looks good");
        }
    }

    private static String readFromInput() {
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static boolean checkParenthesesOrder(final char letter, final List<Character> parentheses) {
        if (parentheses.size() != 0) {
            return letter - 2 == parentheses.get(parentheses.size() - 1) ||
                    letter == ')' && parentheses.get(parentheses.size() - 1) == '(';
        }
        return false;
    }
}
