package prep;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by dvasanth on 20/02/17.
 */
public class RootToNodePath {

    private static ArrayList<Integer> path = new ArrayList<Integer>();
    public static void main (String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);

        TreeNode key = root.left.right.left;

        findPath(root, key);

        Collections.reverse(path);

        for(int data : path) {
            System.out.print(data + "\t");
        }

    }

    public static boolean findPath(TreeNode tree, TreeNode key) {
        if (tree == null) {
            return false;
        }
        if (tree == key || findPath(tree.left, key) || findPath(tree.right, key)) {
            path.add(tree.data);
            return true;
        }
        return false;
    }
}
