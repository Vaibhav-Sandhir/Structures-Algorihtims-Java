import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {

    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value){
            this.value = value;
        }
    }

    private Node root;

    public void insert(int value){
        Node node = new Node(value);
        Node current = root;
        Node parent = root;
        if(root == null) {
            root = node;
            return;
        }
        while(current != null){
            parent = current;
            if(value < current.value)
                current = current.leftChild;
            else if(value > current.value)
                current = current.rightChild;
            else
                throw new IllegalArgumentException();
        }
        if(value < parent.value)
            parent.leftChild = node;
        else
            parent.rightChild = node;
    }

    public boolean find(int value){
        Node current = root;
        while(current != null){
            if(value > current.value)
                current = current.rightChild;
            else if(value < current.value)
                current = current.leftChild;
            else
                return true;
        }
        return false;
    }

    private void inorder(Node root){
        if(root != null) {
            inorder(root.leftChild);
            System.out.print(root.value + ",");
            inorder(root.rightChild);
        }
    }

    private void preorder(Node root){
        if(root != null){
            System.out.print(root.value + ",");
            preorder(root.leftChild);
            preorder(root.rightChild);
        }
    }

    public int height() {
        return height(root);
    }

    private void postorder(Node root){
        if(root != null){
            postorder(root.leftChild);
            postorder(root.rightChild);
            System.out.print(root.value + ",");
        }
    }

    public void inorderTraversal(){
        inorder(root);
        System.out.println();
    }

    public void preorderTraversal(){
        preorder(root);
        System.out.println();
    }

    public void postorderTraversal(){
        postorder(root);
        System.out.println();
    }

    public void levelorderTraversal(){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while(!(queue.isEmpty())){
            Node temp = queue.remove();
            System.out.print(temp.value + ",");
            if(temp.leftChild != null)
                queue.add(temp.leftChild);
            if(temp.rightChild != null)
                queue.add(temp.rightChild);
        }
        System.out.println();
    }

    public int getHeight(){
        return height(root);
    }

    private int height(Node root){
        if(root == null)
            return -1;
        if(root.leftChild == null && root.rightChild == null)
            return 0;
        return 1 + Math.max(height(root.leftChild),height(root.rightChild));
    }

    public int getMin(){
        return min(root);
    }

    private int min(Node root){
        if(isLeaf(root))
            return root.value;
        int left = min(root.leftChild);
        int right = min(root.rightChild);
        return Math.min(Math.min(left,right), root.value);
    }

    public boolean isEqual(BinarySearchTree other){
        if(other == null)
            return false;

        return equals(root,other.root);
    }

    private boolean equals(Node first, Node second){
        if(first == null && second == null)
            return true;

        if(first != null && second != null)
            return first.value == second.value
                   && equals(first.leftChild, second.leftChild)
                   && equals(first.rightChild, second.rightChild);

        return false;
    }

    private boolean isLeaf(Node node){
        return node.leftChild == null && node.rightChild == null;
    }

    public boolean isBinarySearchTree(){
        return validate(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private boolean validate(Node root, int min, int max){
        if(root == null)
            return true;

        if(root.value < min || root.value > max)
            return false;

        return validate(root.leftChild,min,root.value - 1)
                && validate(root.rightChild,root.value + 1,max);
    }

    public void getNodesAtDistanceK(int k){
        nodesAtDistance(root,k);
    }

    private void nodesAtDistance(Node root,int k){
        if(root == null)
            return;
        if(k == 0){
            System.out.println(root.value);
            return;
        }
        nodesAtDistance(root.leftChild,k - 1);
        nodesAtDistance(root.rightChild,k - 1);
    }


    public int size(){
        int count = 0;
        count = size(root,count);
        return count;
    }
    private int size(Node root,int count){
        if(root == null)
            return count;
        count = count + 1;
        count = size(root.leftChild,count);
        count = size(root.rightChild,count);
        return count;
    }

    public int countLeaves(){
        int count = 0;
        count = countLeaves(root,count);
        return count;
    }
    private int countLeaves(Node root,int count){
        if(root == null){
            return count;
        }
        if(isLeaf(root)){
            count = count + 1;
            return count;
        }
        count = countLeaves(root.leftChild,count);
        count = countLeaves(root.rightChild,count);
        return count;
    }
    public int max(){
        return max(root);
    }

    private int max(Node root){
        if(root.rightChild == null)
            return root.value;
        return max(root.rightChild);
    }

    public boolean contains(int value){
        return contains(root,value);
    }

    private boolean contains(Node root,int value){
        if(root == null)
            return false;
        if(root.value == value)
            return true;
        return contains(root.leftChild,value) || contains(root.rightChild,value);
    }

    public boolean areSiblings(int r,int l){
        return areSiblings(root,r,l);
    }

    private boolean areSiblings(Node root,int r,int l){
        if(root == null || root.rightChild == null || root.leftChild == null)
            return false;
        if((root.rightChild.value == r && root.leftChild.value == l)
           || (root.rightChild.value == l && root.leftChild.value == r))
            return true;
        else
            return areSiblings(root.leftChild,r,l) || areSiblings(root.rightChild,r,l);
    }

    public List<Integer> getAncestors(int value) {
        var list = new ArrayList<Integer>();
        getAncestors(root, value, list);
        return list;
    }

    private boolean getAncestors(Node root, int value, List<Integer> list) {
        if (root == null)
            return false;
        if (root.value == value)
            return true;
        if (getAncestors(root.leftChild, value, list) ||
                getAncestors(root.rightChild, value, list)) {
            list.add(root.value);
            return true;
        }
        return false;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node root) {
        if (root == null)
            return true;

        var balanceFactor = height(root.leftChild) - height(root.rightChild);

        return Math.abs(balanceFactor) <= 1 &&
                isBalanced(root.leftChild) &&
                isBalanced(root.rightChild);
    }

    public boolean isPerfect() {
        return size() == (Math.pow(2, height() + 1) - 1);
    }

}
