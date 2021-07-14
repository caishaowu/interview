package com.bettercsw.search;

import lombok.AllArgsConstructor;

/**
 * 我们有1千万个整数，整数的范围在 1 到 1亿之间。如何快速查找某个整数是否在这1千万个整数中呢？
 *
 * @author csw
 * @date 2020/8/10 10:20
 */
@AllArgsConstructor
public class BitMap {
    private char[] bytes;
    private int nBits;

    public void set(int k) {
        if (k > nBits) return;
        int byteIndex = k / 16;
        int bitIndex = k % 16;
        bytes[byteIndex] |= (1 << bitIndex);
    }

    public boolean get(int k) {
        if (k > nBits) return false;
        int byteIndex = k / 16;
        int bitIndex = k % 16;
        return (bytes[byteIndex] & (1 << bitIndex)) != 0;
    }
}
