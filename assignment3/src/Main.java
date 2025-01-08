
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

        TreeNode root=new TreeNode(5,new TreeNode(2),new TreeNode(8));
        System.out.println(isValideBST(root));

        System.out.println(climbStairs(5));
        System.out.println(binarySearch(new int []{1,3,4,5},3));

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

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isValide(TreeNode root,Integer min,Integer max){

     if(root==null){
         return true;
     }

     if(min!=null && root.val<=min)return false;
     if(max!=null && root.val>=max)return false;
     boolean left= isValide(root.left,min,root.val);
     boolean right=isValide(root.right,root.val,max);
      return left && right;
    }

    public static boolean isValideBST(TreeNode root){

        return isValide(root,null,null);
    }

    public static int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        int[]dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static  int binarySearch(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int middle=right/2;


        while(left<=right){
            middle=(right+left)/2;
            if(nums[middle]==target) return middle;
            if(target<nums[middle]) right=middle-1;
            if(target>nums[middle]) left=middle+1;

        }
        return -1;

    }



}