package implementations;

import interfaces.AbstractQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Queue<E> implements AbstractQueue<E> {
    private static class Node<E> {
        private E data;
        private Node<E> next;
        public Node(E element) {
            this.data = element;
            this.next = null;
        }
    }
    private Node<E> head;
    private Node<E> tail;
    public Queue() {
        this.head = null;
        this.tail = null;
    }
    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    public E dequeue() {
        if (head == null) {
            return null;
        } else {
            E element = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return element;
        }
    }
    @Override
    public void offer(E element) {
        enqueue(element); // call the enqueue method
    }
    @Override
    public E poll() {
        return dequeue(); // call the dequeue method
    }
    @Override
    public E peek() {
        if (head == null) {
            return null;
        } else {
            return head.data;
        }
    }
    @Override
    public int size() {
        int count = 0;
        Node<E> currentNode = head;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }
        return count;
    }
    @Override
    public boolean isEmpty() {
        return head == null;
    }
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> currentNode = head;
            @Override
            public boolean hasNext() {
                return currentNode != null;
            }
            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else {
                    Node<E> tempNode = currentNode;
                    currentNode = currentNode.next;
                    return tempNode.data;
                }
            }
        };
    }
    public static void queueMessage(Scanner scanner, Queue<Message> queue) {
        boolean repeat = true;
        while (repeat) {
            System.out.println("Please enter a message:");
            String input = scanner.nextLine();
            try {
                if (input == null || input.isEmpty() || input.trim().length() > 250) {
                    throw new IllegalArgumentException("Invalid input. The message must not be null or empty or over 250 words.");
                } else {
                    Message message = new Message(input);
                    queue.enqueue(message); // add the message to the queue
                    System.out.println("The message has been added to the queue.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Do you want to input another message? (Y/N)");
            String answer = scanner.nextLine().trim().toUpperCase();
            if (!answer.equals("Y")) {
                repeat = false;
            }
        }
    }
}


