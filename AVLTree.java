public class AVLTree {
    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;
        private int height;

        public Node(int value){
            this.value = value;
        }
    }
    private Node root;

    public void insert(int value){
        root = insert(root,value);
    }

    private Node insert(Node root, int value){
        if(root == null)
            return new Node(value);

        if(value < root.value)
            root.leftChild = insert(root.leftChild,value);
        else
            root.rightChild = insert(root.rightChild, value);

        setHeight(root);
        return balance(root);
    }

    private Node rotateLeft(Node root){
        Node newRoot = root.rightChild;
        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private Node rotateRight(Node root){
        Node newRoot = root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private Node balance(Node root){
        if(isLeftHeavy(root)){
            if(balanceFactor(root.leftChild) < 0)
                root.leftChild = rotateLeft(root.leftChild);
            return rotateRight(root);
        }
        if(isRightHeavy(root)){
            if(balanceFactor(root.rightChild) > 0)
                root.rightChild = rotateRight(root.rightChild);
            return rotateLeft(root);
        }
        return root;
    }

    private boolean isLeftHeavy(Node node){
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(Node node){
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(Node node){
        if(node == null)
            return 0;
        return node.leftChild.height - node.rightChild.height;
    }

    private void setHeight(Node node){
        node.height = Math.max(height(node.leftChild),height(node.rightChild)) + 1;
    }

    private int height(Node node){
        if(node == null)
            return -1;
        return node.height;
    }
}
