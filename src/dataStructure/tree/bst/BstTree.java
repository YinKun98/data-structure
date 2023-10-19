package dataStructure.tree.bst;

/**
 * @Author: yin-k
 * @Description: 二叉搜索树
 * @Date: Created in 17:31 2023/10/17
 */
public class BstTree<E extends Comparable<E>> {
    // 树根节点
    TreeNode<E> root;

    // 新建树
    public BstTree() {
        root = null;
    }

    // 插入节点
    public void insert(E data) {
        root = insertRec(root, data);
    }

    private TreeNode<E> insertRec(TreeNode<E> root, E data) {
        if (root == null) {
            return new TreeNode<>(data, null, null);
        }
        int compare = data.compareTo(root.value);
        if (compare < 0) {
            root.left = insertRec(root.left, data);
        } else if (compare > 0) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }


    // 查找判断是否存在
    public TreeNode<E> find(E data) {
        return findRec(root, data);
    }

    private TreeNode<E> findRec(TreeNode<E> root, E data) {
        if (root == null) {
            return null;
        }
        int compare = data.compareTo(root.value);
        if (compare < 0)
            return findRec(root.left, data);
        else if (compare > 0)
            return findRec(root.right, data);
        else return root;
    }
    // 删除节点

    public TreeNode<E> delete(E data) {
        return deleteRec(root, data);
    }

    /**
     * 删除指定元素的节点
     *
     * @param root 二叉子树根节点
     * @param data 要查找的值
     * @return
     */
    private TreeNode<E> deleteRec(TreeNode<E> root, E data) {
        if (root == null) {
            return null;
        }
        int compare = data.compareTo(root.value);
        if (compare < 0) {
            root.left = deleteRec(root.left, data);
        } else if (compare > 0) {
            root.right = deleteRec(root.right, data);
        } else {    // 该节点的值与目标值一致
            // 1、只有一个左或者右子节点
            // 2、左右子节点都是null
            if (root.left == null) {
                return root.right; // 左子节点为空，则返回右子节点（null或者有值）
            } else if (root.right == null) {
                return root.left;  // 同上
            }
            // 3、左右子节点都有值
            root.value = minValue(root.right); // 找该节点的后继节点（右子树的最左叶子节点），把值赋给当前节点，相当于把当前节点删除了
            root.right = deleteRec(root.right, root.value); // 使用这个值把对应的节点删除
        }
        return root; // 返回值为null或者要替换的节点
    }

    private E minValue(TreeNode<E> node) {
        E minValue = node.value;
        while (node.left != null) {
            minValue = node.left.value;
            node = node.left;
        }
        return minValue;
    }

    // 前序遍历
    public void inOrderTraversal() {
        inOrderTraversalRec(root);
    }

    private void inOrderTraversalRec(TreeNode<E> root) {
        if (root != null) {
            inOrderTraversalRec(root.left);
            System.out.print(root.value + " ");
            inOrderTraversalRec(root.right);
        }
    }

    // 中序遍历
    public void preOrderTraversal() {
        preOrderTraversalRec(root);
    }

    private void preOrderTraversalRec(TreeNode<E> root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrderTraversalRec(root.left);
            preOrderTraversalRec(root.right);
        }
    }

    // 后序遍历
    public void postOrderTraversal() {
        postOrderTraversalRec(root);
    }

    private void postOrderTraversalRec(TreeNode<E> root) {
        if (root != null) {
            postOrderTraversalRec(root.left);
            postOrderTraversalRec(root.right);
            System.out.print(root.value + " ");
        }

    }


    public TreeNode<E> getRoot() {
        return root;
    }

    static class TreeNode<E extends Comparable<E>> {
        E value;
        TreeNode<E> left;
        TreeNode<E> right;

        public TreeNode(E v, TreeNode<E> left, TreeNode<E> right) {
            this.value = v;
            this.left = left;
            this.right = right;
        }

        public String toString() {
            return "value= " + value + ",left= " + left.value + ",right= " + right.value;
        }
    }
}
