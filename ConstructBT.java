import java.util.Scanner;

/**
 * Given Inorder and Preorder traversals, construct a binary tree.
 */
public class ConstructBT {
    static int preInd = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of nodes present");
        int n = in.nextInt();
        System.out.println("Enter inorder traversal");
        int[] inArr = new int[n];
        for (int i = 0; i < n; i++) {
            inArr[i] = in.nextInt();
        }
        System.out.println("Enter preorder traversal");
        int[] preArr = new int[n];
        for (int i = 0; i < n; i++) {
            preArr[i] = in.nextInt();
        }
        TreeNode tree = buildTree(preArr, inArr, 0, n - 1);
		System.out.println("Printing the constructed tree (Inorder)...");
        printTree(tree);
    }

    public static TreeNode buildTree(int[] preArr, int[] inArr, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preArr[preInd++]);
        if (inStart == inEnd) {
            return treeNode;
        }
        int inInd = findIndex(inArr, inStart, inEnd, treeNode.data);
        treeNode.left = buildTree(preArr, inArr, inStart, inInd - 1);
        treeNode.right = buildTree(preArr, inArr, inInd + 1, inEnd);

        return treeNode;
    }

    public static void printTree(TreeNode tree) {
        if (tree == null) {
            return;
        }
        printTree(tree.left);
        System.out.print(tree.data + "\t");
        printTree(tree.right);
    }

    public static int findIndex(int[] arr, int start, int end, int element) {
        int index = -1;
        for (int i = start; i <= end; i++) {
            if (element == arr[i]) {
                index = i;
                break;
            }
        }
        return index;
    }
}
