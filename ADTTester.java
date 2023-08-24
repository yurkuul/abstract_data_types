/**
 * Tester class for all self-implemented 
 * 
 * @author LZ-FSDev
 * @since 17.0.8
 * @version 0.0.1
 */
class ADTTester {

    public static void main(String[] args) {
        testStack();
        System.out.println();
    }

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
}
