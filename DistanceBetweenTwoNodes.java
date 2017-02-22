import java.util.ArrayList;
import java.util.Collections;

/**
 * Distance between two nodes in a binary tree
 */
public class DistanceBetweenTwoNodes {

    private static ArrayList<TreeNode> path1 = new ArrayList<TreeNode>();
    private static ArrayList<TreeNode> path2 = new ArrayList<TreeNode>();
    private static ArrayList<TreeNode> lcaPath = new ArrayList<TreeNode>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);

        TreeNode node1 =  root.left.left;
        TreeNode node2 =  root.right.right;

        TreeNode lca = findLCA(root, node1, node2);
        findRootToNodePath(root, lca, lcaPath);
        Collections.reverse(lcaPath);

        System.out.println("Distance between two nodes: " + (path1.size() + path2.size() - (2 * lcaPath.size())));
    }

    public static TreeNode findLCA(TreeNode root, TreeNode node1, TreeNode node2) {
        findRootToNodePath(root, node1, path1);
        findRootToNodePath(root, node2, path2);

        Collections.reverse(path1);
        Collections.reverse(path2);

        TreeNode lca = path1.get(0);
        int size = path1.size();

        for (int i = 1; i < size; i++) {
            if (path1.get(i).data != path2.get(i).data) {
                return lca;
            } else {
                lca = path1.get(i);
            }
        }
        return lca;
    }

    public static boolean findRootToNodePath(TreeNode root, TreeNode node, ArrayList<TreeNode> path) {
        if (root == null) {
            return false;
        }

        if (root == node || findRootToNodePath(root.left, node, path) || findRootToNodePath(root.right, node, path)) {
            path.add(root);
            return true;
        }
        return false;
    }
}