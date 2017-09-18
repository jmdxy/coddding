package com.mycode.argorithm.leetcode;

import static org.junit.Assert.assertThat;

import com.mycode.argorithm.dac.Power;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Implement pow(x, n).
 *
 * @author zhangxu
 * @see https://leetcode.com/problems/powx-n/
 * @see Power
 */
public class PowXN {

    /**
     * 通用的二分查找方式
     * <pre>
     * 6^2 = 6^1 * 6^1 = 6 * 6 = 36
     * 6^1 = 6 * 6^0 * 6^0 = 6 * 1 * 1 = 6
     * 6^0 = 1
     *
     * 6^3 = 6 * 6^2 * 6^2
     *
     * 6 ^-3 = ( 6^-1 * 6^-1) / 6
     * </pre>
     * <p>
     * {@link Power}只支持整数以及正数的DAC
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double temp = myPow(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            if (n > 0) {
                return x * temp * temp;
            } else {
                return (temp * temp) / x;
            }
        }
    }

    @Test
    public void test() {
        assertThat(Math.pow(36, 2), Matchers.is(1296d));
    }
}
