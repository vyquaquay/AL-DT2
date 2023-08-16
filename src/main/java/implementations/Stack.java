package implementations;

import interfaces.AbstractStack;
import java.util.Iterator;
import java.util.NoSuchElementException;

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

    // a method to remove an element from the stack by index
    public E remove(int index) {
        if (index < 0 || index >= size()) { // if the index is invalid, return null
            return null;
        } else if (index == 0) { // if the index is 0, call the pop method
            return pop();
        } else { // otherwise, traverse the stack until the index is reached
            Node<E> previousNode = null; // keep track of the previous node
            Node<E> currentNode = head; // start from the head node
            int count = 0; // keep track of the current index
            while (count < index) { // loop until the index is reached
                previousNode = currentNode; // update the previous node
                currentNode = currentNode.next; // move to the next node
                count++; // increment the count
            }
            previousNode.next = currentNode.next; // unlink the current node from the stack
            return currentNode.data; // return the data of the removed node
        }
    }
    public E get(int index) {
        if (index < 0 || index >= size()) { // if the index is invalid, return null
            return null;
        } else { // otherwise, traverse the stack until the index is reached
            Node<E> currentNode = head; // start from the head node
            int count = 0; // keep track of the current index
            while (count < index) { // loop until the index is reached
                currentNode = currentNode.next; // move to the next node
                count++; // increment the count
            }
            return currentNode.data; // return the data of the node at the index
        }
    }
    public void set(int index, E element) {
        if (index < 0 || index >= size()) {
            return;
        } else {
            Node<E> currentNode = head; // start from the head node
            int count = 0; // keep track of the current index
            while (count < index) { // loop until the index is reached
                currentNode = currentNode.next; // move to the next node
                count++; // increment the count
            }
            currentNode.data = element; // set the data of the node at the index to the new element
        }
    }
}

