package dataStructure.tree.binaryTree;

public class TestBinaryTree {
    public static void main(String[] ljk) {
        //创建一棵树
        BinaryTree binaryTree = new BinaryTree();
        //创建一个根节点
        TreeNode root = new TreeNode(1);
        //把根节点赋给数
        binaryTree.setRoot(root);
        //创建根节点的左右子节点
        TreeNode rootRightNode = new TreeNode(2);
        TreeNode rootLeftNode = new TreeNode(3);
        root.setLeftNode(rootLeftNode);
        root.setRightNode(rootRightNode);

    }
}
