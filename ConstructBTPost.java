import java.util.Scanner;

/**
 * Given Inorder and Postorder traversals, construct a binary tree.
 */
public class ConstructBTPost {

    static int postInd;

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of nodes in tree");
        int n = in.nextInt();
        postInd = n-1;

        System.out.println("Enter inorder traversal");
        int[] inArr = new int[n];
        for (int i = 0; i < n; i++) {
            inArr[i] = in.nextInt();
        }

        System.out.println("Enter postorder traversal");
        int[] postArr = new int[n];
        for (int i = 0; i < n; i++) {
            postArr[i] = in.nextInt();
        }

        TreeNode tree = buildTree(inArr, 0, n-1, postArr);
        printTree(tree);
    }

    public static TreeNode buildTree (int[] inArr, int inStart, int inEnd, int[] postArr) {

        if(inStart > inEnd) {
            return null;
        }

        TreeNode tree = new TreeNode(postArr[postInd--]);
        if(inStart == inEnd) {
            return tree;
        }

        int inIndex = findIndex(inArr, inStart, inEnd, tree.data);
        tree.right = buildTree(inArr, inIndex+1, inEnd, postArr);
        tree.left = buildTree(inArr, inStart, inIndex-1, postArr);
        return tree;
    }

    public static int findIndex(int[] arr, int start, int end, int data) {
        int index = -1;
        for (int i = start; i <= end ; i++) {
            if (data == arr[i]) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void printTree(TreeNode tree) {
        if (tree == null) {
            return;
        }
        printTree(tree.left);
        System.out.print(tree.data + "\t");
        printTree(tree.right);
    }
}
