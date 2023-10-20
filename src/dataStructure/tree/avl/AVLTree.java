package dataStructure.tree.avl;

/**
 * @Author: yin-k
 * @Description: 平衡二叉树
 * @Date: Created in 14:28 2023/10/19
 */
public class AVLTree<E extends Comparable<E>> {

    // 根节点指针
    TreeNode<E> root;

    public AVLTree() {
        this.root = null;
    }

    // 获取节点的高度
    private int height(TreeNode<E> node) {
        return node == null ? 0 : node.height;
    }

    public TreeNode<E> getRoot() {
        return root;
    }

    public int getHeight() {
        return root.height;
    }

    // 获取平衡因子
    private int balanceFactor(TreeNode<E> node) {
        return node == null ? 0 : height(node.right) - height(node.left);
    }

    private void updateHeight(TreeNode<E> node) {
        node.height = Math.max(height(node.right), height(node.left)) + 1;
    }

    /**
     * 将不平衡子树右旋
     * <p> 以不平衡子树的左节点为支点向右旋转
     * <p> 支点作为新平衡子树的根节点
     * @param node 不平衡子树根节点
     * @return 旋转后的平衡子树的根节点
     */
    private TreeNode<E> rightRotate(TreeNode<E> node) {
        TreeNode<E> node_l = node.left;
        TreeNode<E> node_l_r = node_l.right;
        node_l.right = node; // 原有根节点作为新子树的右子树
        node.left = node_l_r; // 支点的右子树（中序排列的前序节点）作为替代支点作为原根的左子树
        updateHeight(node);
        updateHeight(node_l);
        return node_l;
    }

    /**
     * 将不平衡子树左旋
     * <p> 以不平衡子树的右节点作为支点向左旋转
     * <p> 支点作为新平衡子树的根节点
     * @param node 不平衡子树的根节点
     * @return 旋转后平衡子树的根节点
     */
    private TreeNode<E> leftRotate(TreeNode<E> node) {
        TreeNode<E> node_r = node.right;
        TreeNode<E> node_r_l = node_r.left;
        node_r.left = node; // 原有根节点作为新子树的左子树
        node.right = node_r_l; // 支点的左子树（中序排列的前序节点）作为 替代支点作为原根的右子树
        updateHeight(node);
        updateHeight(node_r);
        return node_r;
    }

    public void insert(E data) {
        this.root = insertRec(root, data);
    }

    private TreeNode<E> insertRec(TreeNode<E> root, E data) {
        if (root == null)
            return new TreeNode<>(data);
        int i = data.compareTo(root.data);
        // 不考虑平衡性，先做插入操作
        if (i < 0) {
            root.left = insertRec(root.left, data);
        } else if (i > 0) {
            root.right = insertRec(root.right, data);
        } else {
            return root;
        }
        updateHeight(root);
        int balanceFactor = balanceFactor(root);  // right - left
        // 第一个表达式判断左右子树哪一侧高
        // 第二个表达式判断插入节点在支点的左子树还是支点的右子树
        if (balanceFactor > 1 && data.compareTo(root.right.data) > 0) { // 右子树高，节点插在了支点的右子树上，即RR
            return leftRotate(root);
        }
        if (balanceFactor > 1 && data.compareTo(root.right.data) < 0) { // 右子树高，节点插在了支点的左子树上，即RL
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        if (balanceFactor < -1 && data.compareTo(root.left.data) < 0) { // 左子树高，节点插在了支点的左子树上，即LL
            return rightRotate(root);
        }
        if (balanceFactor < -1 && data.compareTo(root.left.data) > 0) { // 左子树高，节点插在了支点的右子树上，即LR
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        return root;
    }

    public void inOrderTraversal() {
        inOrderTraversalRec(this.root);
    }

    private void inOrderTraversalRec(TreeNode<E> root) {
        if (root != null) {
            inOrderTraversalRec(root.left);
            System.out.print(root.data + "  ");
            inOrderTraversalRec(root.right);
        }
    }

    static class TreeNode<E extends Comparable<E>> {
        E data;
        TreeNode<E> left;
        TreeNode<E> right;
        int height;

        TreeNode(E data) {
            this.data = data;
            this.height = 1;
        }
    }

}