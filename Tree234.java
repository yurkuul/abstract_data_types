import java.util.*;

public class Tree234 {
    public static void main(String[] args) {
        Scanner keyboard;
        String input;

        keyboard = new Scanner(System.in);

        while (true) {
            System.out.println("Choose a traversal method to print out the 2-3-4 tree:");
            input = keyboard.nextLine();
            if (input.equals("preorder") ||input.equals("inorder") || input.equals("postorder")) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        keyboard.close();

        //Pre-made tree
        Node temp1 = new Node('A', new Node('E'), new Node('H'));
        Node temp2 = new Node('F', new Node('G'), temp1);
        Node temp3 = new Node('B', null, new Node('J'));
        Node temp4 = new Node('C', temp3, null);
        Node root = new Node('D', temp2, temp4);

        if (input.equals("preorder")) {
            root.preorder();
        } else if (input.equals("postorder")) {
            root.postorder();
        } else if (input.equals("inorder")) {
            root.inorder();
        } else {
            System.out.println("Invalid input");
        }
    }
}

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

    /**
     * Prints out the tree using preorder traversal. Visits the root first
     * before traversing the entire left subtree and then traversing the right
     * subtree.
     */
    public void preorder() {
        System.out.print(data + " "); // Visit the root
        if (left != null) {
            left.preorder(); // Traverse left subtree
        }
        if (right != null) {
            right.preorder(); // Traverse right subtree
        }
    }

    /**
     * Prints out the tree using inorder traversal. Visits the entire left
     * subtree before visiting the root and then traverses the entire right
     * subtree.
     */
    public void inorder() {
        if (left != null) {
            left.inorder(); //Traverse left subtree
        }
        System.out.print(data + " "); //Visit the root
        if (right != null) {
            right.inorder(); //Traverse right subtree
        }
    }

    /**
     * Prints out the tree using postorder traversal. Traverses the entire left
     * subtree and then traverses the entire right subtree before visiting the
     * root.
     */
    public void postorder() {
        if (left != null) {
            left.postorder(); //Traverse left subtree
        }
        if (right != null) {
            right.postorder(); //Traverse right subtree
        }
        System.out.print(data + " "); //Visit the root
    }
}