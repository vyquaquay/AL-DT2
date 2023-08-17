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
        boolean Input = true;
        while (Input) {
            System.out.println("Please choose an option from the menu:");
            System.out.println("1. Input message");
            System.out.println("2. Receive messages");
            System.out.println("3. Print all messages in the stack");
            System.out.println("4. Find the massages");
            System.out.println("5. Exit the program");
            int option = 0;
            option =  scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    queueMessage(scanner, queue);
                    break;
                case 2:
                   messageReceive(queue,stack);
                    break;
                case 3:
                    messagePrint(stack);
                    break;
                case 4:
                    stack.find(scanner);
                    break;
                case 5:
                    Input = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
    public static Message inputMessage(Scanner scanner) {
        System.out.println("Please enter a message:");
        String input = scanner.nextLine();
        try {
            if (input == null || input.isEmpty() || input.trim().length() > 250) {
                throw new IllegalArgumentException("Invalid input. The message must not be null or empty or over 250 words.");
            } else {
                return new Message(input);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public static void queueMessage(Scanner scanner, Queue<Message> queue) {
        boolean repeat = true;
        while (repeat) {
            Message message = inputMessage(scanner);
            if (message != null) {
                queue.enqueue(message); // add the message to the queue
                System.out.println("The message has been added to the queue.");
            }
            System.out.println("Do you want to input another message? (Y/N)");
            String answer = scanner.nextLine().trim().toUpperCase();
            if (!answer.equals("Y")) {
                repeat = false;
            }
        }
    }
    public static void messageReceive(Queue<Message> queue, Stack<Message> stack) {
        if (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                Message dequeued = queue.dequeue();
                stack.push(dequeued);
            }
            System.out.println("The message has been pushed to the stack.");
        } else {
            System.out.println("Nothing in the queue");
        }
    }
    public static void messagePrint(Stack<Message> stack) {
        System.out.println("The messages in the stack are:");
        for (Message m : stack) {
            System.out.println(m);
        }
    }

}


