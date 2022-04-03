package finalExam05;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<Integer>> cities = new LinkedHashMap<>();
        while (true){
            String[]dataInput = scanner.nextLine().split("\\|");
            if (dataInput[0].equals("Sail")){break;}
            if (cities.containsKey(dataInput[0])){
                int currentPopulation = cities.get(dataInput[0]).get(0);
                int currentGold = cities.get(dataInput[0]).get(1);
                cities.get(dataInput[0]).set(0, currentPopulation + Integer.parseInt(dataInput[2]));
                cities.get(dataInput[0]).set(1, currentGold + Integer.parseInt(dataInput[4]));
            }else{
                cities.put(dataInput[0],new ArrayList<>());
                cities.get(dataInput[0]).add(Integer.parseInt(dataInput[2]));
                cities.get(dataInput[0]).add(Integer.parseInt(dataInput[4]));
            }
        }
        while (true){
            String[]eventsInput = scanner.nextLine().split("=>");
            if (eventsInput[0].equals("End")){break;}
            switch (eventsInput[0]){
                case"Plunder":
                    int currentPopulation = cities.get(eventsInput[1]).get(0);
                    int currentGold = cities.get(eventsInput[1]).get(1);
                    currentPopulation -= Integer.parseInt(eventsInput[2]);
                    currentGold -= Integer.parseInt(eventsInput[3]);
                    cities.get(eventsInput[1]).set(0, currentPopulation);
                    cities.get(eventsInput[1]).set(1, currentGold);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", eventsInput[1], Integer.parseInt(eventsInput[3]), Integer.parseInt(eventsInput[2]));
                    if (currentGold <= 0 || currentPopulation <=0){
                        cities.remove(eventsInput[1]);
                        System.out.printf("%s has been wiped off the map!%n", eventsInput[1]);
                    }
                    break;
                case"Prosper":
                    int currentVaultGold = cities.get(eventsInput[1]).get(1);
                    if (Integer.parseInt(eventsInput[2]) < 0){
                        System.out.println("Gold added cannot be a negative number!");
                    }else{
                        currentVaultGold += Integer.parseInt(eventsInput[2]);
                        cities.get(eventsInput[1]).set(1, currentVaultGold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", Integer.parseInt(eventsInput[2]), eventsInput[1], cities.get(eventsInput[1]).get(1));
                    }
                    break;
            }
        }
        if (cities.isEmpty()){
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }else{
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cities.size());
            cities.forEach((key, value) ->
                    System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", key, value.get(0), value.get(1)));
        }
    }
}
