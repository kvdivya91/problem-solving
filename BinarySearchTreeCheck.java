import java.util.ArrayList;

/**
 * Created by dvasanth on 04/03/17.
 */
public class BinarySearchTreeCheck {

    private static ArrayList<Integer> inorderItems = new ArrayList<Integer>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);
        root.right.left.right = new TreeNode(7);

        inorder(root);
        boolean isBST = checkIfSorted(inorderItems);
        if (isBST) {
            System.out.println("Binary Search Tree");
        } else {
            System.out.println("Not a Binary Search Tree");
        }
    }

    public static boolean checkIfSorted(ArrayList<Integer> items) {
        boolean isSorted = true;
        int size = items.size();
        for(int i = 0; i < size-1; i++) {
            if (items.get(i) > items.get(i+1)) {
                isSorted = false;
                break;
            }
        }
        return isSorted;
    }

    public static void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        inorderItems.add(root.data);
        inorder(root.right);
    }

}
