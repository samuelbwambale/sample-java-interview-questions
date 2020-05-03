package miu;

public class MinStack {
    private Node head;  //zeroth element
    private MinStack trackinStack; // to track the minimum value

    MinStack(){
    }


    public Node push(Integer value) {
        if (value == null) return null;
        if(head != null) {
            head = new Node(head, value);

            // if new node has value less than Min, update Min,
            if(trackinStack.head.value >= value) {
                trackinStack.head = new Node(trackinStack.head, value);
            }
        }
        else {
            // add very first node to both stacks
            head = new Node(head, value);
            trackinStack = new MinStack();
            trackinStack.head = new Node(trackinStack.head, value);

        }


        return head;
    }

    public boolean isEmpty() {
        return (head == null) ? true : false;
    }

    public boolean pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return false;
        }
        // if we are popping our current Min, delete the Min from the secondary stack
        if(trackinStack.head.value == head.value) {
            trackinStack.head = trackinStack.head.next;
        }
        head = head.next;

        return true;
    }


    public Integer peek() {
        if (!isEmpty()) {
            return this.head.value;
        }
        else {
            System.out.println("Stack is empty");
            return null;
        }
    }

    public int min() {
        return trackinStack.peek();
    }




    public int size(){
        int count = 0;
        Node next = head;
        while(next != null){
            ++count;
            next = next.next;
        }
        return count;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        Node next = head;
        while(next != null){
            sb.append(next.value+", ");
            next = next.next;
        }
        String ret = sb.toString();
        ret = ret.substring(0,ret.length()-2);
        return (ret +"]");
    }



    class Node  {
        Integer value;
        Node next;
        Node(){}
        Node(Node next, Integer value){
            this.next = next;
            this.value = value;
        }
        public String toString(){
            return value.toString();
        }
    }


    public static void main(String[]args){
        MinStack l = new MinStack();

        l.push(4);
        l.push(7);
        l.push(1);
        l.push(3);
        l.push(1);
        System.out.println("Print Stack " + l);
        System.out.println();
        System.out.println("Is Stack empty? " + l.isEmpty());
        System.out.println();
        System.out.println("Stack size: " + l.size());
        System.out.println();
        System.out.println("Stack Minimum is: " + l.min());
        System.out.println();
        System.out.println("Peek into the Stack: " + l.peek());
        System.out.println();
        System.out.println(l);

        System.out.println();
        System.out.println("Pop out an element");
        l.pop();
        System.out.println("New Stack size: " + l.size());
        System.out.println();
        System.out.println(l);

        System.out.println();
        System.out.println("Pop out an element");
        l.pop();
        System.out.println(l);
        System.out.println("Peek into the Stack: " + l.peek());
        System.out.println("Stack Minimum is: " + l.min());

    }

}
