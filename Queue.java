/**
 * Self implemented Queue ADT.
 * 
 * @author LZ-FSDev
 * @since 17.0.8
 * @version 0.0.1
 */
public class Queue {
    private Node front; //The front Node of the Queue
    private Node back; //The last Node of the Queue

    public Queue() {
        front = null;
        back = null;
    }

    /**
     * Adding to the Queue from the back.
     * 
     * @param data The data of the Node to be added to the Queue.
     */
    public void enqueue(String data) {
        if (isEmpty()) {
            front = new Node(data);
        } else {
            back = new Node(data);
            back = back.getNext();
        }
    }

    /**
     * Removing from the front of the Queue.
     * 
     * @return The Node removed.
     */
    public Node dequeue() {
        Node node = null;
        if (!isEmpty()) {
            node = front;
            if (front.getNext() != null) {
                front = front.getNext();
            } else {
                front = null;
            }
        }
        return node;
    }

    /**
     * Gets the front Node of the Queue without removal.
     * 
     * @return The front Node of the Queue.
     */
    public Node peek() {
        return front;
    }

    /**
     * Checks if the Queue is empty.
     * 
     * @return true if the Queue is empty, false if it contains a Node(s).
     */
    public boolean isEmpty() {
        return front == null;
    }
}
