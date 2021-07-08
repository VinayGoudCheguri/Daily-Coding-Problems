public class Problem_24 {
    // creating binary tree node
    public static class BinaryTreeNode {
        int val;
        boolean locked = false;
        BinaryTreeNode parent;
        BinaryTreeNode leftChild;
        BinaryTreeNode rightChild;
        int lockedDescendantCount = 0;
    }
    // returns whether the node is locked or not
    public static boolean is_locked(BinaryTreeNode node) {
        return node.locked;
    }
    // Checks if all the descendants or ancestors are unlocked
    private static boolean canLockOrUnlock(BinaryTreeNode node) {
        if(node.lockedDescendantCount > 0) {
            return false;
        }
        BinaryTreeNode parentNode = node.parent;
        while(parentNode != null) {
            if(parentNode.locked) {
                return false;
            }
            parentNode = parentNode.parent;
        }
        return true;
    }
    public static boolean lock(BinaryTreeNode node) {
        if(is_locked(node)) {
            return true;
        }
        if(!canLockOrUnlock(node)) {
            return false;
        }
        node.locked = true;
        BinaryTreeNode parentNode = node.parent;
        // updates lockedDescendantCount count
        while(parentNode != null) {
            parentNode.lockedDescendantCount += 1;
            parentNode = parentNode.parent;
        }
            return true;
    }
    public static boolean unlock(BinaryTreeNode node) {
        if(!is_locked(node)) {
            return true;
        }
        if(!canLockOrUnlock(node)) {
            return false;
        }
        node.locked = false;
        BinaryTreeNode parentNode = node.parent;
        // updates lockedDescendantCount count
        while(parentNode != null) {
            parentNode.lockedDescendantCount -= 1;
            parentNode = parentNode.parent;
        }
        return true;
    }
    public static void main(String []args){
        // Creating an example binary tree
        BinaryTreeNode Parent = new BinaryTreeNode();
        BinaryTreeNode child1 = new BinaryTreeNode();
        BinaryTreeNode child2 = new BinaryTreeNode();
        Parent.val =0;
        Parent.locked = false;
        Parent.parent = null;
        Parent.leftChild = child1;
        Parent.rightChild = child2;
        Parent.lockedDescendantCount = 0;
        child1.val =0;
        child1.locked = false;
        child1.parent = Parent;
        child1.leftChild = null;
        child1.rightChild = null;
        child1.lockedDescendantCount = 0;
        child2.val =0;
        child2.locked = false;
        child2.parent = Parent;
        child2.leftChild = null;
        child2.rightChild = null;
        child2.lockedDescendantCount = 0;
        System.out.println(lock(Parent));
    }
}
