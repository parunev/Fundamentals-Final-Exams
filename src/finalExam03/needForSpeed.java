import java.util.*;

public class needForSpeed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, List<Integer>> cars = new LinkedHashMap<>();

        for (int i = 0; i <n ; i++) {
           String[]input = scanner.nextLine().split("\\|");
           String model = input[0];
           cars.put(model, new ArrayList<>());
           cars.get(model).add(Integer.parseInt(input[1]));
           cars.get(model).add(Integer.parseInt(input[2]));
        }

        while (true){
            String[]input = scanner.nextLine().split(" : ");
            if (input[0].equals("Stop")){
                break;
            }
            String cmd = input[0];
            String model = input[1];

            switch (cmd){
                case"Drive":
                    int distance = Integer.parseInt(input[2]);
                    int fuel = Integer.parseInt(input[3]);
                    int currentFuel = cars.get(model).get(1);
                    int currentDistance = cars.get(model).get(0);
                    if (currentFuel<fuel){
                        System.out.println("Not enough fuel to make that ride");
                    }else{
                        currentFuel-=fuel;
                        currentDistance += distance;
                        cars.get(model).set(1, currentFuel);
                        cars.get(model).set(0, currentDistance);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", model, distance, fuel);
                    }
                    if (currentDistance>=100000){
                        cars.remove(model);
                        System.out.printf("Time to sell the %s!%n", model);
                    }
                    break;
                case"Refuel":
                    int refuel = Integer.parseInt(input[2]);
                    int current = cars.get(model).get(1);
                    current+=refuel;
                    if (current>75){
                        refuel = (current - 75) - refuel;
                        current = 75;
                    }
                    cars.get(model).set(1, current);
                    System.out.printf("%s refueled with %d liters%n", model, Math.abs(refuel));
                    break;
                case"Revert":
                    int kmToRevert = Integer.parseInt(input[2]);
                    int currentKm = cars.get(model).get(0);
                    currentKm-=kmToRevert;
                    if (currentKm<10000){
                        currentKm=10000;
                    }
                    cars.get(model).set(0, currentKm);
                    System.out.printf("%s mileage decreased by %d kilometers%n", model, kmToRevert);
                    break;
            }
        }
        for (Map.Entry<String, List<Integer>> entry:cars.entrySet()) {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
        }
    }
}
