
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        boolean result;
        int[] num = {1,2,5,4,5};
        result = containsDuplicate(num);
        System.out.println(result);
        int pop=reverse(-4123);
        System.out.println("reverse number: "+pop);
        ListNode nodeA=new ListNode(1);
        ListNode nodeB=new ListNode(2);
        ListNode nodeC=new ListNode(3);
        ListNode nodeD=new ListNode(4);
        ListNode nodeE=new ListNode(5);

        nodeA.next=nodeB;
        nodeB.prev=nodeA;
        nodeB.next=nodeC;
        nodeC.prev=nodeB;
        nodeC.next=nodeD;
        nodeD.prev=nodeC;
        nodeD.next=nodeE;
        nodeE.prev=nodeD;
        reverseList(nodeA);
        int [] tab={7,1,5,3,6,4};
        int res=maxProfit(tab);
        System.out.println("The max profit: "+res);

    }

    public static ListNode reverseList(ListNode head) {

        ListNode head2=head;
        ListNode prev=null;

        while(head!=null){
            //System.out.println(head.val);
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        System.out.println("------reverseList------");
        while(prev!=null){
            System.out.println(prev.val);
            prev=prev.next;
        }
        return prev;
    }

    public static int maxProfit(int[] prices) {
        int maxProfit=0;
        int left=0;
        int right=1;
        while(right<prices.length){
            //System.out.println(prices[right]+" "+prices[left]);
            if(prices[left]<prices[right]){
                int profit=prices[right]-prices[left];
                if(profit>maxProfit){
                    maxProfit=profit;
                }

            }else {
                left=right;
            }
            right++;
        }
        //System.out.println(prices[right]+" "+prices[left]);
        return maxProfit;
    }

    public static int reverse(int x) {
        int pop=0;
        int a=0;
        final int MIN=-2147483648;
        final int MAX=2147483647;
        while (x != 0) {
            pop = x % 10;
            x= x / 10;
            if((a>MAX / 10) || (a==MAX / 10 && pop >= MAX % 10)){
                return 0;
            }
            if((a<MIN / 10) || (a==MIN / 10 && pop <= MIN % 10)){
                return 0;
            }
            a=a * 10+ pop;

        }
        return a;
    }

    public static boolean containsDuplicate(int[] nums){
        HashMap<Integer,Integer> set = new HashMap<Integer,Integer>();
        for(int i : nums){
            if(set.containsKey(i)){
                return false;
            }else {
                set.put(i,i);
            }
        }
        return true;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode prev;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}