package finalExam04;

import java.util.Scanner;

public class passwordReset {
      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (true){
            String[]data = scanner.nextLine().split(" ");
            if (data[0].equals("Done")){
                break;
            }
            String cmd = data[0];
            switch (cmd){
                case"TakeOdd":
                    StringBuilder sb = new StringBuilder();
                    for (int i = 1; i <input.length() ; i+=2) {
                        sb.append(input.charAt(i));
                    }
                    input = sb.toString();
                    System.out.println(input);
                    break;
                case"Cut":
                    int index = Integer.parseInt(data[1]);
                    int length = index + Integer.parseInt(data[2]);
                    input = new StringBuilder(input).delete(index, length).toString();
                    System.out.println(input);
                    break;
                case"Substitute":
                    String substring = data[1];
                    String substitute = data[2];
                    if (input.contains(substring)){
                       input = input.replace(substring, substitute);
                        System.out.println(input);
                    }else{
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
        }
        System.out.println("Your password is: " + input);
    }
}
