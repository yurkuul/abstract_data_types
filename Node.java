/**
 * Node class used for abstract data types.
 * 
 * @author LZ-FSDev
 * @since 17.0.8
 * @version 0.0.1
 */
class Node {
    private String data; //The current Node's data
    private Node next; //A pointer to the next Node

    public Node(String data) {
        this.data = data;
        next = null;
    }

    /**
     * Sets the data of the current Node.
     * 
     * @param data The new data to replace the old data.
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Gets the data of the current Node.
     * 
     * @return The data of the current Node.
     */
    public String getData() {
        return data;
    }

    /**
     * Sets the next Node of the current Node.
     * 
     * @param next The new Node to replace the old Node attached to current
     *             Node.
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * Gets the next Node of the current Node.
     * 
     * @return The next Node.
     */
    public Node getNext() {
        return next;
    }
}
