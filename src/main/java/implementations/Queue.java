package implementations;

import interfaces.AbstractQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;

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
    public Queue() {
        this.head = null;
    }
    @Override
    public void offer(E element) {
        Node<E> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }
    @Override
    public E poll() {
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
}

