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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        //if the val is added in the place of root
        if(depth == 1){
            TreeNode n = new TreeNode(val);
            n.left = root;
            return n;
        }
        
        //create a queue for BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int d = 1;
        while(d < depth - 1){
            Queue<TreeNode> temp = new LinkedList<>(); //create temp for holding next level nodes
            while(!queue.isEmpty())  //nodes at that level
            {
                TreeNode node = queue.remove();
                if(node.left != null)
                    temp.add(node.left);
                if(node.right != null)
                    temp.add(node.right);
            }
            queue = temp;
            d++;            
        }
        //now we are at level depth-1 
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            TreeNode temp = node.left;
            node.left = new TreeNode(val);
            node.left.left = temp;
            temp = node.right;
            node.right = new TreeNode(val);
            node.right.right = temp;
        }
        return root;
    }
}