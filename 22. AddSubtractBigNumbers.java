/*
Problem to add or subtract big numbers using Doubly Linked List
*/

import java.util.*;

class Node {
    int data;
    Node next;
    Node prev;
    public Node(int data) {
        this.data = data;
    }
}

class LList {
    Node head = null;
    Node tail = null;

    void prepend(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    void printList() {
        Node temp = head;
        while (temp.next != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
}
public class LListDemo {
    static LList add(LList list1, LList list2) {
        LList ans = new LList();
        Node p1 = list1.head;
        Node p2 = list2.head;
        int carry = 0;
        while (p1 != null && p2 != null) {
            int v = p1.data + p2.data + carry;
            if (v > 9) {
                carry = v / 10;
                v %= 10;
            }
            ans.prepend(v);
            p1 = p1.next;
            p2 = p2.next;
        }

        while (p1 != null) {
            int v = p1.data + carry;
            if (v > 9) {
                carry = v / 10;
                v %= 10;
            }
            ans.prepend(v);
            p1 = p1.next;
        }

        while (p2 != null) {
            int v = p2.data + carry;
            if (v > 9) {
                carry = v / 10;
                v %= 10;
            }
            ans.prepend(v);
            p2 = p2.next;
        }

        if (carry > 0) {
            ans.prepend(carry);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        LList list1 = new LList();
        LList list2 = new LList();
        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            int d = s.nextInt();
            list1.prepend(d);
        }

        n = s.nextInt();
        for (int i = 0; i < n; i++) {
            int d = s.nextInt();
            list2.prepend(d);
        }


        LList addResult = add(list1, list2);
        addResult.printList();
    }
}
