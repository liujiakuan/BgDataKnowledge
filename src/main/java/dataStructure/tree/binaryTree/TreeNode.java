package dataStructure.tree.binaryTree;

public class TreeNode {
    //结点的权
    private int value;
    //左儿子
    private TreeNode leftNode;
    //右儿子
    private TreeNode rightNode;

    TreeNode(int value) {
        this.value = value;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }
}
