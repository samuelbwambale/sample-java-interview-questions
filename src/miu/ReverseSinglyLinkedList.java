package miu;

public class ReverseSinglyLinkedList {
    static Node head = null;

    static Node reverse(){
        Node previous = null;
        Node current = head;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
   }

    void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }


   static class Node  {
        String value;
        Node next;
        Node(){}
        Node(Node next, String value){
            this.next = next;
            this.value = value;
        }
        public String toString(){
            return value;
        }
   }

    public static void main(String[] args)
    {
        ReverseSinglyLinkedList list = new ReverseSinglyLinkedList();
        list.head = new Node(null,"One");
        list.head.next = new Node(null,"Two");
        list.head.next.next = new Node(null,"Three");
        list.head.next.next.next = new Node(null,"Four");

        System.out.println("Original Linkedlist");
        list.printList(head);
        head = list.reverse();
        System.out.println("");
        System.out.println("Reversed Linkedlist ");
        list.printList(head);
    }
}
