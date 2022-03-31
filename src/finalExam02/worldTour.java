package finalExam02;

import java.util.Scanner;

public class worldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String destinations = scanner.nextLine();
        while(true){
            String[]input = scanner.nextLine().split(":");
            if (input[0].equals("Travel")){
                break;
            }
            String cmd = input[0];
            switch (cmd){
                case"Add Stop":
                    int index = Integer.parseInt(input[1]);
                    String data = input[2];
                    if (index >= 0 && index < destinations.length()){
                        String firstSplit =destinations.substring(0, index).concat(data);
                        String secondSplit = destinations.substring(index);
                        destinations = firstSplit + secondSplit;
                    }
                    System.out.println(destinations);
                    break;
                case"Remove Stop":
                    int startIndex = Integer.parseInt(input[1]);
                    int endIndex = Integer.parseInt(input[2]);
                    if (startIndex >= 0 && startIndex < destinations.length() && endIndex >= 0 && endIndex < destinations.length()){
                        String split = destinations.substring(startIndex, endIndex+1);
                        destinations = destinations.replace(split, "");
                    }
                    System.out.println(destinations);
                    break;
                case"Switch":
                    String oldString = input[1];
                    String newString = input[2];
                    if (destinations.contains(oldString)){
                        destinations = destinations.replace(oldString, newString);
                    }
                    System.out.println(destinations);
                    break;
            }
        }
        System.out.printf("Ready for world tour! Planned stops: %s%n", destinations);
    }
}
