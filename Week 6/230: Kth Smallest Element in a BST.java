class Solution {
    ArrayList<Integer> arr = new ArrayList<Integer>();
    public int kthSmallest(TreeNode root, int k) {
        helper(root);
        return arr.get(k-1);
    }
    public void helper(TreeNode node)
    {
        if(node.left!=null)
        {
            helper(node.left);
        }
        arr.add(node.val);
        if(node.right!=null)
        {
            helper(node.right);
        }
        return;
    }
}