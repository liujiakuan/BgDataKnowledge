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

    //前序查找
    TreeNode frontSearch(int value) {
        return root.frontSearch(value);
    }

    //删除一个子树
    void delete(int value) {
        if (root.getValue() == value) {
            root = null;
        } else {
            root.delete(value);
        }
    }
}
