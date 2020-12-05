/* 
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?

*/
public class ReverseLinkedList {
    // Iterative, Time: O(n), Space O(1) -> did not use any extra space.
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            // keep track of next pointer to move curr forward
            ListNode temp = curr.next;
            // change curr next pointer to its prev elemenet
            curr.next = prev;
            prev = curr;
            // move curr to next node
            curr = temp;
        }
        return prev;
    }

    // Recursive, Time: O(n), Space: O(n) -> implicit stack space due to recursion
    public ListNode reverseList(ListNode head) {
        // if head.next is null that means it is the last node so return
        if (head == null || head.next == null)
            return head;
        // create a node to traverse the linked list recursively.
        ListNode p = reverseList(head.next);
        // reverse the node pointer pointing to itself
        head.next.next = head;
        // remove curr next pointer
        head.next = null;
        return p;
    }
}
