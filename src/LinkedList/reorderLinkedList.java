package LinkedList;

import java.util.Stack;

public class reorderLinkedList {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	public void reorderList(ListNode head) {
        Stack<ListNode> s = new Stack<>();
        ListNode trav = head;
        int size = 0;
        
        while(trav != null){
            s.push(trav);
            trav = trav.next;
            size++;
            
        }
        
        ListNode output = head;
        head = head.next;
        ListNode newHead = output;
        size--;
        while(size > 0 ){
            output.next = s.pop();
            output = output.next;
             size --;
            if(size > 0 ){
                output.next = head;
                output = output.next;
                head = head.next;
                size --;
            }
        }
        output.next = null;
        
        head = newHead;
    }
	
	public static void main(String[] args) {
		reorderLinkedList roList = new reorderLinkedList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		roList.reorderList(head);
		
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	

}
