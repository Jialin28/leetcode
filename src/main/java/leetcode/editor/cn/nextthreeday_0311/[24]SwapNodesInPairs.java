//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表

package leetcode.editor.cn.nextthreeday_0311;
import leetcode.editor.cn.common.ListNode;

//leetcode submit region begin(Prohibit modification and deletion)


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution24 {
    public ListNode swapPairs(ListNode head) {
       ListNode dummy = new ListNode(0);
       dummy.next = head;
       ListNode prev = dummy;
       while (prev.next != null && prev.next.next != null) {
           ListNode left = prev.next;
           ListNode right = prev.next.next;

           prev.next = right;
           left.next = right.next;
           right.next = left;

           prev = left;
       }
       return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
