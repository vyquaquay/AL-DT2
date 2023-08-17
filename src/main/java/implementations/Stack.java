package implementations;

import interfaces.AbstractStack;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Stack<E> implements AbstractStack<E> {
    private static class Node<E> {
        private E data;
        private Node<E> next;
        public Node(E element) {
            this.data = element;
            this.next = null;
        }
    }
    private Node<E> head;
    public Stack() {
        this.head = null;
    }
    @Override
    public void push(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.next = head;
        head = newNode;
    }
    @Override
    public E pop() {
        if (head == null) {
            return null;
        } else {
            Node<E> tempNode = head;
            head = head.next;
            return tempNode.data;
        }
    }
    @Override
    public E peek() {
        if (head == null) {
            //return null
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
        //return count
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
    public void set(int index, E element) {
        if (index < 0 || index >= size()) {
            return;
        } else {
            Node<E> currentNode = head;
            int count = 0;
            while (count < index) {
                currentNode = currentNode.next;
                count++;
            }
            currentNode.data = element;
        }
    }
    public void find(Scanner scanner) {
        System.out.println("Please enter what you want to find:");
        String input = scanner.nextLine();
        int count = 0;
        Node<E> currentNode = head;
        while (currentNode != null) {
            if (currentNode.data.toString().contains(input)) {
                System.out.println("The message is found in the stack: " + currentNode.data);
                count++;
            }
            currentNode = currentNode.next;
        }
        if (count == 0) {
            System.out.println("The input is not found in the stack.");
        } else {
            System.out.println("There are " + count + " messages that contain the input.");
        }
    }
}

