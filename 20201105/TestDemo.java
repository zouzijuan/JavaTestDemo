/**
 * Program:20201105
 * description:
 * author:ZOU zijuan
 * create:2020-11-11 16:52
 **/
public class TestDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        Node root=binaryTree.createTree();

        binaryTree.preOrderTraversal(root);
        System.out.println();
        binaryTree.inOrderTraversal(root);
        System.out.println();
        binaryTree.postOrderTraversal(root);
        System.out.println();
        binaryTree.getSize1(root);
        System.out.println(BinaryTree.size);
        System.out.println(binaryTree.getSize2(root));
        System.out.println(binaryTree.getLeafSize2(root));
        binaryTree.getLeafSize1(root);
        System.out.println(BinaryTree.leafSize);
        binaryTree.levelOrderTraversal(root);
    }
}
