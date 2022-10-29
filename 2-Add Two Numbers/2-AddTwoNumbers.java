/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head= new ListNode((l1.val+l2.val)%10);
        int digSum=l1.val+l2.val;
        int carry=0;
        if(digSum>9){carry=1;
                     digSum%=10;}
        else carry=0;
        ListNode temp=head;
        l1=l1.next;
        l2=l2.next;
        while(l1!=null && l2!=null){
            digSum=l1.val+l2.val+carry;
            if(digSum>9){carry=1;
                     digSum%=10;
                
            }else carry=0;
            ListNode newNode= new ListNode(digSum);
            temp.next=newNode;
            temp=temp.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            digSum=l1.val+carry;
             if(digSum>9){carry=1;
                     digSum%=10;
                
            }else carry=0;
              ListNode newNode= new ListNode(digSum);
             temp.next=newNode;
            temp=temp.next;
            l1=l1.next;
            
        }
        
         while(l2!=null){
            digSum=l2.val+carry;
            if(digSum>9){carry=1;
                     digSum%=10;
                
            }else carry=0;
              ListNode newNode= new ListNode(digSum);
             temp.next=newNode;
            temp=temp.next;
            l2=l2.next;
            
        }
         
            //   ListNode newNode= new ListNode(digSum);
            //  temp.next=newNode;
            // temp=temp.next;
        if(carry==1){
            ListNode node= new ListNode(1);
        temp.next=node;
        temp=temp.next;}
     //   System.out.println(carry);
        
        return head;
    }
}