package myFinalExam;

import java.util.Locale;
import java.util.Scanner;

public class P01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (true){
            String[]tokens = scanner.nextLine().split(" ");
            if (tokens[0].equals("Abracadabra")){
                break;
            }
            String cmd = tokens[0];
            switch (cmd){
                case"Abjuration":
                    input = input.toUpperCase();
                    System.out.println(input);
                    break;
                case"Necromancy":
                    input = input.toLowerCase(Locale.ROOT);
                    System.out.println(input);
                    break;
                case"Illusion":
                    int index = Integer.parseInt(tokens[1]);
                    String letter = tokens[2];
                    if (index >= 0 && index < input.length()){
                        input = input.substring(0, index) + letter + input.substring(index + 1);
                        System.out.println("Done!");
                    }else{
                        System.out.println("The spell was too weak.");
                    }
                    break;
                case"Divination":
                    String firstString = tokens[1];
                    String secondString = tokens[2];
                    if (input.contains(firstString)){
                        input = input.replaceAll(firstString, secondString);
                        System.out.println(input);
                    }
                    break;
                case"Alteration":
                    String substring = tokens[1];
                    if (input.contains(substring)){
                        input = input.replace(substring, "");
                        System.out.println(input);
                    }
                    break;
                default:
                    System.out.println("The spell did not work!");
            }
        }
    }
}
