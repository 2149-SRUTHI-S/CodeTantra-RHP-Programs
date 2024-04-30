/*
Merge K Sorted Linked Lists

Given K sorted linked lists of size N each, the task is to merge them all maintaining their sorted order.

Examples:
Input: K = 3, N = 4
list1 = 1->3->5->7->NULL
list2 = 2->4->6->8->NULL
list3 = 0->9->10->11->NULL

Output: 0->1->2->3->4->5->6->7->8->9->10->11
Merged lists in a sorted order where every element is greater than the previous element.

Input: K = 3, N = 3
list1 = 1->3->7->NULL
list2 = 2->4->8->NULL
list3 = 9->10->11->NULL

Output: 1->2->3->4->7->8->9->10->11
Merged lists in a sorted order where every element is greater than the previous
 
*/

import java.util.PriorityQueue;
import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MergeKSortedLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the heads of all lists to the minHeap
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Continue until minHeap is empty
        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            tail.next = smallest;
            tail = tail.next;

            if (smallest.next != null) {
                minHeap.add(smallest.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();

        int n = scanner.nextInt();

        ListNode[] lists = new ListNode[k];

        for (int i = 0; i < k; i++) {
            ListNode head = new ListNode(scanner.nextInt());
            ListNode current = head;
            for (int j = 1; j < n; j++) {
                current.next = new ListNode(scanner.nextInt());
                current = current.next;
            }
            lists[i] = head;
        }

        ListNode merged = mergeKLists(lists);

        System.out.println("Merged sorted list:");
        while (merged != null) {
            System.out.print(merged.val + "->");
            merged = merged.next;
        }
        System.out.print("END");
    }
}
