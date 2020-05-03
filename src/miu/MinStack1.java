package miu;

public class MinStack1 {
    private Node header;
    private MinStack1 secondaryStack; // to track the minimum value


    MinStack1() {
        header = new Node(null, null, null);
    }

    public Node push(Integer item) {
        if (item == null) return null;
        Node n = new Node(header.next, header, item);
        if (header.next != null) {
            header.next.previous = n;
            // if new node has value less than Min, update Min,
            if(secondaryStack.header.next.value > item) {
                secondaryStack.header.next = new Node(secondaryStack.header.next, secondaryStack.header, item);
            }
        }
        // add very first node to both stacks
        header.next = n;
        secondaryStack = new MinStack1();
        secondaryStack.header.next = new Node(secondaryStack.header.next, secondaryStack.header, item);

        return n;
    }

    public boolean pop() {
        if (header.next == null) return false;
        /*if(secondaryStack.header.next.value == header.next.value) {
            secondaryStack.header.next.next.previous = secondaryStack.header;
            secondaryStack.header.next = secondaryStack.header.next.next;
            secondaryStack.header.next = null;
        }*/
        if (header.next != null) {
            header.next.next.previous = header;
            header.next = header.next.next;
            header.next = null;
        }
        return true;

    }

    public boolean isEmpty() {
        return (header.next == null) ? true : false;
    }

    public Integer peek() {
        Node next = this.header.next;
        return (this.header.next != null) ? next.value : null;
    }


    public Integer min() {
        if(secondaryStack.header.next != null)
            return secondaryStack.header.next.value;
        return null;
    }

    public int size() {
        int count = 0;
        Node next = header.next;
        while (next != null) {
            ++count;
            next = next.next;
        }
        return count;
    }

    public String toString() {
        Node next = header.next;
        String output = next.toString();

        return ("[" + output + "]");
    }


    class Node {
        Integer value;
        Node next;
        Node previous;

        Node() {
        }

        Node(Node next, Node previous, Integer value) {
            this.next = next;
            this.previous = previous;
            this.value = value;
        }

        @Override
        public String toString() {
            if (value == null) return "";
            StringBuilder sb = new StringBuilder(value + " ");
            sb = toString(sb, next);
            return sb.toString();
        }

        private StringBuilder toString(StringBuilder sb, Node n) {
            if (n == null) return sb;
            sb.append(n.value + " ");
            return toString(sb, n.next);
        }
    }

    public static void main(String[]args){
        MinStack1 l = new MinStack1();

        l.push(1);
        l.push(4);
        l.push(7);
        l.push(1);
        l.push(3);
        System.out.println("Print Stack " + l);
        System.out.println("Is Stack empty? " + l.isEmpty());
        System.out.println("Stack size: " + l.size());
        System.out.println("Stack Min: " + l.min());
        System.out.println("Peek into the Stack: " + l.peek());

        System.out.println();
        System.out.println("Pop out an element");
        l.pop();
        System.out.println("New Stack size: " + l.size());


    }
}

