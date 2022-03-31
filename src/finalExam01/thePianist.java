package finalExam01;

import java.util.*;

public class thePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, List<String>> pieces = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\|");
            String pieceName = input[0];
            String composer = input[1];
            String key = input[2];

            pieces.put(pieceName, new ArrayList<>());
            pieces.get(pieceName).add(composer);
            pieces.get(pieceName).add(key);
        }
        while (true) {
            String[] input = scanner.nextLine().split("\\|");
            if (input[0].equals("Stop")) {
                break;
            }
            String cmd = input[0];
            String piece = input[1];
            switch (cmd) {
                case "Add":
                    if (pieces.containsKey(piece)) {
                        System.out.printf("%s is already in the collection!%n", piece);
                    } else {
                        pieces.put(piece, new ArrayList<>());
                        pieces.get(piece).add(input[2]);
                        pieces.get(piece).add(input[3]);
                        System.out.printf("%s by %s in %s added to the collection!%n", piece, input[2], input[3]);
                    }
                    break;
                case "Remove":
                    if (pieces.containsKey(piece)) {
                        pieces.remove(piece);
                        System.out.printf("Successfully removed %s!%n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
                case "ChangeKey":
                    if (pieces.containsKey(piece)) {
                        pieces.get(piece).add(1, input[2]);
                        System.out.printf("Changed the key of %s to %s!%n", piece, input[2]);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
            }
        }
        for (Map.Entry<String, List<String>> entry : pieces.entrySet()) {
            System.out.printf("%s -> Composer: %s, Key: %s%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
        }
    }
}
