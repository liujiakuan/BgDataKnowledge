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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
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

    //前序遍历
    void frontSort() {
        //先输出当前结点
        System.out.print(value + " ");
        //输出左节点
        if (leftNode != null) {
            leftNode.frontSort();
        }
        //输出右节点
        if (rightNode != null) {
            rightNode.frontSort();
        }
    }

    //中序遍历
    void midSort() {
        if (leftNode != null) {
            leftNode.midSort();
        }
        System.out.print(value + " ");
        if (rightNode != null) {
            rightNode.midSort();
        }
    }

    //后序遍历
    void afterSort() {
        if (leftNode != null) {
            leftNode.afterSort();
        }
        if (rightNode != null) {
            rightNode.afterSort();
        }
        System.out.print(value + " ");
    }

    //前序查找
    TreeNode frontSearch(int value) {
        TreeNode target = null;
        //对比当前结点
        if (this.value == value) {
            return this;
        } else {
            //查找左节点，查不到target还是null
            if (leftNode != null) {
                target = leftNode.frontSearch(value);
            }
            //如果不为null，说明已经查找到
            if (target != null) {
                return target;
            }
            //查找右节点
            if (rightNode != null) {
                target = rightNode.frontSearch(value);
            }
        }
        return target;
    }
}
