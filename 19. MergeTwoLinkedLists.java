/*
Merge Two Linked Lists

Given two sorted linked lists consisting of N and M nodes respectively. 
The task is to merge both of the lists (in place) and return the head of the merged list.

Examples:
Input: a: 5->10->15, b: 2->3->20
Output: 2->3->5->10->15->20

Input: a: 1->1, b: 2->4
Output: 1->1->2->4

*/

import java.util.*;

class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class Main {
    
    public static Node mergeLists(Node head1, Node head2) {
        Node dummy = new Node(0);
        Node tail = dummy;
        
        while (true) {
            if (head1 == null) {
                tail.next = head2;
                break;
            }
            if (head2 == null) {
                tail.next = head1;
                break;
            }
            
            if (head1.data <= head2.data) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        
        return dummy.next;
    }
    
    public static void printList(Node head) {
        while (head != null) {
            if(head.next == null)
            break;
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println(head.data);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter elements of the first list: ");
        String[] aInput = sc.nextLine().split("->");
        Node a1 = null;
        Node prevA = null;
        for (String str : aInput) {
            int val = Integer.parseInt(str);
            Node newNode = new Node(val);
            if (a1 == null) {
                a1 = newNode;
            } else {
                prevA.next = newNode;
            }
            prevA = newNode;
        }
        
        System.out.println("Enter elements of the second list: ");
        String[] bInput = sc.nextLine().split("->");
        Node b1 = null;
        Node prevB = null;
        for (String str : bInput) {
            int val = Integer.parseInt(str);
            Node newNode = new Node(val);
            if (b1 == null) {
                b1 = newNode;
            } else {
                prevB.next = newNode;
            }
            prevB = newNode;
        }
        
        System.out.println("List a:");
        printList(a1);
        System.out.println("List b:");
        printList(b1);
        
        Node mergedHead = mergeLists(a1, b1);
        
        System.out.println("Merged List:");
        printList(mergedHead);
        
        sc.close();
    }
}
