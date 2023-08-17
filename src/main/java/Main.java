import implementations.Queue;
import implementations.Stack;
import implementations.Message;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Queue<Message> queue = new Queue<>();
        Stack<Message> stack = new Stack<>();
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
                    Queue.queueMessage(scanner, queue);
                    break;
                case 2:
                   Stack.messageReceive(queue,stack);
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
    public static void messagePrint(Stack<Message> stack) {
        System.out.println("The messages in the stack are:");
        for (Message m : stack) {
            System.out.println(m);
        }
    }

}


