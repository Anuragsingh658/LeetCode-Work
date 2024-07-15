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
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
         Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        
        // Create nodes and track children
        for (int[] description : descriptions) {
            int parentVal = description[0];
            int childVal = description[1];
            boolean isLeft = description[2] == 1;
            
            nodeMap.putIfAbsent(parentVal, new TreeNode(parentVal));
            nodeMap.putIfAbsent(childVal, new TreeNode(childVal));
            
            TreeNode parent = nodeMap.get(parentVal);
            TreeNode child = nodeMap.get(childVal);
            
            if (isLeft) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            
            children.add(childVal);
        }
        
        // The root is the node that is not a child of any other node
        TreeNode root = null;
        for (int key : nodeMap.keySet()) {
            if (!children.contains(key)) {
                root = nodeMap.get(key);
                break;
            }
        }
        
        return root;
    }

    // Helper method to print the binary tree in level order (for testing purposes)
    public void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current != null) {
                System.out.print(current.val + " ");
                queue.add(current.left);
                queue.add(current.right);
            } else {
                System.out.print("null ");
            }
        }
    }
}