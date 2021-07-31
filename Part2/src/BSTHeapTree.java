public class BSTHeapTree<E extends Comparable<E>> extends BinaryTree<E> implements SearchTree<E>{

    private int addOccurrences;
    private E deleteReturn;
    private int deleteOccurrences;
    private E modeItem;
    private int modeCount;
    private MaxHeap<E> deleted;
    private final int maxHeapSize = 7;
    /** if flag is true that means the target item is in the tree **/
    private boolean flag = false;
    private boolean flag2 = false;

    /**
     * Returns the number of occurrences of the item after insertion
     * @param item The item to be added
     * @return the number of occurrences of the item after insertion
     */
    @Override
    public int add(E item) {
        find(item);
        root = add(root, item);
        return addOccurrences;
    }


    /**
     * Recursive add method
     * @param localRoot The local root of the subtree
     * @param item The item to be inserted
     * @return The new local root that now contains the inserted item
     */
    private Node<E> add(Node<E> localRoot, E item){
        //if item is not in the tree -- insert it
        if (localRoot == null && !flag){
            addOccurrences = 1;
            return new Node<E>(item);
        }
        //Keep searching because the target item is in the tree
        if (localRoot == null && flag)
            return null;
        //If the heap is not full and the target item is not in the tree
        boolean bool = (localRoot.data.size() < maxHeapSize) && (!flag);
        if ( bool || localRoot.data.indexOf(item)>-1){
            flag = false;
            addOccurrences = localRoot.data.add(item);
            return localRoot;
        }
        // item is equal to localRoot.data
        else if (item.compareTo(localRoot.data.theData.get(0).getData()) == 0){
            return localRoot;
        }
        // item is less than localRoot.data
        else if(item.compareTo(localRoot.data.theData.get(0).getData()) < 0){
            localRoot.left = add(localRoot.left, item);
            /**if flag == true that means the target item is not in the
             * left subtree, search item in the right subtree
             */
            if (flag)
                localRoot.right = add(localRoot.right, item);
            return localRoot;
        }
        // item is greater than localRoot.data
        else {
            localRoot.right = add(localRoot.right, item);
            return localRoot;
        }
    }


    /**
     * Recursive add method
     * This method is used to preserve the structure of the tree
     * after the largest element of the heap has been deleted.
     * @param localRoot The local root of the subtree
     * @param item The item is the new largest element in the heap
     * @param heap The heap it was in before being deleted
     * @return
     */
    private Node<E> add(Node<E> localRoot, E item, MaxHeap<E> heap){
        if (localRoot == null){
            // insert the heap in the tree with all items
            E value;
            Node<E> returnNode = new Node<E>(item);
            int count = heap.theData.get(0).getCount();
            if (count>1)
                for (int i=1; i<count; i++)
                    returnNode.data.add(item);
            for (int i=1; i<heap.theData.size(); i++){
                value = heap.theData.get(i).getData();
                count = heap.theData.get(i).getCount();
                for (int j=0; j<count; j++)
                    returnNode.data.add(value);
            }
            return returnNode;
        }
        else {
            int compResult = item.compareTo(localRoot.data.theData.get(0).getData());
            // item is less than localRoot.data
            if (compResult < 0)
                localRoot.left = add(localRoot.left, item, heap);
            // item is greater than localRoot.data
            else
                localRoot.right = add(localRoot.right, item, heap);
            return localRoot;
        }
    }


    /**
     * Returns the number of occurrences of the item in the BSTHeapTree
     * @param target The item to be found
     * @return the number of occurrences of the item
     */
    @Override
    public int find(E target) {
        flag = false;
        return find(root, target);
    }

    /**
     * Recursive find method
     * @param localRoot The local of the subtree
     * @param target The item to be found
     * @return the number of occurrences of the item
     */
    private int find(Node<E> localRoot, E target){
        if (localRoot == null)
            return -1;
        int index = localRoot.data.indexOf(target);
        //if target item is in the tree
        if (index > -1){
            flag = true;
            return localRoot.data.theData.get(index).getCount();
        }
        else {
            int compResult = target.compareTo(localRoot.data.theData.get(0).getData());
            // item is equal to localRoot.data
            if (compResult == 0)
                return localRoot.data.theData.get(0).getCount();
            // item is greater than localRoot.data
            else if(compResult > 0)
                return find(localRoot.right, target);
            // item is less than localRoot.data
            else{
                int count = find(localRoot.left, target);
                // if item is not in the left subtree, search the item in
                // the right subtree
                if (!flag)
                    count = find(localRoot.right, target);
                return count;
            }
        }
    }

    /**
     * Returns the value in the BSTHeapTree that occurs most frequently.
     * @return the value that occurs most frequently
     */
    @Override
    public E find_mode() {
        find_mode(root);
        System.out.println("Mode Count: " + modeCount + " Mode: " + modeItem.toString());
        return modeItem;
    }

    /**
     * Recursive find_mode method
     * @param localRoot The local root of the subtree
     */
    private void find_mode(Node<E> localRoot){
        if (localRoot == null)
            return;
        for (int i=0; i<localRoot.data.theData.size();i++){
            int count = localRoot.data.theData.get(i).getCount();
            if (count > modeCount){
                modeItem = localRoot.data.theData.get(i).getData();
                modeCount = count;
            }
        }
        find_mode(localRoot.left);
        find_mode(localRoot.right);
    }

    /**
     * Returns the number of occurrences of the item after removal
     * @param target The item to be removed
     * @return the number of occurrences of the item after removal
     */
    @Override
    public int remove(E target) {
        deleted = null;
        flag2 = true;
        root = remove(root, target);
        // if the largest element of the one of the heaps
        // has been deleted
        if (deleted !=null && deleted.size() != 0){
            E item = deleted.theData.get(0).getData();
            add(root,item,deleted);
        }
        return deleteOccurrences;
    }

    /**
     * Recursive remove method
     * @param localRoot The local root of the subtree
     * @param target The item to be removed
     * @return The modified local root that does not contain the item
     */
    private Node<E> remove(Node<E> localRoot, E target){
        if (localRoot == null){
            //item is not in the tree
            deleteReturn = null;
            deleteOccurrences = -1;
            return null;
        }
        // item is in the tree
        if (localRoot.data.indexOf(target) > -1){
            flag2 = false;
            int index = localRoot.data.indexOf(target);
            deleteReturn = localRoot.data.theData.get(index).getData();
            deleteOccurrences = localRoot.data.theData.get(index).getCount() - 1;
            // decrease item's count by 1
            localRoot.data.remove(target);
            // if there are no elements left in the tree node
            if (localRoot.data.theData == null){
                return helper(localRoot);
            }
            // if its the largest item of the heap
            else if(index == 0 && deleteOccurrences == 0){
                deleted = localRoot.data;
                return helper(localRoot);
            }
            else {
                return localRoot;
            }
        }
        else {
            int compResult = target.compareTo(localRoot.data.theData.get(0).getData());
            // item is smaller than localRoot.data
            if (compResult < 0){
                localRoot.left = remove(localRoot.left, target);
                // if flag2 == true that means target item is not
                // in the left subtree, search in the right subtree
                if (flag2)
                    localRoot.right = remove(localRoot.right, target);
                return localRoot;
            }
            // item is greater than localRoot.data
            else if(compResult > 0){
                localRoot.right = remove(localRoot.right, target);
                return localRoot;
            }
            else {
                localRoot = remove(localRoot, target);
                return localRoot;
            }
        }
    }

    /**
     * Helper method
     * @param localRoot
     * @return
     */
    private Node<E> helper(Node<E> localRoot){
        // if there is no left child, return right child
        // which can also be null
        if (localRoot.left == null)
            return localRoot.right;
        // if there is no right child, return left child
        else if(localRoot.right == null)
            return localRoot.left;
        // Node being deleted has 2 child, replace the data
        // with inorder predecessor
        else {
            // The left child has no right child
            // Replace the data with the data in the left child
            if (localRoot.left.right == null){
                localRoot.data = localRoot.left.data;
                localRoot.left = localRoot.left.left;
            }
            // Search for the inorder predecessor and replace
            // deleted node's data with ip
            else {
                localRoot.data = findLargestChild(localRoot.left);
            }
            return localRoot;
        }
    }


    /**
     * Find the node that is the inorder
     * predecessor and replace it with its left child
     * @param parent The parent of possible inorder predecessor
     * @return The MaxHeap in the inorder predecessor
     */
    private MaxHeap<E> findLargestChild(Node<E> parent){
        // if the right child has no right child,
        // it is the inorder predecessor
        if(parent.right.right == null){
            MaxHeap<E> returnValue = parent.right.data;
            parent.right = parent.right.left;
            return returnValue;
        }
        else
            return findLargestChild(parent.right);
    }


}
