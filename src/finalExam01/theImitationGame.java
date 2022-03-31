package finalExam01;

import java.util.Scanner;

public class theImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        while(true){
            String[]input = scanner.nextLine().split("\\|");
            if (input[0].equals("Decode")){
                break;
            }
            String cmd = input[0];

            switch(cmd){
                case"Move":
                    int numbers = Integer.parseInt(input[1]);
                    String firstPart = message.substring(0, numbers);
                    String secPart = message.substring(numbers);
                    message = secPart.concat(firstPart);
                    break;
                case"Insert":
                    int index = Integer.parseInt(input[1]);
                    String value = input[2];
                    String firstPart2 = message.substring(0, index);
                    String secPart2 = message.substring(index);
                    message = firstPart2.concat(value).concat(secPart2);
                    break;
                case"ChangeAll":
                    String substring = input[1];
                    String replace = input[2];
                    message = message.replace(substring, replace);
                    break;
            }
        }
        System.out.println("The encrypted message is: " + message);
    }
}