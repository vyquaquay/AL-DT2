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
}


