/**
 * Node class used in a 2-3-4 tree data structure.
 */
class Node {
    public char data; //Data of current Node
    public Node left; //Node to left of current Node
    public Node right; //Node to right of current Node

    /**
     * Node construction without children.
     * 
     * @param d Data for current Node.
     */
    public Node(char d) {
        data = d;
        left = null;
        right = null;
    }

    /**
     * Node construction with children.
     * 
     * @param d Data for current Node.
     * @param l The child Node to left of current Node.
     * @param r The child Node to right of current Node.
     */
    public Node(char d, Node l, Node r) {
        data = d;
        left = l;
        right = r;
    }

    /**
     * Sets the left child.
     * 
     * @param left Data of left child Node.
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     * Sets the right child.
     * 
     * @param right Data of right child Node.
     */
    public void setRight(Node right) {
        this.right = right;
    }
}