package dataStructure.linkedList;

/**
 * 这里实现以单链表为列子
 * 循环链表:就是单链表末尾指向头部    暂时未实现，不定期实现更新
 * 双链表:就是单链表每个结点多一个指向前一个结点的引用，第一个结点的指向前一个结点的引用和最后一个结点指向后一个结点的
 * 引用为null    暂时未实现，不定期更新实现
 */
//链表结点
class Node {
    //结点内容
    private int value;
    //下一个结点
    Node nexeNode;

    Node(int value) {
        this.value = value;
    }

    //这里实现链表尾部插入方法，    头部插入、指定位置插入不定时补充，思路比较简单
    Node appendNode(Node node) {
        Node currentNode = this;
        while (true) {
            Node nextNode = currentNode.nexeNode;
            if (null == nextNode) {
                break;
            }
            currentNode = nextNode;
        }
        currentNode.nexeNode = node;
        return this;
    }

    //这里实现链表头部删除方法，     尾部删除、指定位置删除不定时补充，思路比较简单
    Node deleteNode() {
        return this.nextNode();
    }

    Node nextNode() {
        return this.nexeNode;
    }

    int getData() {
        return this.value;
    }

}

public class TestLinkedList {
//    private static Logger logger = Logger.getLogger(TestLinkedList.class);

    public static void main(String[] ljk) {
        //创建结点
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        //添加结点数据
        Node nodeAppend = node1.appendNode(node2).appendNode(node3);
        System.out.println(nodeAppend.getData() + nodeAppend.nextNode().getData() + nodeAppend.nexeNode.nextNode().getData());
        //删除结点数据
        Node nodeDelete = nodeAppend.deleteNode();
        System.out.println(nodeDelete.getData() + nodeDelete.nextNode().getData());
    }
}
