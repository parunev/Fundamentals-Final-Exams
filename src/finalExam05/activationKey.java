package finalExam05;

import java.util.Scanner;

public class activationKey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String key = scanner.nextLine();
        while (true){
            String[]cmdInput = scanner.nextLine().split(">>>");
            if (cmdInput[0].equals("Generate")){break;}

            String cmd = cmdInput[0];
            switch (cmd){
                case"Contains":
                    String substring = cmdInput[1];
                    if (key.contains(substring)){
                        System.out.printf("%s contains %s%n", key, substring);
                    }else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case"Flip":
                    String upLow = cmdInput[1];
                    int startIndex = Integer.parseInt(cmdInput[2]);
                    int endIndex = Integer.parseInt(cmdInput[3]);

                    String word = key.substring(startIndex, endIndex);
                    switch (upLow){
                        case"Upper":
                           word = word.toUpperCase();
                           StringBuilder upper = new StringBuilder();
                           upper.append(key);
                           upper.replace(startIndex, endIndex, word);
                           key = upper.toString();
                            break;
                        case"Lower":
                            word = word.toLowerCase();
                            StringBuilder lower = new StringBuilder();
                            lower.append(key);
                            lower.replace(startIndex, endIndex, word);
                            key = lower.toString();
                            break;
                    }
                    System.out.println(key);
                    break;
                case"Slice":
                    int start = Integer.parseInt(cmdInput[1]);
                    int end = Integer.parseInt(cmdInput[2]);
                    StringBuilder deleter = new StringBuilder();
                    deleter.append(key);
                    deleter.replace(start, end, "");
                    key = deleter.toString();
                    System.out.println(key);
                    break;
            }
        }
        System.out.println("Your activation key is: "+key);
    }
}
