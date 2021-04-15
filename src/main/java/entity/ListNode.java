package entity;

/**
 * 链表结构
 * 解算法用，就不改private了
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
