package com.mycode.argorithm.leetcode;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.mycode.argorithm.leetcode.support.TreeNode;
import com.mycode.argorithm.leetcode.support.TreeNodeHelper;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values
 * along the path equals the given sum.
 * <p/>
 * For example:
 * Given the below binary tree and sum = 22,
 * <pre>
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * </pre>
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * <p/>
 * 解题思路：递归、深度优先搜索
 *
 * @author zhangxu
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    @Test
    public void test() {
        int[] arr1 = new int[] {5, 4, 8, 11, 13, 4, 7, 2, 1};
        TreeNode tree1 = TreeNodeHelper.init(arr1);
        assertThat(hasPathSum(tree1, 22), Matchers.is(true));
        assertThat(hasPathSum(tree1, 66), Matchers.is(false));
    }
}
