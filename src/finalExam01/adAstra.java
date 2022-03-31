package finalExam01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class adAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("(?<symbols>[#\\\\|])(?<product>[A-Za-z\\s]+)\\1(?<date>[0-9]{2}[\\\\/][0-9]{2}[\\\\/][0-9]{2})\\1(?<calories>[\\d]{1,5})\\1");
        Matcher matcher = pattern.matcher(input);

        int totalCals = 0;
        List<String> calNames = new ArrayList<>();
        while(matcher.find()){
            String productName = matcher.group("product");
            String expirationDate = matcher.group("date");
            int calories = Integer.parseInt(matcher.group("calories"));

            totalCals+=calories;
            calNames.add(String.format("Item: %s, Best before: %s, Nutrition: %d", productName, expirationDate, calories));
        }
        System.out.printf("You have food to last you for: %d days!%n", Math.abs(totalCals/2000));
        calNames.forEach(System.out::println);
    }
}