class Solution {
    public void deleteNode(ListNode shubh) {
        shubh.val = shubh.next.val;
        shubh.next = shubh.next.next;        
    }
}