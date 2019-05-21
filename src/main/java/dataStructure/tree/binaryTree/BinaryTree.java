package dataStructure.tree.binaryTree;

public class BinaryTree {
    private TreeNode root;

    //获取根节点
    public TreeNode getRoot() {
        return root;
    }

    //设置根节点
    void setRoot(TreeNode root) {
        this.root = root;
    }

    //前序遍历
    void frontSort() {
        root.frontSort();
    }

    //中序遍历
    void midSort() {
        root.midSort();
    }

    //后序遍历
    void afterSort() {
        root.afterSort();
    }
}
