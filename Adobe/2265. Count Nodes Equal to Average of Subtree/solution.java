/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 class Pair{

    int sum;

    int nodes;

    Pair(int sum, int nodes){
        this.sum = sum;
        this.nodes = nodes;
    }

}

class Solution {

    public static Pair helper(TreeNode node){

        if(node == null){
            return new Pair(0, 0);
        }

        Pair left = helper(node.left);

        Pair right = helper(node.right);

        int totalSum = left.sum + right.sum + node.val;

        int num = left.nodes + right.nodes + 1;

        if(num != 0 && (totalSum/num) == node.val){
            ans++;
        }

        return new Pair(totalSum, num);

    }

    public static int ans;

    public int averageOfSubtree(TreeNode root) {
        
        ans = 0;

        helper(root);

        return ans;

    }

}