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
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<inorder.length;i++) {
            map.put(inorder[i],i);
        }
        int[] preIdx={0};
        return recursion(preorder,inorder,0,preorder.length-1,map,preIdx);
    }
    public TreeNode recursion(int[] preorder, int[] inorder, int left,int right,Map<Integer,Integer> map,int[] preIdx) {
        if (left>right) return null;
        int rootVal=preorder[preIdx[0]++];
        TreeNode root=new TreeNode(rootVal);
        root.left=recursion(preorder,inorder,left,map.get(rootVal)-1,map,preIdx);
        root.right=recursion(preorder,inorder,map.get(rootVal)+1,right,map,preIdx);
        return root;
    }
}
