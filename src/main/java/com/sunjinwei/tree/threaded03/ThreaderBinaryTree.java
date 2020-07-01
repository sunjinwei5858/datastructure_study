package com.sunjinwei.tree.threaded03;

/**
 * 实现了中序线索化功能的二叉树，其实就是对结点进行线索化
 * 线索指的就是 前驱和后继
 */
public class ThreaderBinaryTree {

    private HeroNode root;

    /**
     * 为了实现线索化 需要创建一个当前结点的pre结点
     * 当前结点线索化之后 pre就指向当前结点，当前结点就是下一个要线索化结点的pre结点
     */
    private HeroNode pre = null;

    public ThreaderBinaryTree(HeroNode root) {
        this.root = root;
    }

    public ThreaderBinaryTree() {
    }

    /**
     * 编写对二叉树进行中序线索化的方法 中序：左子树 结点 右子树
     *
     * @param node 需要线索户化的结点
     */
    public void threadedNode(HeroNode node) {
        // 如果node为空 不能线索化
        if (node == null) {
            return;
        }
        // 1线索化左子树
        threadedNode(node.getLeft());

        // 2线索化当前结点 [有难度]
        // 处理前驱结点
        if (node.getLeft() == null) {
            // 如果当前结点的左子树为null 那么线索指向前驱结点 type = 1
            // 让当前结点的左指针指向前驱结点 修改当前结点的左指针的类型,指向前驱结点
            node.setLeftType(1);
            node.setLeft(pre);
        }
        // 处理后继结点 因为二叉树是单向的 所以处理右指针需要通过当前结点的前驱结点为基准 也就是pre的
        if (pre != null && pre.getRight() == null) {
            // 让前驱结点的右指针指向当前结点
            pre.setRightType(1);
            pre.setRight(node);
        }
        // !!! 每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;

        // 3线索化右子树
        threadedNode(node.getRight());

    }

    /**
     * 中序遍历线索二叉树：
     * 遍历线索化二叉树 由于各个结点指向有变化，left和right都有变动，所以不能使用之前的遍历方式来遍历
     * 各个节点可以通过线型方式遍历，因此无需使用递归方式，这样也提高了遍历的效率
     */
    public void midThreadedList() {
        // 定义一个变量，存储当前遍历的结点，从 root 开始
        HeroNode node = root;
        while (node != null) {
            // 循环的找到 leftType == 1 的结点，第一个找到就是 8 结点
            // 后面随着遍历而变化,因为当 leftType==1 时，说明该结点是按照线索化 处理后的有效结点
            while (node.getLeftType() == 0) {
                // 如果leftType==0 那么就一直找下去 直到找到跳出循环找到leftType=1的结点 就是 8 结点 然后输出即可
                node = node.getLeft();
            }
            // 跳出了上面的while循环 那么就打印当前这个结点
            System.out.println(node);
            // 如果当前结点的右指针指向的是后继结点,就一直输出
            while (node.getRightType() == 1) {
                // 获取到当前结点的后继结点
                node = node.getRight();
                System.out.println(node);
            }

            node = node.getRight();
        }


    }


}
