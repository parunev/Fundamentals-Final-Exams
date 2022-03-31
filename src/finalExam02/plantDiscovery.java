package finalExam02;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class plantDiscovery {
      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Integer> plants = new LinkedHashMap<>();
        LinkedHashMap<String, List<Double>> rating = new LinkedHashMap<>();

        for (int i = 0; i <n ; i++) {
            String[]input = scanner.nextLine().split("<->");
            String plant = input[0];
            int rarity = Integer.parseInt(input[1]);
            plants.compute(plant, (k,v)->rarity);
            rating.put(plant, new ArrayList<>());
        }

        while (true){
            String input = scanner.nextLine();
            if(input.equals("Exhibition")){
                break;
            }
            String[]tokens = input.split(": ");
            String command = tokens[0];
            String[]elements = tokens[1].split(" - ");
            String plant = elements[0];

            if (!plants.containsKey(plant)){
                System.out.println("error");
                continue;
            }

            switch (command){
                case"Rate":
                    double inputRate = Double.parseDouble(elements[1]);
                    rating.get(plant).add(inputRate);
                    break;
                case"Update":
                    int rarity = Integer.parseInt(elements[1]);
                    plants.compute(plant, (k,v)->rarity);
                    break;
                case"Reset":
                    rating.get(plant).clear();
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        }
        System.out.println("Plants for the exhibition:");
        plants.entrySet().stream().forEach(e-> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", e.getKey(),e.getValue()
        ,rating.get(e.getKey()).stream().mapToDouble(Double::doubleValue).average().orElse(0.0)));
    }
}
