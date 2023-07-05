import java.util.*;

public class Search_234_Tree {
    public static void main( String[] args ) {
        Scanner keyboard;
        String input;

        keyboard = new Scanner( System.in );

        input = keyboard.nextLine();

        System.out.println("Type 'inorder' to sort to print tree in inorder.");
        System.out.println("Type a value from the tree to search for in the tree.");
        System.out.print("Your option: ");

        keyboard.close();

        //Pre made tree
        Node temp1 = new Node(5, 8, 10);
        Node temp2 = new Node(29);
        Node temp3 = new Node(35, 38, 40);
        Node temp4 = new Node(43, 44);
        Node temp5 = new Node(49, 50, 53);
        Node temp6 = new Node(58, 59);
        Node temp7 = new Node(63);
        Node temp8 = new Node(70);
        Node temp9 = new Node(74, 75, 76);
        Node temp10 = new Node(83, 88);
        Node temp11 = new Node(98);
        Node temp12 = new Node(102, 105, 108);
        Node temp13 = new Node(21, 34, temp1, temp2, temp3);
        Node temp14 = new Node(45, temp4, temp5);
        Node temp15 = new Node(60, 68, 73, temp6, temp7, temp8, temp9);
        Node temp16 = new Node(90, 100, temp10, temp11, temp12);
        Node temp17 = new Node(42, 57, 81, temp13, temp14, temp15, temp16);
        My234Tree testTree = new My234Tree(temp17);


        if (input.equals("inorder")){
            testTree.inorder();
        } else {
            int key = Integer.parseInt(input);
            if (testTree.search(key))
                System.out.println( "The key of " + key + " was FOUND" );
            else
                System.out.println( "The key of " + key + " was NOT found" );
        }

    }
}

class Node {
	public int dataLeft;
	public int dataMid;
	public int dataRight;
	public Node left;
	public Node midLeft;
	public Node midRight;
	public Node right;

	public Node(int d){
		dataLeft = d;
		dataMid = dataRight = Integer.MIN_VALUE;
		left = midLeft = midRight = right = null;
	}

	public Node(int d, Node l, Node ml){
		dataLeft = d;
		dataMid = dataRight = Integer.MIN_VALUE;
		left = l;
		midLeft = ml;
		midRight = right = null;
	}

	public Node(int d1, int d2){
		dataLeft = d1;
		dataMid = d2;
		dataRight = Integer.MIN_VALUE;
		left = midLeft = midRight = right = null;
	}

	public Node(int d1, int d2, Node l, Node ml, Node mr){
		dataLeft = d1;
		dataMid = d2;
		dataRight = Integer.MIN_VALUE;
		left = l;
		midLeft = ml;
		midRight = mr;
		right = null;
	}

	public Node(int d1, int d2, int d3){
		dataLeft = d1;
		dataMid = d2;
		dataRight = d3;
		left = midLeft = midRight = right = null;
	}

	public Node(int d1, int d2, int d3, Node l, Node ml, Node mr, Node r){
		dataLeft = d1;
		dataMid = d2;
		dataRight = d3;
		left = l;
		midLeft = ml;
		midRight = mr;
		right = r;
	}

	public void inorder() {
        if (left != null) {
            left.inorder();
        }

        System.out.print(dataLeft + " ");

        if (midLeft != null) {
            midLeft.inorder();
        }

        if (dataMid != Integer.MIN_VALUE) {
            System.out.print(dataMid + " ");
        }

        if (midRight != null) {
            midRight.inorder();
        }

        if (dataRight != Integer.MIN_VALUE) {
            System.out.print(dataRight + " ");
        }

        if (right != null) {
            right.inorder();
        }
    }

    public boolean search(int key) {
        if (dataLeft == key || dataMid == key || dataRight == key) {
            return true;
        }

        if (left == null && midLeft == null && midRight == null && right == null) {
            return false;
        }

        if (key < dataLeft) {
            if (left != null) {
                return left.search(key);
            }
        } else if (key > dataLeft && (dataMid == Integer.MIN_VALUE || key < dataMid)) {
            if (midLeft != null) {
                return midLeft.search(key);
            }
        } else if (dataMid != Integer.MIN_VALUE && key > dataMid && (dataRight == Integer.MIN_VALUE || key < dataRight)) {
            if (midRight != null) {
                return midRight.search(key);
            }
        } else if (dataRight != Integer.MIN_VALUE && key > dataRight) {
            if (right != null) {
                return right.search(key);
            }
        }

        return false;
    }
}

