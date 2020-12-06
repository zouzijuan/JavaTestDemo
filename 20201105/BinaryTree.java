import java.util.*;

/**
 * Program:20201105
 * description:
 * author:ZOU zijuan
 * create:2020-11-05 15:34
 **/
class Node{
    public char val;
    public Node left;
    public Node right;

    public Node(char val) {
        this.val = val;
    }
}
public class BinaryTree {

    public Node createTree(){
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return A;
    }

    public int i=0;
    public Node createTreeByString(String str){
        Node root=null;
        if(str.charAt(i)!='#'){
            root=new Node(str.charAt(i));
            i++;
            root.left=createTreeByString(str);
            root.right=createTreeByString(str);
        } else {
            i++;
        }
        return root;
    }

    public void preOrderTraversal(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.val+"");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }

    public void inOrderTraversal(Node root){
        if(root==null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val+"");
        inOrderTraversal(root.right);

    }

    public void postOrderTraversal(Node root){
        if(root==null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val+"");
    }

    // 遍历思路-求结点个数
    public static int size = 0;
    void getSize1(Node root){
        if(root==null){
            return;
        }
        size++;
        getSize1(root.left);
        getSize1(root.right);
    }
    // 子问题思路-求结点个数
    int getSize2(Node root){
        if(root==null) return 0;
        return getSize2(root.left)+getSize2(root.right)+1;
    }

    // 遍历思路-求叶子结点个数
    static int leafSize = 0;
    void getLeafSize1(Node root){
        if(root==null) return;
        if(root.left==null&&root.right==null){
            leafSize++;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);

    }
    // 子问题思路-求叶子结点个数
    int getLeafSize2(Node root){
        if (root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        return getLeafSize2(root.left)+getLeafSize2(root.right);
    }

    // 子问题思路-求第 k 层结点个数
    int getKLevelSize(Node root,int k){
        if(root==null){
            return 0;
        }
        if(k==1){
            return 1;
        }
        return getKLevelSize(root.left,k-1)
                +getKLevelSize(root.right,k-1);

    }

    // 获取二叉树的高度
    int getHeight(Node root){
        if(root==null){
            return 0;
        }
        int leftHeight=getHeight(root.left);
        int rightHeight=getHeight(root.right);
        return leftHeight>rightHeight?
        leftHeight+1:rightHeight+1;
    }
    // 查找 val 所在结点，没有找到返回 null
    // 按照 根 -> 左子树 -> 右子树的顺序进行查找
    // 一旦找到，立即返回，不需要继续在其他位置查找
    Node find(Node root, int val){
        if(root==null){
            return null;
        }
        if (root.val==val){
            return root;
        }
        Node ret1=find(root.left,val);
        if(ret1!=null){
            return ret1;
        }
        Node ret2=find(root.right,val);
        if(ret2!=null){
            return ret2;
        }
        return null;
    }

    //判断两棵树是否相同
    public boolean isSameTree(Node p, Node q) {
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        boolean flag1=isSameTree(p.left,q.left);
        if(flag1==false){
            return false;
        }
        boolean flag2=isSameTree(p.right,q.right);
        if(flag2==false){
            return false;
        }
        return true;
    }

    //另一棵树的子树
    public boolean isSubtree(Node s, Node t) {
        if(s==null||t==null){
            return false;
        }
        if(isSameTree(s,t)){
            return true;
        }
        if(isSubtree(s.left,t)) return true;
        if(isSubtree(s.right,t)) return true;
        return false;
    }

    //平衡二叉树
    public boolean isBalanced(Node root) {
        if(root==null) return true;
        int heightDifferent=getHeight(root.left)-getHeight(root.right);
        if(heightDifferent<-1||heightDifferent>1){
            return false;
        }
        boolean left=isBalanced(root.left);
        boolean right=isBalanced(root.right);
        if(left==false||right==false){
            return false;
        }
        return true;
    }

    //对称二叉树
    public boolean isSymmetricChild(Node leftTree,Node rightTree) {
        if(leftTree==null&&rightTree==null){
            return true;
        }
        if(leftTree==null||rightTree==null){
            return false;
        }
        if(leftTree.val!=rightTree.val){
            return false;
        }
        boolean flag1=isSymmetricChild(leftTree.left,rightTree.right);
        boolean flag2=isSymmetricChild(leftTree.right,rightTree.left);
        if(flag1==false||flag2==false){
            return false;
        }
        return true;

    }
    public boolean isSymmetric(Node root) {
        if(root==null) return true;
        return isSymmetricChild(root.left,root.right);
    }

    // 层序遍历
    void levelOrderTraversal(Node root){
        if(root==null){
            return;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node cur=queue.poll();
            System.out.print(cur.val+" ");
            if(cur.left!=null) {
                queue.offer(cur.left);
            }
            if(cur.right!=null){
                queue.offer(cur.right);
            }
        }
    }
    public List<List<Character>> levelOrder(Node root) {
        List<List<Character>> lists=new ArrayList<>();
        if(root==null){
            return lists;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int count=queue.size();
            List<Character> rowList=new ArrayList<>();
            while (count>0) {
                Node cur=queue.poll();
                System.out.print(cur.val + " ");
                rowList.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                count--;
            }
            lists.add(rowList);

        }
        return lists;
    }

    // 判断一棵树是不是完全二叉树
    boolean isCompleteTree(Node root){
       if(root==null){
           return true;
       }
       Queue<Node> queue=new LinkedList<>();
       queue.offer(root);
       while (!queue.isEmpty()){
           Node cur= queue.poll();
           if(cur!=null){
               queue.offer(cur.left);
               queue.offer(cur.right);
           } else {
               break;
           }
       }

       while (!queue.isEmpty()){
           Node tmp=queue.peek();
           if(tmp!=null){
               return false;
           } else {
               queue.poll();
           }
       }
       return true;
    }

    //给定一个二叉树, 找到该树中两个指定节点的最近公共祖先
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root==null){
            return null;
        }
        if(p==root||q==root){
            return root;
        }
        Node left=lowestCommonAncestor(root.left,p,q);
        Node right=lowestCommonAncestor(root.right, p, q);
        if(left!=null&&right!=null){
            return root;
        }
        if(left!=null){
            return left;
        }
        if(right!=null){
            return right;
        }
        return null;
    }

    //二叉树搜索树转换成排序双向链表
    public Node prev=null;
    public void ConvertChild(Node root) {
        if(root==null){
            return;
        }
        ConvertChild(root.left);
        root.left=prev;
        if(prev!=null){
            prev.right=root;
        }
        prev=root;
        ConvertChild(root.right);

    }
    public Node Convert(Node pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }
        ConvertChild(pRootOfTree);
        Node head=pRootOfTree;
        while (head.left!=null){
            head=head.left;
        }
        return head;
    }

    //二叉树创建字符串
    StringBuilder sb=new StringBuilder();
    public String tree2str(Node t) {
        if(t==null){
            return "";
            }
        sb.append(t.val);
        if(t.left==null){
            if(t.right==null){
                //什么也不做
            } else {
                sb.append("()");
            }
        } else {
            sb.append("(");
            tree2str(t.left);
            sb.append(")");
        }
        if(t.right==null) {
            //什么也不做
        } else {
            sb.append("(");
            tree2str(t.right);
            sb.append(")");
        }
        return sb.toString();
    }


    //根据一棵树的前序遍历与中序遍历构造二叉树
    public int preIndex = 0;
    public Node buildTreeChild(char[] preorder,
                               char[] inorder,int inbegin,int inend) {
        if(inbegin > inend) {
            return null;
        }
        Node root = new Node(preorder[preIndex]);
        int inorderIndex = findInOrderIndexOfRoot(inorder,
                inbegin,inend,preorder[preIndex]);
        preIndex++;
        root.left = buildTreeChild(preorder,
                inorder,inbegin,inorderIndex-1);
        root.right = buildTreeChild(preorder,
                inorder,inorderIndex+1,inend);
        return root;
    }

    public int findInOrderIndexOfRoot(char[] inorder,
                                     int inbegin,int inend,char val) {
        for (int j = inbegin; j <= inend; j++) {
            if(inorder[j] == val) {
                return j;
            }
        }
        return -1;
    }


    public Node buildTree(char[] preorder, char[] inorder) {
        if(preorder == null || inorder == null) {
            return null;
        }
        if(preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return buildTreeChild(preorder,inorder,
                0,inorder.length-1);
    }


    //根据一棵树的中序遍历与后序遍历构造二叉树
    /*class Solution {

        public TreeNode buildTreeChild(int[] inorder,
                                       int[] postorder,int inbegin,int inend) {
            if(inbegin > inend) {
                return null;
            }
            TreeNode root = new TreeNode(postorder[preIndex]);
            int inorderIndex = findInoderIndexOfRoot(inorder,
                    inbegin,inend,postorder[preIndex]);
            preIndex--;

            root.right = buildTreeChild(inorder,
                    postorder,inorderIndex+1,inend);

            root.left = buildTreeChild(inorder,
                    postorder,inbegin,inorderIndex-1);
            return root;
        }

        public int findInoderIndexOfRoot(int[] inorder,
                                         int inbegin,int inend,int val) {
            for (int j = inbegin; j <= inend; j++) {
                if(inorder[j] == val) {
                    return j;
                }
            }
            return -1;
        }

        public int preIndex = 0;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if(postorder == null || inorder == null) {
                return null;
            }
            if(postorder.length == 0 || inorder.length == 0) {
                return null;
            }
            preIndex = postorder.length-1;
            return buildTreeChild(inorder,postorder,
                    0,inorder.length-1);
        }

    }*/

}
