package IndeedPrime;

public class SearchBST {
    public static void main(String[] args) {
        TreeNode root=createBST(1,2,3,4,5);
        System.out.println(findBST(root,4));
    }

    public static TreeNode findBST(TreeNode root, int data) {
        if (root == null)
            return null;
        if (root.data == data)
            return root;
        if (data < root.data)
            return root.left != null ? findBST(root.left, data) : null;
        else
            return root.right != null ? findBST(root.right, data) : null;
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;

        public TreeNode(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

    public static TreeNode createBST(int... array) {
        return arrayToBST(array, 0, array.length - 1);
    }

    private static TreeNode arrayToBST(int[] array, int low, int high) {
        if (low > high)
            return null;
        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(array[mid]);
        root.left=arrayToBST(array, low, mid - 1);
        root.right=arrayToBST(array, mid + 1, high);
        return root;
    }

}
