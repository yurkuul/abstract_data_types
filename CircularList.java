import java.util.*;

public class CircularList {
    public static void main(String[] args) {
        Scanner keyboard;
        int listSize;
        CircularLinkedList myList;

        keyboard = new Scanner(System.in);

        listSize = keyboard.nextInt();

        myList = new CircularLinkedList();

        for (int i = 0; i < listSize; i++) {
            myList.add(keyboard.nextInt());
        }

        keyboard.close();

        System.out.println("The original list: " + myList);
        System.out.println( "The item removed from the list is: " + myList.remove());
        System.out.println("The final list: " + myList);

    }
}

class CircularLinkedList {
    private Node first;
    private int size;

    public CircularLinkedList() {
        first = null;
        size = 0;
    }
    public void add(int value) {
        if (first == null) {
            first = new Node(value, null);
            first.setNext(first);
        } else {
            Node newNode = new Node(value, first.getNext());
            first.setNext(newNode);
        }
        size++;
    }

    public int get() {
        return first.getData();
    }

    public void rotate() {
        if (first != null)
            first = first.getNext();
    }

    public int size() {
        return size;
    }

    public int count(int value) {
        int count = 0;
        for (int i = 0; i < size(); i++) {
            if (get() == value)
                count++;
            rotate();
        }
        return count;
    }

    @Override
    public String toString() {
        String print = "The list contains: ";
        if (size > 0) {
            Node currNode = first;
            for (int i = 0; i < size - 1; i++) {
                print += currNode.getData() + ", ";
                currNode = currNode.getNext();
            }
            print += currNode.getData() + ".";
        } else {
            print += "Nothing!  The list is empty.";
        }
        return print;
    }

    public int remove() {
        if (size > 0) {
            Node oldFirst = first;
    
            Node end = first;
            for (int i = 0; i < size - 1; i++) { 
                end = end.getNext();
            }
    
            end.setNext(first.getNext());
            first = first.getNext();
            oldFirst.setNext(null);
            size--; 
    
            return oldFirst.getData();
        }
        return Integer.MIN_VALUE;
    }
}

class Node {
    private int data;
    private Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}