package org.example;

public class MyLinkedList<E> {

    private int size;
    private Node<E> head;

    public MyLinkedList(E head) {
        this.head = new Node<>(head);
        this.size++;
    }

    public void addTail(E tail) {
        if (head == null) {
            head = new Node<>(tail);
        } else {
            Node<E> curr = head;
            while (curr.getNext() != null) {
                curr = curr.getNext();
            }
            curr.setNext(new Node<>(tail));
        }
        size++;
    }

    public void addHead(E head) {
        this.head = new Node<>(head, this.head);
        size++;
    }

    public int getSize() {
        return size;
    }

    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Out of bound: " + index);
        }

        int count = 0;
        Node<E> curr = head;
        while (curr != null && count < index) {
            curr = curr.getNext();
            count++;
        }
        return curr.getData();
    }
    public void delete(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Out of bound: " + index);
        }

        if (index == 0) {
            head = head.getNext();
        } else {
            int count = 0;
            Node<E> prev = null;
            Node<E> curr = head;
            while (count < index) {
                prev = curr;
                curr = curr.getNext();
                count++;
            }
            prev.setNext(curr.getNext());
        }
        size--;
    }

    public void update(int index, E newData) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Out of bound: " + index);
        }

        int count = 0;
        Node<E> curr = head;
        while (count < index) {
            curr = curr.getNext();
            count++;
        }
        curr.setData(newData);
    }

    public void delete(E object) {
        Node<E> curr = head;
        Node<E> prev = null;

        while (curr != null) {
            if (curr.getData().equals(object)) {
                if (prev == null) {
                    head = curr.getNext();
                } else {
                    prev.setNext(curr.getNext());
                }
                size--;
                return;
            }
            prev = curr;
            curr = curr.getNext();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> curr = head;
        while (curr != null) {
            sb.append(curr.toString());
            curr = curr.getNext();
        }
        sb.append("null");
        return sb.toString();
    }
}
