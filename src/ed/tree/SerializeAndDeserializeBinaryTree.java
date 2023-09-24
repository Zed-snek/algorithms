package ed.tree;

/*
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored
in a file or memory buffer, or transmitted across a network connection link to be reconstructed later
in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized
to a string and this string can be deserialized to the original tree structure.
*/


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Codec {

    private static String compactElement(TreeNode element) {
        if (element == null)
            return "n";

        return "(" + String.valueOf(element.val) + ":" + compactElement(element.left) + "," + compactElement(element.right) + ")";
    }

    private static int leftBranchEndsAtIndex(String parent) {
        if (parent.charAt(parent.indexOf(':') + 1) == 'n')
            return parent.indexOf(':') + 3;

        int openBracket = 1;
        int closedBracket = 0;
        int lastIndex = parent.indexOf('(');

        int openIndex;
        int closedIndex;
        while (openBracket != closedBracket) { //index of last bracket of left branch
            openIndex = parent.indexOf('(', lastIndex + 1);
            closedIndex = parent.indexOf(')', lastIndex + 1);

            if (openIndex != -1 && openIndex < closedIndex) {
                lastIndex = openIndex;
                openBracket++;
            }
            else {
                lastIndex = closedIndex;
                closedBracket++;
            }
        }
        return lastIndex + 2; //last index become a character ","
    }

    private static TreeNode decompactData(String data) {
        if (data.charAt(0) == 'n')
            return null;

        int valueEndsAt = data.indexOf(':');
        int value = Integer.valueOf(data.substring(1, valueEndsAt));
        int endsAtIndex = leftBranchEndsAtIndex(data.substring(1, data.length() - 1));

        TreeNode node = new TreeNode(value);
        node.left = decompactData(data.substring(valueEndsAt + 1, endsAtIndex));
        node.right = decompactData(data.substring(endsAtIndex + 1, data.length() - 1));
        return node;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return null;
        String compacted = compactElement(root);
        return compacted;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null)
            return null;
        return decompactData(data);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
