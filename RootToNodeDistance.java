package prep;

/**
 * Created by dvasanth on 20/02/17.
 */
public class RootToNodeDistance {

    private static int nodes = 0;

    public static void main (String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);

        TreeNode node = root.left.right.left;

        findDistance(root, node);

        System.out.println("Distance: " + (nodes - 1));
    }

    public static boolean findDistance(TreeNode tree, TreeNode node) {
        if(tree == null) {
            return false;
        }
        if(tree == node || findDistance(tree.left, node) || findDistance(tree.right, node)) {
            ++nodes;
            return true;
        }
        return false;
    }
}
