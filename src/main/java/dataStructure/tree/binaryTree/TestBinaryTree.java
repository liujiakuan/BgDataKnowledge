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
        TreeNode rootRightNode = new TreeNode(3);
        TreeNode rootLeftNode = new TreeNode(2);
        root.setLeftNode(rootLeftNode);
        root.setRightNode(rootRightNode);
        //为第二层的结点创建两个子节点
        rootLeftNode.setLeftNode(new TreeNode(4));
        rootLeftNode.setRightNode(new TreeNode(5));
        rootRightNode.setLeftNode(new TreeNode(6));
        rootRightNode.setRightNode(new TreeNode(7));

        //前序遍历
        binaryTree.frontSort();
        System.out.println("========================");
        //中序遍历
        binaryTree.midSort();
        System.out.println("========================");
        //后序遍历
        binaryTree.afterSort();

    }
}
