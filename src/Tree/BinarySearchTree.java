package Tree;

class BinarySearchTree
{
    Node root;

    static class Node
    {
        int data;
        Node left, right;

        public Node(int data)
        {
            this.data = data;
            left = right = null;
        }
    }

    public void add(int data)
    {
        Node newNode = new Node(data);
        if (root == null)
        {
            root = newNode;
            return;
        }
        Node trav = root;
        while (true)
        {
            if (data > trav.data)
            {
                if (trav.right == null)
                {
                    trav.right = newNode;
                    break;
                } else
                {
                    trav = trav.right;
                }
            } else
            {
                if (trav.left == null)
                {
                    trav.left = newNode;
                    return;
                } else
                {
                    trav = trav.left;
                }
            }
        }
    }

    public void deleteNode(int data)
    {
        Node parent = null;
        Node trav = root;
        while (trav != null)
        {
            if (trav.data == data)
            {
                break;
            }
            parent = trav;
            if (trav.data > data)
            {
                trav = trav.left;
            } else
            {
                trav = trav.right;
            }
        }

        if (trav == null)
            return;
        if (trav.left != null && trav.right != null)
        {
            parent = trav;
            Node pred = trav.left;
            while (pred.right != null)
            {
                parent = pred;
                pred = pred.right;
            }
            trav.data = pred.data;
            if (parent.left == pred)
            {
                parent.left = pred.left;
            } else
            {
                parent.right = pred.left;
            }
            return;
        }
        if (trav.right == null)
        {
            if (trav == root)
            {
                root = trav.left;
            } else if (parent.left == trav)
            {
                parent.left = trav.left;
            } else
            {
                parent.right = trav.left;
            }
            return;
        }
        if (trav.left == null)
        {
            if (trav == root)
            {
                root = trav.right;
            } else if (parent.left == trav)
            {
                parent.left = trav.right;
            } else
            {
                parent.right = trav.right;
            }
        }
    }

    public BinarySearchTree.Node searchNode(int data)
    {
        Node trav = root;
        while (trav != null)
        {
            if (data == trav.data)
            {
                return trav;
            }
            if (data > trav.data)
            {
                trav = trav.right;
            } else
            {
                trav = trav.left;
            }
        }
        return null;
    }

    Node minVal(Node root)
    {
        Node minimum = root;
        while (minimum != null)
        {
            if (minimum.left != null)
                minimum = minimum.left;
            else
                break;
        }
        return minimum;
    }

    private void preOrder(Node root)
    {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void preOrder()
    {
        preOrder(root);
    }
}
