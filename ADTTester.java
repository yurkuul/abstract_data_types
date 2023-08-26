/**
 * Tester class for all self-implemented 
 * 
 * @author LZ-FSDev
 * @since 17.0.8
 * @version 0.0.2
 */
class ADTTester {

    public static void main(String[] args) {
        testStack();
        System.out.println();
        testQueue();
        System.out.println();
    }

    /**
     * Tests the Stack class by pushing, popping, peeking, etc.
     */
    public static void testStack() {
        System.out.println("Testing Stack:");
        Stack s = new Stack();
        
        //Test adding to the Stack
        System.out.println("Adding to Stack...");
        s.push("data1");
        s.push("data2");
        s.push("data3");
        s.push("data4");
        
        Node reference = s.peek();
        boolean addSuccessful = true;

        while (addSuccessful) {
            if (reference == null) {
                break;
            }
            String data = reference.getData();
            if (data.equals("data1") || data.equals("data2") 
                || data.equals("data3") || data.equals("data4")) {
                    reference = reference.getNext();
            } else {
                addSuccessful = false;
            }
        }

        if (addSuccessful) {
            System.out.println("Adding to Stack successful.");
        } else {
            System.out.println("Adding to Stack failed.");
        }

        System.out.println("Emptying Stack...");
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        if (s.isEmpty()) {
            System.out.println("Removing from Stack successful.");
        } else {
            System.out.println("Removing from Stack failed.");
        }

        System.out.println("Testing Stack has finished.");
    }

    /**
     * Tests the Queue class by enqueue-ing, dequeue-ing, peeking, etc.
     */
    public static void testQueue() {
        System.out.println("Testing Queue:");
        Queue q = new Queue();
        
        //Test adding to the Queue
        System.out.println("Adding to Queue...");
        q.enqueue("data1");
        q.enqueue("data2");
        q.enqueue("data3");
        q.enqueue("data4");
        
        Node reference = q.peek();
        boolean addSuccessful = true;

        while (addSuccessful) {
            if (reference == null) {
                break;
            }
            String data = reference.getData();
            if (data.equals("data1") || data.equals("data2") 
                || data.equals("data3") || data.equals("data4")) {
                    reference = reference.getNext();
            } else {
                addSuccessful = false;
            }
        }

        if (addSuccessful) {
            System.out.println("Adding to Queue successful.");
        } else {
            System.out.println("Adding to Queue failed.");
        }

        System.out.println("Emptying Queue...");
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        if (q.isEmpty()) {
            System.out.println("Removing from Queue successful.");
        } else {
            System.out.println("Removing from Queue failed.");
        }

        System.out.println("Testing Queue has finished.");
    }
}
