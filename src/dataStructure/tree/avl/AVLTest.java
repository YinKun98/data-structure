package dataStructure.tree.avl;

/**
 * @Author: yin-k
 * @Description: AVL测试
 * @Date: Created in 10:30 2023/10/20
 */
public class AVLTest {
    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.insert(50);
        avlTree.insert(40);
        avlTree.insert(60);
        avlTree.insert(30);
        avlTree.insert(45);
        System.out.println(avlTree.getRoot().data);
        avlTree.inOrderTraversal();
        avlTree.insert(20);
        System.out.println(avlTree.getRoot().data);
        avlTree.inOrderTraversal();
        System.out.println();
        avlTree.insert(10);
        System.out.println(avlTree.getRoot().data);
        avlTree.inOrderTraversal();
        System.out.println();
    }
}
