package main.java.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author wyw
 * @date 2020/03/05
 */
public class AddTwoNumbers {

    public static void main(String[] args) {

    }

    /**
     * 错误解法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode errSolution(ListNode l1, ListNode l2){
        ListNode result = new ListNode(0);

        Map<Integer,Integer> map1 = new HashMap();
        for (int i = 0;l1.next!=null;i++){
            map1.put(i,l1.val);
            l1 = l1.next;
        }
        Map<Integer,Integer> map2 = new HashMap();
        for (int j = 0;l2.next != null;j++){
            map2.put(j,l2.val);
            l2 = l2.next;
        }
        int max = map1.size()-map2.size()>0?map1.size():map2.size();
        for (int k = 0;k<max;k++){
            int ele = map1.get(k)+ map2.get(k);
            result.val = ele;
            result.next = result;
        }
        return result;

    }


    /**
     * 将当前结点初始化为返回列表的哑结点。
     * 将进位 carrycarry 初始化为 0。
     * 将 p 和 q 分别初始化为列表 l1 和 l2 的头部。
     * 遍历列表 l1 和 l2 直至到达它们的尾端。
     * 将 x 设为结点 p 的值。如果 p 已经到达 l1 的末尾，则将其值设置为 0。
     * 将 y 设为结点 q 的值。如果 q 已经到达 l2 的末尾，则将其值设置为 0。
     * 设定 sum = x + y + carry。
     * 更新进位的值，carry = sum / 10。
     * 创建一个数值为 (sum \bmod 10) 的新结点，并将其设置为当前结点的下一个结点，然后将当前结点前进到下一个结点。
     * 同时，将 p 和 q 前进到下一个结点。
     * 检查 carry = 1是否成立，如果成立，则向返回列表追加一个含有数字 1 的新结点。
     * 返回哑结点的下一个结点。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode solution(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
