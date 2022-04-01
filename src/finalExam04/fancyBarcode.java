package finalExam04;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class fancyBarcode {
      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <n ; i++) {
            String input = scanner.nextLine();

            Pattern pattern = Pattern.compile("^@#+[A-Z][A-Za-z0-9]{4,}[A-Z]@#+$");
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()){
                String product = matcher.group();
                if (product.matches(".*[0-9].*")){
                    String number = product.replaceAll("[^0-9]","");
                    System.out.printf("Product group: %s%n", number);
                }else{
                    System.out.printf("Product group: 00%n");
                }
            }else{
                System.out.println("Invalid barcode");
            }
        }
    }
}
