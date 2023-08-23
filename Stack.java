/**
 * Self implemented Stack ADT.
 * 
 * @author LZ-FSDev
 * @since 17.0.8
 * @version 0.0.1
 */
class Stack {
    Node top; //The top Node of the Stack

    public Stack() {
        top = null;
    }

    /**
     * Adding to the Stack.
     * 
     * @param data The data of the Node to be added to the Stack.
     */
    public void push(String data) {
        Node node = new Node(data);
        node.setNext(top);
        top = node;
    }

    /**
     * Removing from the top of the Stack.
     * 
     * @return The Node removed.
     */
    public Node pop() {
        Node node = null;
        if (!isEmpty()) {
            node = top;
            top = top.getNext();
        }
        return node;
    }

    /**
     * Gets the top Node of the Stack without removal.
     * 
     * @return The top Node of the Stack.
     */
    public Node peek() {
        return top;
    }

    /**
     * Checks if the Stack is empty.
     * 
     * @return true if the Stack is empty, false if it contains a Node(s).
     */
    public boolean isEmpty() {
        return top == null;
    }
}
