package com.bettercsw.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * Output: ["1->2->5", "1->3"]
 * <p>
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 *
 * @author csw
 * @date 2020/4/23 16:10
 */
public class P257 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> values = new ArrayList<>();
        backTracking(root, values, result);
        return result;
    }

    private void backTracking(TreeNode node, List<Integer> values, List<String> result) {
        if (node == null) {
            return;
        }
        values.add(node.val);
        if (node.left == null && node.right == null) {
            result.add(buildPaths(values));
        } else {
            backTracking(node.left, values, result);
            backTracking(node.right, values, result);
        }
        values.remove(values.size() - 1);
    }

    private String buildPaths(List<Integer> values) {
        StringBuilder sb = new StringBuilder();
        int size = values.size();
        for (int i = 0; i < size; i++) {
            sb.append(values.get(i).toString());
            if (i != size - 1) {
                sb.append("->");
            }

        }
        return sb.toString();
    }

}
