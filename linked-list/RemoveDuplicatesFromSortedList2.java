/* 
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Return the linked list sorted as well.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3
*/
public class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 2 pointers, slow and fast
        // slow - track the node before the duplicate nodes,
        // fast - to find the last node of dups.
        ListNode slow = dummy;
        ListNode fast = head;
        slow.next = fast;
        while (fast != null) {
            // if dup then advance fast pointer until the last node of dups.
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }
            if (slow.next != fast) { // duplicates detected
                slow.next = fast.next; // skip dups
                fast = slow.next; // reposition fast pointer
            } else { // advance both pointers if no dups
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dummy.next;
    }
}
