package finalExam03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class mirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("(?<symbols>[@#])(?<word>[A-Za-z]{3,})\\1\\1(?<mirror>[A-Za-z]{3,})\\1");
        Matcher matcher = pattern.matcher(input);

        List<String> matches = new ArrayList<>();
        int count = 0;
        while (matcher.find()){
            String firstWord = matcher.group("word");
            String secondWord = matcher.group("mirror");
            count++;

            String reversed = new StringBuilder(secondWord).reverse().toString();
            if (firstWord.equals(reversed)){
                matches.add(firstWord + " <=> " + secondWord);
            }
        }
        if (count == 0){
            System.out.println("No word pairs found!");
        }else{
            System.out.printf("%d word pairs found!%n", count);
        }
        if (matches.isEmpty()){
            System.out.println("No mirror words!");
        }else{
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", matches));
        }
    }
}
