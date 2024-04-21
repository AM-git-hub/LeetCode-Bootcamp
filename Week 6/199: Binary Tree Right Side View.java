class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        while(q.size()>0)
        {
            TreeNode rightMost = null;
            int qLen = q.size();

            for(int i=0;i<qLen;i++)
            {
                TreeNode curr = q.poll();
                if(curr!=null)
                {
                    rightMost = curr;
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }
            if(rightMost!=null) ans.add(rightMost.val);
        }
        return ans;
    }
}