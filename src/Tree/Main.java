package Tree;

public class Main
{
    public static void main(String[] args)
    {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(8);
        bst.add(4);
        bst.add(9);
        bst.add(3);
        bst.preOrder();
        BinarySearchTree.Node rst = bst.searchNode(8);
        System.out.println(( rst != null) ?  "\nFound : " + rst.data : "Not found!");
        System.out.println(bst.minVal(bst.root.right).data);
        bst.deleteNode(4);
        bst.preOrder();


    }
}
