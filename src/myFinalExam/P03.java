package myFinalExam;

import java.util.*;

public class P03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, List<Integer>> users =new LinkedHashMap<>();

        while (true){
            String[] input = scanner.nextLine().split("=");
            if (input[0].equals("Statistics")){
                break;
            }
            String cmd = input[0];
            switch (cmd){
                case"Add":
                    String username = input[1];
                    int sent = Integer.parseInt(input[2]);
                    int received = Integer.parseInt(input[3]);
                    if (!users.containsKey(username)){
                        users.put(username, new ArrayList<>());
                        users.get(username).add(sent);
                        users.get(username).add(received);
                    }
                    break;
                case"Message":
                    String sender = input[1];
                    String receiver = input[2];
                    if (users.containsKey(sender) && users.containsKey(receiver)){
                        int currentSenderSent = users.get(sender).get(0);
                        int currentReceiverRec = users.get(receiver).get(1);

                        users.get(sender).set(0, currentSenderSent+1);
                        users.get(receiver).set(1, currentReceiverRec+1);
                    }
                    if (users.containsKey(sender) && users.containsKey(receiver)){
                        int currentSenderSent = users.get(sender).get(0);
                        int currentSenderRec = users.get(sender).get(1);
                        int senderSum = currentSenderRec + currentSenderSent;

                        int currentReceiverSent = users.get(receiver).get(0);
                        int currentReceiverRec = users.get(receiver).get(1);
                        int receiverSum = currentReceiverRec + currentReceiverSent;
                        if (senderSum >= capacity){
                            users.remove(sender);
                            System.out.printf("%s reached the capacity!%n", sender);
                        }else if (receiverSum >= capacity){
                            users.remove(receiver);
                            System.out.printf("%s reached the capacity!%n", receiver);
                        }
                    }
                    break;
                case"Empty":
                    String user = input[1];
                    if (user.equals("All")){
                        users.clear();
                    }
                    users.remove(user);
                    break;
            }
        }
        System.out.printf("Users count: %d%n", users.size());
        for (Map.Entry<String, List<Integer>>entry: users.entrySet()) {
            System.out.printf("%s - %d%n",entry.getKey(), entry.getValue().get(0) + entry.getValue().get(1));
        }
        }
    }
