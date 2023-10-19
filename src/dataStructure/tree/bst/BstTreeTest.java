package dataStructure.tree.bst;

/**
 * @Author: yin-k
 * @Description:
 * @Date: Created in 17:59 2023/10/17
 */
public class BstTreeTest {
    public static void main(String[] args) {
        BstTree<Integer> integerBstTree = new BstTree<>();
        integerBstTree.insert(6);
        integerBstTree.insert(3);
        integerBstTree.insert(8);
        integerBstTree.insert(1);
        integerBstTree.insert(7);
        integerBstTree.insert(9);
        System.out.println(integerBstTree.getRoot().value);
        integerBstTree.inOrderTraversal();
        System.out.println();
        System.out.println(integerBstTree.delete(6));
        integerBstTree.inOrderTraversal();
    }
}
