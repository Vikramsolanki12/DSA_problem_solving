class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

public class FlattenBinaryTree {
    static TreeNode prev = null;

    public static void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void preorder(TreeNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.right;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        flatten(root);
        preorder(root);  // Output: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
    }
}
