public class BinaryTree<E extends Comparable<E>> {

    /** The root of the binary tree */
    protected Node<E> root;

    /**
     * Constructor
     */
    public BinaryTree(){
        root = null;
    }

    public String toString() {
        if (root == null){
            return "EMPTY";
        }
        else {
            StringBuilder sb = new StringBuilder();
            preOrderTraverse(root, 1, sb);
            return sb.toString();
        }
    }


    /**
     * Perform a preorder traversal
     * @param node The local root
     * @param depth The depth
     * @param sb The string buffer to save the output
     */
    private void preOrderTraverse(Node <E> node, int depth,
                                  StringBuilder sb) {
        for (int i = 1; i < 2; i++) {
            sb.append("Lv:"+ depth);
        }
        sb.append(node.toString());
        sb.append("\n");
        if (node.left != null)
            preOrderTraverse(node.left, depth + 1, sb);
        if (node.right != null)
            preOrderTraverse(node.right, depth + 1, sb);
    }

    protected static class Node<E extends Comparable<E> >{
        /** The max-heap stored in this node */
        protected MaxHeap<E> data;

        /** Reference to the left child */
        protected Node<E> left;

        /** Reference to the right child */
        protected Node<E> right;

        /**
         * Construct a node with given data
         * @param data The data to store in this node
         */
        public Node(E data){
            MaxHeap<E> dat = new MaxHeap<>();
            dat.add(data);
            this.data = dat;
            left = null;
            right = null;
        }

        /**
         * Return a string representation of the node
         * @return a string representation of the data fields
         */
        public String toString(){
            return data.toString();
        }
    }
}
