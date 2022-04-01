package finalExam03;

import java.util.Scanner;
import java.util.regex.Pattern;

public class secretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();

        while (true){
            String[]input = scanner.nextLine().split(":\\|:");
            if (input[0].equals("Reveal")){
                break;
            }
            switch (input[0]){
                case"InsertSpace":
                    int index = Integer.parseInt(input[1]);
                    message = message.substring(0, index) + " " + message.substring(index, message.length());
                    System.out.println(message);
                    break;
                case"Reverse":
                    String entry = input[1];
                    if (message.contains(entry)){
                        String reverse = new StringBuilder(entry).reverse().toString();
                        message = message.replaceFirst(Pattern.quote(entry), "") + reverse;
                        System.out.println(message);
                    }else{
                        System.out.println("error");
                    }
                    break;
                case"ChangeAll":
                    String text = input[1];
                    String replacement = input[2];
                    message = message.replace(text, replacement);
                    System.out.println(message);
                    break;
            }
        }
        System.out.println("You have a new text message: " + message);
    }
}