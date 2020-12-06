import java.util.*;

/**
 * program:20201109
 * description:
 * author:Zou zijuan
 * create:2020-11-09-16:32
 **/
class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

}
public class BinaryTree {


    //递增顺序查找树
    TreeNode head = new TreeNode(0);//傀儡节点
    TreeNode cur = head;
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        increasingBST(root.left);
        cur.right = new TreeNode(root.val);
        cur = cur.right;
        increasingBST(root.right);
        return head.right;
    }


    //合并二叉树
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null&&t2==null){
            return null;
        }
        if(t1!=null&&t2!=null) {
            t1.val=t1.val+t2.val;
        }
        if(t1==null&&t2!=null) {
            return t2;
        }
        if(t2==null&&t1!=null) {
            return t1;
        }
        t1.left=mergeTrees(t1.left,t2.left);
        t1.right=mergeTrees(t1.right,t2.right);
        return t1;
    }

    // 非递归前序遍历
    void preOrderTraversalNor(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while (cur!=null||!stack.empty()) {
            while (cur != null) {
                System.out.println(cur.val + " ");
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            cur = top.right;
        }
    }
    // 非递归中序遍历
    void inOrderTraversalNor(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while (cur!=null||!stack.empty()){
            while (cur!=null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top=stack.pop();
            System.out.println(top.val+" ");
            cur=cur.right;
        }
    }
    // 非递归后序遍历
    void postOrderTraversalNor(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        TreeNode prev=null;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();//D
            if (cur.right == null||cur.right==prev) {
                stack.pop();
                System.out.print(cur.val + " ");
                prev=cur;
                cur = null;
            } else {
                cur = cur.right;
            }
        }

    }
}
