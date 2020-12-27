package other;

public class mergeTwoSortedLists {
	public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode newHead = null;
        ListNode newList = null;
        
        if(l1.val < l2.val){
            newHead = new ListNode(l1.val);
            l1 = l1.next;
            newList = newHead;
        }else{
            newHead = new ListNode(l2.val);
            l2 = l2.next;
            newList = newHead;
        }
        
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                newHead.next = new ListNode(l1.val);
                newHead = newHead.next;
                l1 = l1.next;
            }else{
                newHead.next = new ListNode(l2.val);
                newHead = newHead.next;
                l2 = l2.next;
            }
        }
        
        while(l1 != null){
            newHead.next = new ListNode(l1.val);
            newHead = newHead.next;
            l1 = l1.next;
        }
        while(l2 != null){
            newHead.next = new ListNode(l2.val);
            newHead = newHead.next;
            l2 = l2.next;
        }
        
        return newList;
        
    }
	
	public static void main(String[] args) {
		mergeTwoSortedLists mtsl = new mergeTwoSortedLists();
		
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(4);
		l2.next = new ListNode(5);
		l2.next.next = new ListNode(6);
		
		
		ListNode res = mtsl.mergeTwoLists(l1, l2);
		while(res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}

}
