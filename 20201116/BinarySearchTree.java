
/**
 * program:20201116
 * description:
 * author:Zou zijuan
 * create:2020-11-16-10:07
 **/
public class BinarySearchTree {
    public static class Node{
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }

    private Node root=null;

    public Node search(int key){
        Node cur=root;
        while(cur!=null){
            if(key==cur.key){
                return cur;
            }else if(key<cur.key){
                cur=cur.left;
            } else {
                cur = cur.right;
            }
        }
        return null;
    }

    public boolean insert(int key){
        if(root==null){
            root=new Node(key);
            return true;
        }

        Node cur=root;
        Node parent=null;

        while(cur!=null){
            if(key==cur.key){
                return false;
            } else if(key<cur.key){
                parent=cur;
                cur=cur.left;
            } else {
                parent=cur;
                cur=cur.right;
            }
        }

        Node node=new Node(key);
        if(key<parent.key){
            parent.left=node;
        } else {
            parent.right=node;
        }
        return true;
    }

    public boolean remove(int key) {
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if(cur.key == key) {
                removeNode(parent,cur);
                return true;
            }else if(cur.key < key) {
                parent = cur;
                cur = cur.right;
            }else {
                parent = cur;
                cur = cur.left;
            }
        }
        return false;
    }

    /**
     * @param parent  要删除节点的父亲节点
     * @param cur   当前需要删除的节点
     */
    public void removeNode(Node parent,Node cur) {
        if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            } else if (parent.left == cur) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            } else if (cur == parent.left) {
                parent.left = cur.left;
            } else {
                parent.right = cur.left;
            }
        } else {
            Node targetParent = cur;
            Node target = targetParent.right;
            while (target.left != null) {
                targetParent = target;
                target = target.left;
            }
            cur.key = target.key;
            if (target == targetParent.left) {
                targetParent.left = target.right;
            } else {
                targetParent.right = target.right;
            }
        }
    }
}
