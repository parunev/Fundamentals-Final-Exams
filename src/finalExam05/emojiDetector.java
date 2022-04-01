package finalExam05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class emojiDetector {
      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern digitPattern = Pattern.compile("\\d");
        Pattern emojiPattern = Pattern.compile("(?<name>([*]{2})[A-Z][a-z]{2,}([*]{2})|([:]{2})[A-Z][a-z]{2,}([:]{2}))");

        List<String> coolEmoji = new ArrayList<>();
        List<String> emoji = new ArrayList<>();

        int sum = 1;
        Matcher digitMatcher = digitPattern.matcher(input);
        while(digitMatcher.find()) {
            int digit = Integer.parseInt(digitMatcher.group(0));
            sum = sum * digit;
        }

        Matcher emojiMatcher = emojiPattern.matcher(input);
        while(emojiMatcher.find()) {
            String name = emojiMatcher.group("name");
            int sumChar = 0;
            for (int i = 2; i <name.length() - 2 ; i++) {
                char sign = name.charAt(i);
                sumChar += sign;
            }
            emoji.add(name);
            if (sumChar>sum){
                coolEmoji.add(name);
            }
        }
        System.out.printf("Cool threshold: %d%n", sum);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", emoji.size());
        for (String print: coolEmoji){
            System.out.printf("%s%n",print);
        }
    }
}
