import java.util.ArrayList;
import java.util.Collections;

/**
 * Find the least common ancestor between two nodes
 */
public class LeastCommonAncestorBT {

    public static void main(String[] args) {

        ArrayList<TreeNode> path1 = new ArrayList<TreeNode>();
        ArrayList<TreeNode> path2 = new ArrayList<TreeNode>();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);

        TreeNode node1 = root.left.left;
        TreeNode node2 = root.right.right;

        findRootToNodePath(root, node1, path1);
        Collections.reverse(path1);
        findRootToNodePath(root, node2, path2);
        Collections.reverse(path2);

        TreeNode lca = findLCA(path1, path2);
        System.out.println("Least Common Ancestor: " + lca.data);
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

    public static TreeNode findLCA(ArrayList<TreeNode> path1, ArrayList<TreeNode> path2) {
        int size = path1.size();
        TreeNode lca = path1.get(0);

        for(int i = 1; i < size; i++) {
            if(path1.get(i).data != path2.get(i).data) {
                return lca;
            } else {
                lca = path1.get(i);
            }
        }
        return lca;
    }
}
