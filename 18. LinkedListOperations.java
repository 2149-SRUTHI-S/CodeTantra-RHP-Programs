// Intersection and Union Operations in LinkedList

import java.util.*;

public class Main {

    Node head; // global
    class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    void unionList(Node head1, Node head2) {

        Node t1 = head1;
        Node t2 = head2;
        while (t1 != null) { // pushing list 1 data to the resulatant list
            push(t1.data);
            t1 = t1.next;
        }

        while (t2 != null) {
            if (!isPresent(head, t2.data)) {
                push(t2.data);
            }
            t2 = t2.next;
        }
    }

    void intersectionList(Node head1, Node head2) {

        Node result = null;
        Node t1 = head1;

        while (t1 != null) {
            if (isPresent(head2, t1.data)) {
                push(t1.data);
            }
            t1 = t1.next;
        }
    }

    void printList() {

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;

        }
        System.out.println();
    }

    void push(int newData) { // insertion at the beginig or insertion at the end
        /*Node newNode = new Node(newData);

        newNode.next = head;
        head = newNode;*/

        Node newNode = new Node(newData);
        Node temp = head;
        if (temp == null) {
            newNode.next = head;
            head = newNode;

        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

    }
    boolean isPresent(Node head, int d) {

        Node t1 = head;
        while (t1 != null) {
            if (t1.data == d) {
                return true;
            }
            t1 = t1.next;
        }
        return false;
    }

    // Driver code
    public static void main(String args[]) {
        Main list1 = new Main();
        Main list2 = new Main();
        Main uList = new Main();
        Main iList = new Main();
        
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        
        for (int i = 0; i < n1; i++) {
            int data = sc.nextInt();
            list1.push(data);
        }
        
        int n2 = sc.nextInt();
        for (int i = 0; i < n2; i++) {
            int data = sc.nextInt();
            list2.push(data);
        }

        iList.intersectionList(list1.head, list2.head);
        uList.unionList(list1.head, list2.head);
        
        System.out.println(" First list");
        list1.printList();
        
        System.out.println("Second list");
        list2.printList();
        
        System.out.println(" Union");
        uList.printList();
        
        System.out.println(" intersection");
        iList.printList();
    }
}
