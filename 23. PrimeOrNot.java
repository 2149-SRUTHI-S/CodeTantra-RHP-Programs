/*
To check a number represented in the Linked List is Prime or not
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

public class LList {
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

public class LListPrime {

    static boolean isPrime(LList list) {
        long num = 0;
        Node ptr = list.head;
        while (ptr != null) {
            num = num * 10 + ptr.data;
            ptr = ptr.next;
        }

        if (num <= 1)
            return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        LList list = new LList();
        for (int i = 0; i < n; i++) {
            int d = s.nextInt();
            list.append(d);
        }

        if (isPrime(list)) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }
}
