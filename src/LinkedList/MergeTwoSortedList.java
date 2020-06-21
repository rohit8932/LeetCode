package LinkedList;

public class MergeTwoSortedList {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	 
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode finalAns = null, finalAnsHead = null;
        ListNode l1Head = l1;
        ListNode l2Head = l2;
        
        if(l1Head.val <= l2Head.val){
            finalAns = l1Head;  
            l1Head = l1Head.next;
            finalAnsHead =finalAns;
        }else{
            finalAns = l2Head;
            l2Head = l2Head.next;
            finalAnsHead =finalAns;
        }
        
        while(l1Head != null && l2Head != null){
            if(l1Head.val <= l2Head.val){
                finalAns.next = l1Head;
                l1Head = l1Head.next;
            }
            else if (l2Head.val < l1Head.val){
                finalAns.next = l2Head;                
                l2Head = l2Head.next;
                
            }
        }
        if(l1Head != null){
            finalAns.next = l1Head;
            l1Head = l1Head.next;
        }
        if(l2Head != null){
            finalAns.next = l2Head;
            l2Head = l2Head.next;
        }
        return finalAnsHead;
    }
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		int[] arr2 = {4};
		ListNode l1 = null;
		ListNode l2 = null;
		
		
		for(int i : arr) {
			l1 = new ListNode(i);
			l1 = l1.next;
		}
		for(int i : arr2) {
			l2 = new ListNode(i);
			l2 = l2.next;
		}
		
		mergeTwoLists(l1, l2);
	}

}
