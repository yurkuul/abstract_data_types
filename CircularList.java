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