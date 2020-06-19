package com.sunjinwei.tree;

/**
 * 创建树结点对象
 * 一 遍历：前序 中序 后序 关键看什么时候输出父结点
 * 前序遍历 中序遍历 后序遍历
 * <p>
 * 二 查找：前序 中序 后序
 */
public class HeroNode {

    private int number;

    private String name;
    // 左子树 默认为null
    private HeroNode left;
    // 右子树 默认为null
    private HeroNode right;

    public HeroNode(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 1 前序遍历方法编写
     * 根结点->左子树->右子树
     */
    public void preOrder() {
        // 先输出父结点
        System.out.println(this);

        // 递归向左子树遍历
        if (this.left != null) {
            this.left.preOrder();
        }

        // 递归向右子树遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 2 中序遍历方法编写
     * 左子树->根结点->右子树
     */
    public void middleOrder() {
        // 递归向左子树中序遍历
        if (this.left != null) {
            this.left.middleOrder();
        }
        // 输出父结点
        System.out.println(this);
        // 递归向右子树中序遍历
        if (this.right != null) {
            this.right.middleOrder();
        }

    }

    /**
     * 3 后序遍历
     * 左子树->右子树->根结点
     */
    public void postOrder() {
        // 递归向左子树中序遍历
        if (this.left != null) {
            this.left.postOrder();
        }
        // 递归向右子树中序遍历
        if (this.right != null) {
            this.right.postOrder();
        }
        // 输出父结点
        System.out.println(this);
    }

    /**
     * 1 前序查询方法编写
     */
    public HeroNode preSearch(int number) {
        // 直接判断根结点是不是相等
        if (this.number == number) {
            return this;
        }
        // 如果不相等 那么从左子树开始递归查找
        HeroNode result = null;
        if (this.left != null) {
            result = this.left.preSearch(number);
        }
        if (result != null) {
            return result;
        }
        // 如果左子树没有找到 那么从右子树开始查找
        if (this.right != null) {
            result = this.right.preSearch(number);
        }
        return result;
    }

    /**
     * 2 中序遍历查找
     */
    public HeroNode middSerach(int no) {
        // 先判断左子结点是不是为空 如果为空
        HeroNode result = null;
        if (this.left != null) {
            result = this.left.middSerach(no);
        }
        if (result != null) {
            return result;
        }
        if (this.number == no) {
            return this;
        }
        if (this.right != null) {
            result = this.right.middSerach(no);
        }
        return result;
    }

    /**
     * 3 后序查找
     */
    public HeroNode afterSerach(Integer no) {
        HeroNode result = null;
        if (this.left != null) {
            result = this.left.afterSerach(no);
        }
        if (result !=null){
            return result;
        }
        if (this.right != null){
            result = this.right.afterSerach(no);
        }
        if (result != null){
            return result;
        }
        if (this.number == no){
            return this;
        }
        return result;
    }

}
