import implementations.Queue;
import implementations.Stack;
import java.util.Scanner;
class Message {
    private String content;
    public Message(String content) {
        this.content = content;
    }
    public String toString() {
        return this.content;
    }
}
public class Main {
    public static void main(String[] args) {
        Queue<Message> queue = new Queue<>();
        Stack<Message> stack = new Stack<>();
        int index;
        Scanner scanner = new Scanner(System.in);
        boolean moreInput = true;
        while (moreInput) {
            System.out.println("Please choose an option from the menu:");
            System.out.println("1. Input a message");
            System.out.println("2. Print all messages in the stack");
            System.out.println("3. Delete a message from the stack");
            System.out.println("4. Update a message in the stack");
            System.out.println("5. Exit the program");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    boolean repeat = true;
                    while (repeat) {
                        Message message = inputMessage(scanner);
                        if (message != null) {
                            stack.push(message);
                            System.out.println("The message has been pushed to the stack.");
                        }
                        System.out.println("Do you want to input another message? (Y/N)");
                        String answer = scanner.nextLine().trim().toUpperCase();
                        if (!answer.equals("Y")) {
                            repeat = false;
                        }
                    }
                    break;
                case 2:
                    System.out.println("The messages in the stack are:");
                    for (Message m : stack) {
                        System.out.println(m);
                    }
                    break;
                case 3:
                    System.out.println("Enter the index of the message you want to delete (from 0 to " + (stack.size() - 1) + "):");
                     index = scanner.nextInt();
                    scanner.nextLine();
                    if (index >= 0 && index < stack.size()) {
                        Message deleted = stack.remove(index);
                        System.out.println("The deleted message is: " + deleted);
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;
                case 4:
                    System.out.println("Enter the index of the message you want to update (from 0 to " + (stack.size() - 1) + "):");
                    index = scanner.nextInt();
                    scanner.nextLine();
                    if (index >= 0 && index < stack.size()) {
                        Message old = stack.get(index);
                        System.out.println("The old message is: " + old);
                        Message newMessage = inputMessage(scanner);
                        if (newMessage != null) {
                            stack.set(index, newMessage);
                            System.out.println("The updated message is: " + newMessage);
                        }
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;
                case 5:
                    moreInput = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        scanner.close();
        for (Message message : queue) {
            stack.push(message);
        }
    }
    public static Message inputMessage(Scanner scanner) {
        System.out.println("Please enter a message:");
        String input = scanner.nextLine();
        try {
            if (input == null || input.isEmpty() || input.split(" ").length > 250) {
                throw new IllegalArgumentException("Invalid input. The message must not be null or empty or over 250 words.");
            } else {
                return new Message(input);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}


