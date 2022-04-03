import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class heroesOfCodeAndLogic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, List<Integer>> heroes = new LinkedHashMap<>();

        for (int i = 0; i <n ; i++) {
            String[]heroInput = scanner.nextLine().split(" ");
            String heroName = heroInput[0];
            int heroHP = Integer.parseInt(heroInput[1]);
            int heroMP = Integer.parseInt(heroInput[2]);
            heroes.put(heroName, new ArrayList<>());
            heroes.get(heroName).add(heroHP);
            heroes.get(heroName).add(heroMP);
        }

        while (true){
            String[]cmdInput = scanner.nextLine().split(" - ");
            if (cmdInput[0].equals("End")){break;}

            String cmd = cmdInput[0];
            String heroName = cmdInput[1];

            switch (cmd){
                case"CastSpell":
                    int neededMP = Integer.parseInt(cmdInput[2]);
                    String castName = cmdInput[3];
                    int currentMP = heroes.get(heroName).get(1);
                    if (currentMP>=neededMP){
                        currentMP-=neededMP;
                        heroes.get(heroName).set(1, currentMP);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, castName, currentMP);
                    }else{
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, castName);
                    }
                    break;
                case"TakeDamage":
                    int damage = Integer.parseInt(cmdInput[2]);
                    String attacker = cmdInput[3];
                    int currentHP = heroes.get(heroName).get(0);
                    currentHP-=damage;
                    if (currentHP>0){
                        heroes.get(heroName).set(0, currentHP);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, currentHP);
                    }else{
                        heroes.remove(heroName);
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                    }
                    break;
                case"Recharge":
                    int amountRecharge = Integer.parseInt(cmdInput[2]);
                    int currentManaPoints = heroes.get(heroName).get(1);
                    if (currentManaPoints + amountRecharge > 200){
                        amountRecharge = 200 - currentManaPoints;
                    }
                    currentManaPoints+=amountRecharge;
                    heroes.get(heroName).set(1, currentManaPoints);
                    System.out.printf("%s recharged for %d MP!%n", heroName, amountRecharge);
                    break;
                case"Heal":
                    int amountHeal = Integer.parseInt(cmdInput[2]);
                    int currentHealthPoints = heroes.get(heroName).get(0);
                    if (currentHealthPoints+amountHeal>100){
                        amountHeal = 100 - currentHealthPoints;
                    }
                    currentHealthPoints+=amountHeal;
                    heroes.get(heroName).set(0, currentHealthPoints);
                    System.out.printf("%s healed for %d HP!%n", heroName, amountHeal);
                    break;
            }
        }
        heroes.forEach((key, value) -> {
            System.out.println(key);
            System.out.printf("  HP: %d%n", heroes.get(key).get(0));
            System.out.printf("  MP: %d%n", heroes.get(key).get(1));
        });
    }
}
