package myFinalExam;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("(@+|#+)+(?<color>[a-z]{3,})(@+|#+)+[^\\w\\d]*?/+[0]?(?<amount>[0-9]+)/+");
        Matcher matcher = pattern.matcher(input);

        List<String> eggs = new ArrayList<>();

        while (matcher.find()){
            String egg = matcher.group("color");
            int amount1 = Integer.parseInt(matcher.group("amount"));

            eggs.add(amount1 + " " + egg);
        }
        for (String output:eggs) {
            System.out.printf("You found %s eggs!%n", output);
        }

        }
    }
